package load.test.api;

import java.util.HashMap;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostUpdateExpressManStatusRequestObject;

public class PostUpdateExpressManStatusAPI extends PostAPI {
	public PostUpdateExpressManStatusAPI() {	
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-rtType", "json_orig_result");
		this.uriParams.put("p-apiv", "2.1");
		this.uriParams.put("p-debug","true");
		this.headers.put("p-channel", "qiaoba");
	}
	
	public void setOrderStatus(String userId, String status){
		this.uriParams.put("userId", userId);
		this.uriParams.put("status", status);
	}
	
	public PostUpdateExpressManStatusRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostUpdateExpressManStatusRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostUpdateExpressManStatusRequestObject requestObject;
}
