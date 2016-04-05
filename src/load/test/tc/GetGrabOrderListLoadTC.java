package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.google.gson.Gson;

import load.test.api.GetGrabOrderListAPI;
import load.test.api.PostExpressmanLoginAPI;
import load.test.api.PostUpdateExpressManStatusAPI;
import load.test.requestobject.PostLoginRequestObject;
import load.test.requestobject.PostUpdateExpressManStatusRequestObject;

public class GetGrabOrderListLoadTC extends BaseLoadTC {
	PostExpressmanLoginAPI postExpressmanLoginAPI = new PostExpressmanLoginAPI();

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test3-api.mishi.cn");
		params.addArgument("phoneNumber", "18616521543");
		params.addArgument("password", "275011");
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
		
		PostUpdateExpressManStatusAPI postUpdateExpressManStatusAPI = new PostUpdateExpressManStatusAPI();
		postUpdateExpressManStatusAPI.setHost(String.format("http://%s/logistics/expressman/updatestatus",
				arg0.getParameter("host")));
		postUpdateExpressManStatusAPI.setRequestObject(new PostUpdateExpressManStatusRequestObject());
		postUpdateExpressManStatusAPI.getRequestObject().setStatus(0);
		postUpdateExpressManStatusAPI.serializeRequestObject(postUpdateExpressManStatusAPI.getRequestObject());
		try {
			postUpdateExpressManStatusAPI.sendRequest(this.postExpressmanLoginAPI.getCookieStore());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException,
			InvalidKeyException, NoSuchAlgorithmException {
		GetGrabOrderListAPI getGrabOrderListAPI = new GetGrabOrderListAPI();
		getGrabOrderListAPI.setHost(String.format("http://%s/gw/logistics.order.getGrabOrderList/1.0?lng=%s&lat=%s",
				arg0.getParameter("host"), "120.089262", "30.289698"));
		getGrabOrderListAPI.setApiName("logistics.order.getGrabOrderList");
		result += getGrabOrderListAPI.getHost();
		results.sampleStart();
		getGrabOrderListAPI.sendRequest(this.postExpressmanLoginAPI.getCookieStore());
		results.sampleEnd();
		result += new Gson().toJson(getGrabOrderListAPI.getEntitystr());
		if (!getGrabOrderListAPI.getEntitystr().contains("\"success\":true")) {
			throw new IOException();
		}
	}

}
