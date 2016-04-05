package load.test.api;

import java.util.HashMap;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostOrderAmountRequestObject;

public class PostOrderAmountAPI extends PostAPI {
	public PostOrderAmountAPI() {
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-rtType", "json_orig_result");
		this.uriParams.put("p-apiv", "2.1");
		this.uriParams.put("p-debug","true");
		this.headers.put("p-channel", "qiaoba");
	}
	
	public PostOrderAmountRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostOrderAmountRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostOrderAmountRequestObject requestObject;
}
