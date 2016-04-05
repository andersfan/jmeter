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
import load.test.api.GetFundLunchIncomeAPI;

public class LunchFundIncomeLoadTC extends BaseLoadTC {

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
		GetFundLunchIncomeAPI getFundLunchIncomeAPI = new GetFundLunchIncomeAPI();
		getFundLunchIncomeAPI
				.setHost(String.format("http://%s/gw/mishi.fund.lunch.income/1.0", arg0.getParameter("host")));
		getFundLunchIncomeAPI.setApiName("mishi.fund.lunch.income");
		results.sampleStart();
		getFundLunchIncomeAPI.sendRequest(this.postLoginResponseObject.getCookieStore());
		if (!getFundLunchIncomeAPI.getEntitystr().contains("\"success\":true")) {
			result += new Gson().toJson(getFundLunchIncomeAPI.getEntitystr());
			throw new IOException();
		}
		result += getFundLunchIncomeAPI.getEntitystr();
		results.sampleEnd();
	}

}
