package load.test.api;

import org.apache.http.client.CookieStore;

import load.test.apibase.PostAPI;
import load.test.requestobject.PostLoginRequestObject;

public class PostLoginAPI extends PostAPI {

	public PostLoginAPI(){
		this.setCommonParamAndHeader_New();
	}
	
	private PostLoginRequestObject requestObject;

	public PostLoginRequestObject getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(PostLoginRequestObject requestObject) {
		this.requestObject = requestObject;
	}
	
	public CookieStore getCookieStore() {
		return httpClient.getCookieStore();
	}

}
