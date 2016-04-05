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

import load.test.api.PostLoginAPI;
import load.test.api.PostMergeOrderAPI;
import load.test.requestobject.PostLoginRequestObject;
import load.test.responseobject.PostLoginResponseObject;

public class MergeOrderLoadTC extends BaseLoadTC {

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test-api.mishi.cn");
		params.addArgument("random", "123456");
		return params;
	}

	@Override
	public void setupTest(JavaSamplerContext arg0) {
		this.results = new SampleResult();
	}

	@Override
	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException,
			InvalidKeyException, NoSuchAlgorithmException {
		PostMergeOrderAPI postMergeOrderAPI = new PostMergeOrderAPI();
		postMergeOrderAPI.setHost(String.format("http://%s/logistics/test/mergerOrder", arg0.getParameter("host")));
		postMergeOrderAPI.getUriParams().put("random", arg0.getParameter("random"));
		results.sampleStart();
		postMergeOrderAPI.sendRequest(null);
		result += postMergeOrderAPI.getHost();
		result += postMergeOrderAPI.getEntitystr();
		if (!postMergeOrderAPI.getEntitystr().contains("\"success\":true")) {
			result += new Gson().toJson(postMergeOrderAPI.getEntitystr());
			throw new IOException();
		}
		results.sampleEnd();	
	}
}
