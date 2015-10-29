package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public abstract class BaseLoadTC implements JavaSamplerClient {
	protected String phoneNumber;
	protected String password;
	protected SampleResult results;
	protected String result = "";
	
	public abstract void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException, InvalidKeyException, NoSuchAlgorithmException;
	
	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("phoneNumber", "12000000000");
		params.addArgument("password", "qqqqqq");
		return params;
	}

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

}
