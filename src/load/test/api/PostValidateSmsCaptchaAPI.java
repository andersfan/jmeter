package load.test.api;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostValidateSmsCaptchaRequestObject;

/*
 * 用户注册：校验手机验证码
 */
public class PostValidateSmsCaptchaAPI extends PostAPI {
	public PostValidateSmsCaptchaAPI() {
		this.setCommonParamAndHeader_New();
	}

	public PostValidateSmsCaptchaRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostValidateSmsCaptchaRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostValidateSmsCaptchaRequestObject requestObject;
}
