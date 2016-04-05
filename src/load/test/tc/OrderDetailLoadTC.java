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

import load.test.api.GetChefOrderStatAPI;
import load.test.api.GetOrderDetailAPI;

public class OrderDetailLoadTC extends BaseLoadTC {

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test-api.mishi.cn");
		params.addArgument("phoneNumber", "12000000000");
		params.addArgument("password", "qqqqqq");
		params.addArgument("orderId", "1568837200872010");
		return params;
	}

	@Override
	public void setupTest(JavaSamplerContext arg0) {
		this.results = new SampleResult();
		phoneNumber = arg0.getParameter("phoneNumber");
		password = arg0.getParameter("password");

		this.login(arg0);
	}

	@Override
	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException,
			InvalidKeyException, NoSuchAlgorithmException {
		GetOrderDetailAPI getOrderDetailAPI = new GetOrderDetailAPI();
		getOrderDetailAPI.setHost(String.format("http://%s/gw/mishi.order.detail.get/1.0", arg0.getParameter("host")));
		getOrderDetailAPI.setApiName("mishi.order.detail.get");
		getOrderDetailAPI.setOrderId(arg0.getParameter("orderId"));
		results.sampleStart();
		getOrderDetailAPI.sendRequest(this.postLoginResponseObject.getCookieStore());
		if (!getOrderDetailAPI.getEntitystr().contains("\"success\":true")) {
			result += new Gson().toJson(getOrderDetailAPI.getEntitystr());
			throw new IOException();
		}
		result += getOrderDetailAPI.getEntitystr();
		results.sampleEnd();
	}

}
