package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.google.gson.Gson;

import load.test.api.PostConfirmAcceptAPI;
import load.test.api.PostExpressmanLoginAPI;
import load.test.requestobject.PostConfirmAcceptRequestObject;
import load.test.requestobject.PostLoginRequestObject;

public class ConfirmAcceptLoacTC extends BaseLoadTC {
	PostExpressmanLoginAPI postExpressmanLoginAPI = new PostExpressmanLoginAPI();
	
	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test3-api.mishi.cn");
		params.addArgument("phoneNumber", "18616521543");
		params.addArgument("password", "275011");
		params.addArgument("orderId", "275011");
		return params;
	}

	@Override
	public void setupTest(JavaSamplerContext arg0) {
		this.results = new SampleResult();
		this.postExpressmanLoginAPI.setHost(String.format("http://%s/mishi.user.expressman.login?p-apiv=2.1&p=%s",
				arg0.getParameter("host"), arg0.getParameter("phoneNumber")));
		this.postExpressmanLoginAPI.setApiName("mishi.user.expressman.login");
		this.postExpressmanLoginAPI.setRequestObject(new PostLoginRequestObject());
		this.postExpressmanLoginAPI.getRequestObject().setNeedEncrypt("false");
		this.postExpressmanLoginAPI.getRequestObject().setPassword(arg0.getParameter("password"));
		this.postExpressmanLoginAPI.getRequestObject().setPhoneNumber(arg0.getParameter("phoneNumber"));
		this.postExpressmanLoginAPI.serializeRequestObject(this.postExpressmanLoginAPI.getRequestObject());
		try {
			this.postExpressmanLoginAPI.sendRequest(null);
			result += new Gson().toJson(this.postExpressmanLoginAPI.getHost());
			result += new Gson().toJson(this.postExpressmanLoginAPI.getRequestObject());
			result += new Gson().toJson(postExpressmanLoginAPI.getEntitystr());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException,
			InvalidKeyException, NoSuchAlgorithmException {
		PostConfirmAcceptAPI postConfirmAcceptAPI = new PostConfirmAcceptAPI();
		postConfirmAcceptAPI.setHost(String.format("http://%s/gw/logistics.assigned.confirmAccept/1.0",
				arg0.getParameter("host")));
		postConfirmAcceptAPI.setApiName("logistics.assigned.confirmAccept");
		postConfirmAcceptAPI.setRequestObject(new PostConfirmAcceptRequestObject());
		postConfirmAcceptAPI.getRequestObject().setOrderIdList(new ArrayList<String>());
		postConfirmAcceptAPI.getRequestObject().getOrderIdList().add(arg0.getParameter("orderId"));
		postConfirmAcceptAPI.getRequestObject().setMergerOrderId("no_merger_order");
		
		results.sampleStart();
		postConfirmAcceptAPI.serializeRequestObject(postConfirmAcceptAPI.getRequestObject());
		postConfirmAcceptAPI.sendRequest(this.postExpressmanLoginAPI.getCookieStore());
		results.sampleEnd();
		result += new Gson().toJson(postConfirmAcceptAPI.getEntitystr());
		if (!postConfirmAcceptAPI.getEntitystr().contains("\"success\":true") && !postConfirmAcceptAPI.getEntitystr().contains("\"errMsg\":\"该订单已被别人抢走\"")) {
			throw new IOException();
		}
	}

}
