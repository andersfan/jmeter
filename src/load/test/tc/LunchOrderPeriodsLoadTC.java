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

import load.test.api.PostOrderPeriodsAPI;
import load.test.requestobject.PostOrderPeriodsRequestObject;


public class LunchOrderPeriodsLoadTC extends BaseLoadTC {

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test-api.mishi.cn");
		params.addArgument("phoneNumber", "12000000000");
		params.addArgument("password", "qqqqqq");
		params.addArgument("logisticsType", "1");	
		params.addArgument("shopId", "28823");
		params.addArgument("goodsId", "53924");
		params.addArgument("logisticsTime", "2015-10-29");
		params.addArgument("logisticsId", "91794");
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
		results.setDataEncoding("utf-8");
		results.setContentType("application/json");
		result += phoneNumber;

		results.sampleStart();
		PostOrderPeriodsAPI postOrderPeriodsAPI = new PostOrderPeriodsAPI();
		postOrderPeriodsAPI.setHost(String.format("http://%s/api/order/periods",arg0.getParameter("host")));
		PostOrderPeriodsRequestObject postOrderPeriodsRequestObject=new PostOrderPeriodsRequestObject();
		postOrderPeriodsRequestObject.setGoodsIds(new ArrayList<Integer>());
		postOrderPeriodsRequestObject.getGoodsIds().add(Integer.parseInt(arg0.getParameter("goodsId")));
		postOrderPeriodsRequestObject.setLogisticsId(Integer.parseInt(arg0.getParameter("logisticsId")));
		postOrderPeriodsRequestObject.setLogisticsTime(arg0.getParameter("logisticsTime"));
		postOrderPeriodsRequestObject.setLogisticsType(Integer.parseInt(arg0.getParameter("logisticsType")));
		postOrderPeriodsRequestObject.setShopId(Integer.parseInt(arg0.getParameter("shopId")));
		postOrderPeriodsAPI.serializeRequestObject(postOrderPeriodsRequestObject);
		postOrderPeriodsAPI.sendRequest(postLoginResponseObject.getCookieStore());
		result += new Gson().toJson(postOrderPeriodsRequestObject);
		result += postOrderPeriodsAPI.getEntitystr();
		if (!postOrderPeriodsAPI.getEntitystr().contains("\"success\":true")) {
			result += new Gson().toJson(postOrderPeriodsAPI.getEntitystr());
			throw new IOException();
		}
		results.sampleEnd();
	}

}
