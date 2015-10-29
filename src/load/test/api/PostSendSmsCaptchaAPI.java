package load.test.api;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostSendSmsCaptchaRequestObject;


/*
 * 用户注册：发送手机短信验证码 post请求
 */
public class PostSendSmsCaptchaAPI extends PostAPI {
	public PostSendSmsCaptchaAPI() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		this.setCommonParamAndHeader_New();
	}
	
	private PostSendSmsCaptchaRequestObject requestObject;
	
	public PostSendSmsCaptchaRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostSendSmsCaptchaRequestObject requestObject) {
		this.requestObject = requestObject;
	}
}
