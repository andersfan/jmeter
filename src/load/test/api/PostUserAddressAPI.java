package load.test.api;

import java.util.HashMap;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostUserAddressRequestObject;

public class PostUserAddressAPI extends PostAPI {
	public PostUserAddressAPI() {
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-rtType", "json_orig_result");
		this.uriParams.put("p-apiv", "2.1");
		this.uriParams.put("p-debug","true");
		this.headers.put("p-channel", "qiaoba");
	}
	
	public PostUserAddressRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostUserAddressRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostUserAddressRequestObject requestObject;
}
