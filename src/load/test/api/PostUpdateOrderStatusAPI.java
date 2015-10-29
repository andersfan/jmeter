package load.test.api;

import java.util.HashMap;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostUpdateOrderStatusRequestObject;

public class PostUpdateOrderStatusAPI extends PostAPI {
	public PostUpdateOrderStatusAPI(){
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-rtType", "json_orig_result");
		this.uriParams.put("p-apiv", "2.1");
		this.uriParams.put("p-debug","true");
		this.uriParams.put("_method","PUT");	
		this.headers.put("p-channel", "qiaoba");
	}
	
	public PostUpdateOrderStatusRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostUpdateOrderStatusRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostUpdateOrderStatusRequestObject requestObject;
}
