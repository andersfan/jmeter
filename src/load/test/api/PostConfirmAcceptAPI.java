package load.test.api;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostConfirmAcceptRequestObject;

public class PostConfirmAcceptAPI extends PostAPI {
	public PostConfirmAcceptAPI(){
		this.setCommonParamAndHeader_New();
	}
	
	public PostConfirmAcceptRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostConfirmAcceptRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostConfirmAcceptRequestObject requestObject;
}
