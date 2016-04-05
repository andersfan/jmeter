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

import load.test.api.PostOrderAmountAPI;
import load.test.requestobject.Goods;
import load.test.requestobject.PostOrderAmountRequestObject;

public class OrderAmountLoadTC extends BaseLoadTC {

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test-api.mishi.cn");
		params.addArgument("phoneNumber", "12000000000");
		params.addArgument("password", "qqqqqq");
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
		PostOrderAmountAPI postOrderAmountAPI = new PostOrderAmountAPI();
		postOrderAmountAPI.setHost(String.format("http://%s/api/order/orderAmount", arg0.getParameter("host")));
		postOrderAmountAPI.setRequestObject(new PostOrderAmountRequestObject());
		postOrderAmountAPI.getRequestObject().setShopId(28690);
		postOrderAmountAPI.getRequestObject().setGoodsList(new ArrayList<Goods>());
		Goods goods = new Goods();
		goods.setCount(1);
		goods.setGoodsId("54299");
		goods.setName("yhhg");
		goods.setName("price");
		postOrderAmountAPI.getRequestObject().getGoodsList().add(goods);
		postOrderAmountAPI.serializeRequestObject(postOrderAmountAPI.getRequestObject());
		results.sampleStart();
		postOrderAmountAPI.sendRequest(this.postLoginResponseObject.getCookieStore());
		results.sampleEnd();
		if (!postOrderAmountAPI.getEntitystr().contains("\"success\":true")) {
			result += new Gson().toJson(postOrderAmountAPI.getEntitystr());
			throw new IOException();
		}
	}

}
