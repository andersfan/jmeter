package load.test.responseobject;

import load.test.objectbase.ResponseObject;

public class PostRegisterResponseObject extends ResponseObject {
	private PostRegisterData data;

	public void setData(PostRegisterData data) {
		this.data = data;
	}

	public PostRegisterData getData() {
		return this.data;
	}

}