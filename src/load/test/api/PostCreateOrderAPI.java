package load.test.api;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostCreateOrderRequestObject;

public class PostCreateOrderAPI extends PostAPI {
	public PostCreateOrderAPI() {
		this.setCommonParamAndHeader_New();
	}

	private PostCreateOrderRequestObject requestObject;

	public PostCreateOrderRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostCreateOrderRequestObject requestObject) {
		this.requestObject = requestObject;
	}
}
