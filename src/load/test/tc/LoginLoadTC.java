package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.google.gson.Gson;

import load.test.api.PostLoginAPI;
import load.test.api.PostRegisterAPI;
import load.test.api.PostSendSmsCaptchaAPI;
import load.test.api.PostValidateSmsCaptchaAPI;
import load.test.requestobject.PostLoginRequestObject;
import load.test.requestobject.PostRegisterRequestObject;
import load.test.requestobject.PostSendSmsCaptchaRequestObject;
import load.test.requestobject.PostValidateSmsCaptchaRequestObject;
import load.test.responseobject.PostLoginResponseObject;
import load.test.responseobject.PostRegisterResponseObject;
import load.test.responseobject.PostSendSmsCaptchaResponseObject;
import load.test.responseobject.PostValidateSmsCaptchaResponseObject;

public class LoginLoadTC extends BaseLoadTC {

	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException, InvalidKeyException,
			NoSuchAlgorithmException {
		results.setDataEncoding("utf-8");
		results.setContentType("application/json");
		result += phoneNumber;

		PostLoginAPI postLoginAPI = new PostLoginAPI();
		postLoginAPI.setHost("http://test-api.mishi.cn/gw/mishi.user.lunch.login/1.0");
		postLoginAPI.setApiName("mishi.user.lunch.login");
		PostLoginRequestObject postLoginRequestObject = new PostLoginRequestObject();
		postLoginAPI.setRequestObject(postLoginRequestObject);
		postLoginAPI.getRequestObject().setNeedEncrypt("false");
		postLoginAPI.getRequestObject().setPhoneNumber(phoneNumber);
		postLoginAPI.getRequestObject().setPassword(password);
		postLoginAPI.serializeRequestObject(postLoginAPI.getRequestObject());
		result += new Gson().toJson(postLoginRequestObject);
		results.sampleStart();
		PostLoginResponseObject responseObject = postLoginAPI.getResponseObject(null, PostLoginResponseObject.class);
		results.sampleEnd();
		responseObject.setCookieStore(postLoginAPI.getCookieStore());
		result += new Gson().toJson(responseObject);
	}

	@Override
	public void setupTest(JavaSamplerContext arg0) {
		this.results = new SampleResult();
		phoneNumber = arg0.getParameter("phoneNumber");
		password = arg0.getParameter("password");

//		// TODO Auto-generated method stub
//		PostSendSmsCaptchaAPI postSendSmsCaptchaAPI = null;
//		try {
//			postSendSmsCaptchaAPI = new PostSendSmsCaptchaAPI();
//		} catch (InvalidKeyException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		} catch (NoSuchAlgorithmException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		} catch (UnsupportedEncodingException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		}
//
//		postSendSmsCaptchaAPI.setHost("http://test-api.mishi.cn/gw/mishi.captcha.sms.send/1.0");
//		postSendSmsCaptchaAPI.setApiName("mishi.captcha.sms.send");
//		PostSendSmsCaptchaRequestObject postSendSmsCaptchaRequestObject = new PostSendSmsCaptchaRequestObject();
//		postSendSmsCaptchaRequestObject.setPhoneNumber(phoneNumber);
//		postSendSmsCaptchaRequestObject.setType(1);
//		postSendSmsCaptchaAPI.setRequestObject(postSendSmsCaptchaRequestObject);
//		postSendSmsCaptchaAPI.serializeRequestObject(postSendSmsCaptchaAPI.getRequestObject());
//		results.setRequestHeaders(postSendSmsCaptchaAPI.getRequestHeaderString());
//		result += new Gson().toJson(postSendSmsCaptchaRequestObject);
//		PostSendSmsCaptchaResponseObject postSendSmsCaptchaResponseObject = null;
//		try {
//			postSendSmsCaptchaResponseObject = postSendSmsCaptchaAPI.getResponseObject(null,
//					PostSendSmsCaptchaResponseObject.class);
//		} catch (ClientProtocolException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		result += new Gson().toJson(postSendSmsCaptchaResponseObject);
//
//		PostValidateSmsCaptchaAPI postValidateSmsCaptchaAPI = new PostValidateSmsCaptchaAPI();
//		postValidateSmsCaptchaAPI.setHost("http://test-api.mishi.cn/gw/mishi.captcha.sms.validate/1.0");
//		postValidateSmsCaptchaAPI.setApiName("mishi.captcha.sms.validate");
//		PostValidateSmsCaptchaRequestObject postValidateSmsCaptchaRequestObject = new PostValidateSmsCaptchaRequestObject();
//		postValidateSmsCaptchaAPI.setRequestObject(postValidateSmsCaptchaRequestObject);
//		postValidateSmsCaptchaAPI.getRequestObject().setToken(postSendSmsCaptchaResponseObject.getData().getToken());
//		postValidateSmsCaptchaAPI.getRequestObject().setType(1);
//		postValidateSmsCaptchaAPI.getRequestObject().setCaptcha("1111");
//		postValidateSmsCaptchaAPI.serializeRequestObject(postValidateSmsCaptchaAPI.getRequestObject());
//		result += new Gson().toJson(postValidateSmsCaptchaRequestObject);
//		PostValidateSmsCaptchaResponseObject postValidateSmsCaptchaResponseObject = null;
//		try {
//			postValidateSmsCaptchaResponseObject = postValidateSmsCaptchaAPI.getResponseObject(null,
//					PostValidateSmsCaptchaResponseObject.class);
//		} catch (ClientProtocolException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		result += new Gson().toJson(postValidateSmsCaptchaResponseObject);
//
//		PostRegisterAPI postRegisterAPI = new PostRegisterAPI();
//		postRegisterAPI.setHost("http://test-api.mishi.cn/user/register?rnd=" + phoneNumber);
//		result += postRegisterAPI.getHost();
//		PostRegisterRequestObject postRegisterRequestObject = new PostRegisterRequestObject();
//		postRegisterAPI.setRequestObject(postRegisterRequestObject);
//		postRegisterAPI.getRequestObject().setNeedEncrypt(false);
//		postRegisterAPI.getRequestObject().setPassword(password);
//		postRegisterAPI.getRequestObject().setNickname("隔壁老王");
//		postRegisterAPI.getRequestObject().setToken(postSendSmsCaptchaResponseObject.getData().getToken());
//		postRegisterAPI.serializeRequestObject(postRegisterAPI.getRequestObject());
//		result += new Gson().toJson(postRegisterRequestObject);
//
//		try {
//			PostRegisterResponseObject postRegisterResponseObject = postRegisterAPI.getResponseObject(null,
//					PostRegisterResponseObject.class);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		result += postRegisterAPI.getEntitystr();
	}
}
