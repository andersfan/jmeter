package load.test.api;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostSendSmsCaptchaRequestObject;


/*
 * 用户注册：发送手机短信验证码 post请求
 */
public class PostSendSmsCaptchaAPI extends PostAPI {
	public PostSendSmsCaptchaAPI() {
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
