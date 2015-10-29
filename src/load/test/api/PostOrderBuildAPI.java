package load.test.api;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostOrderBuildRequestObject;

public class PostOrderBuildAPI extends PostAPI {

	public PostOrderBuildAPI() {
		this.setCommonParamAndHeader_New();
	}

	public PostOrderBuildRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostOrderBuildRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostOrderBuildRequestObject requestObject;
}
