package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.google.gson.Gson;

import load.test.api.PostLoginAPI;
import load.test.requestobject.PostLoginRequestObject;
import load.test.responseobject.PostLoginResponseObject;

public abstract class BaseLoadTC implements JavaSamplerClient {
	protected String phoneNumber;
	protected String password;
	protected SampleResult results;
	protected String result = "";
	protected PostLoginResponseObject postLoginResponseObject = null;
	
	public abstract void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException, InvalidKeyException, NoSuchAlgorithmException;

	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		phoneNumber = arg0.getParameter("phoneNumber");
		password = arg0.getParameter("password");

		try {
			test(arg0);

			results.setSuccessful(true);
		} catch (Throwable e) {
			results.setSuccessful(false);
			result+=e.getStackTrace().toString();
			for(StackTraceElement element :e.getStackTrace())
			{
				result+=element.getClassName();
				result+=element.getMethodName();
				result+=element.getLineNumber();
				result+=element.getFileName();
			}
			e.printStackTrace();
		} finally {
			results.setResponseMessage(result);
			results.sampleEnd();
		}
		return results;
	}

	@Override
	public void teardownTest(JavaSamplerContext arg0) {
		// TODO Auto-generated method stub		
	}

	
	protected void login(JavaSamplerContext arg0) {
		PostLoginAPI postLoginAPI = new PostLoginAPI();
		postLoginAPI.setHost(String.format("http://%s/gw/mishi.user.lunch.login/1.0", arg0.getParameter("host")));
		postLoginAPI.setApiName("mishi.user.lunch.login");
		PostLoginRequestObject postLoginRequestObject = new PostLoginRequestObject();
		postLoginAPI.setRequestObject(postLoginRequestObject);
		postLoginAPI.getRequestObject().setNeedEncrypt("false");
		postLoginAPI.getRequestObject().setPhoneNumber(phoneNumber);
		postLoginAPI.getRequestObject().setPassword(password);
		postLoginAPI.serializeRequestObject(postLoginAPI.getRequestObject());
		result += new Gson().toJson(postLoginRequestObject);
		try {
			postLoginResponseObject = postLoginAPI.getResponseObject(null, PostLoginResponseObject.class);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		postLoginResponseObject.setCookieStore(postLoginAPI.getCookieStore());
		result += new Gson().toJson(postLoginResponseObject);
	}

}
