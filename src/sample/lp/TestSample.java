package sample.lp;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class TestSample implements JavaSamplerClient {

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test-api.mishi.cn");
		return params;
	}

	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		System.out.println(arg0.getParameter("host"));
		return new SampleResult();
	}

	@Override
	public void setupTest(JavaSamplerContext arg0) {
	}

	@Override
	public void teardownTest(JavaSamplerContext arg0) {
	}
}
