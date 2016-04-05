package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.google.gson.Gson;

import load.test.api.PostRegisterAPI;
import load.test.api.PostSendSmsCaptchaAPI;
import load.test.api.PostValidateSmsCaptchaAPI;
import load.test.requestobject.PostRegisterRequestObject;
import load.test.requestobject.PostSendSmsCaptchaRequestObject;
import load.test.requestobject.PostValidateSmsCaptchaRequestObject;
import load.test.responseobject.PostRegisterResponseObject;
import load.test.responseobject.PostSendSmsCaptchaResponseObject;
import load.test.responseobject.PostValidateSmsCaptchaResponseObject;

public class RegisterLoadTC extends BaseLoadTC {
	PostSendSmsCaptchaResponseObject responseObject1;

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

		PostSendSmsCaptchaAPI postSendSmsCaptchaAPI = new PostSendSmsCaptchaAPI();
		postSendSmsCaptchaAPI
				.setHost(String.format("http://%s/gw/mishi.captcha.sms.send/1.0", arg0.getParameter("host")));
		postSendSmsCaptchaAPI.setApiName("mishi.captcha.sms.send");
		postSendSmsCaptchaAPI.setRequestObject(new PostSendSmsCaptchaRequestObject());
		postSendSmsCaptchaAPI.getRequestObject().setPhoneNumber(arg0.getParameter("phoneNumber"));
		postSendSmsCaptchaAPI.getRequestObject().setType(1);
		postSendSmsCaptchaAPI.serializeRequestObject(postSendSmsCaptchaAPI.getRequestObject());
		try {
			responseObject1 = postSendSmsCaptchaAPI.getResponseObject(null, PostSendSmsCaptchaResponseObject.class);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PostValidateSmsCaptchaAPI postValidateSmsCaptchaAPI = new PostValidateSmsCaptchaAPI();
		postValidateSmsCaptchaAPI
				.setHost(String.format("http://%s/gw/mishi.captcha.sms.validate/1.0", arg0.getParameter("host")));
		postValidateSmsCaptchaAPI.setApiName("mishi.captcha.sms.validate");
		postValidateSmsCaptchaAPI.setRequestObject(new PostValidateSmsCaptchaRequestObject());
		postValidateSmsCaptchaAPI.getRequestObject().setToken(responseObject1.getData().getToken());
		postValidateSmsCaptchaAPI.getRequestObject().setType(1);
		postValidateSmsCaptchaAPI.getRequestObject().setCaptcha("1111");
		postValidateSmsCaptchaAPI.serializeRequestObject(postValidateSmsCaptchaAPI.getRequestObject());
		try {
			PostValidateSmsCaptchaResponseObject responseObject2 = postValidateSmsCaptchaAPI.getResponseObject(null,
					PostValidateSmsCaptchaResponseObject.class);
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
		results.setDataEncoding("utf-8");
		results.setContentType("application/json");
		result += phoneNumber;

		results.sampleStart();
		PostRegisterAPI postRegisterAPI = new PostRegisterAPI();
		postRegisterAPI.setHost(String.format("http://%s/user/register", arg0.getParameter("host")));
		postRegisterAPI.setRequestObject(new PostRegisterRequestObject());
		postRegisterAPI.getRequestObject().setToken(responseObject1.getData().getToken());
		postRegisterAPI.getRequestObject().setNickname("负载账户昵称");
		postRegisterAPI.getRequestObject().setPassword("qqqqqq");
		postRegisterAPI.getRequestObject().setNeedEncrypt(false);
		postRegisterAPI.serializeRequestObject(postRegisterAPI.getRequestObject());
		result += new Gson().toJson(postRegisterAPI.getRequestObject());
		PostRegisterResponseObject responseObject3 = postRegisterAPI.getResponseObject(null,
				PostRegisterResponseObject.class);
		result += new Gson().toJson(responseObject3);
		responseObject3.getData().setCookieStore(postRegisterAPI.getCookieStore());
		results.sampleEnd();

		if (!postRegisterAPI.getEntitystr().contains("\"success\":true")) {
			throw new IOException();
		}
	}

}
