package load.test.requestobject;

import load.test.objectbase.RequestObject;

public class PostValidateSmsCaptchaRequestObject extends RequestObject {
	private String token;
	private String captcha;
	private int type;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
