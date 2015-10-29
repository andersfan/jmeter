package load.test.responseobject;

import load.test.objectbase.ResponseObject;

public class PostSendSmsCaptchaResponseObject extends ResponseObject {
	private PostSendSmsCaptchaData data;

	public void setData(PostSendSmsCaptchaData data) {
		this.data = data;
	}

	public PostSendSmsCaptchaData getData() {
		return this.data;
	}

}