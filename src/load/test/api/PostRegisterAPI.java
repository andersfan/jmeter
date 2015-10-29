package load.test.api;

import java.util.HashMap;

import org.apache.http.client.CookieStore;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostRegisterRequestObject;

/*
 * 注册
 */
public class PostRegisterAPI extends PostAPI {

	public PostRegisterAPI() {	
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-rtType", "json_orig_result");
		this.uriParams.put("p-apiv", "2.1");
		this.uriParams.put("p-debug","true");
		this.headers.put("p-channel", "qiaoba");
	}
	
	public CookieStore getCookieStore(){
		return this.httpClient.getCookieStore();
	}
	
	public PostRegisterRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostRegisterRequestObject requestObject) {
		this.requestObject = requestObject;
	}

	private PostRegisterRequestObject requestObject;
	
}
