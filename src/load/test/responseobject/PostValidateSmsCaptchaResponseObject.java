package load.test.responseobject;

import load.test.objectbase.ResponseObject;

public class PostValidateSmsCaptchaResponseObject extends ResponseObject {
	private PostValidateSmsCaptchaData data;

	public void setData(PostValidateSmsCaptchaData data) {
		this.data = data;
	}

	public PostValidateSmsCaptchaData getData() {
		return this.data;
	}
	
}
