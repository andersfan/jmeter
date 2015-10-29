package load.test.responseobject;

import org.apache.http.client.CookieStore;

import load.test.objectbase.ResponseObject;

public class PostLoginResponseObject extends ResponseObject {
	private LoginData data;
	private CookieStore cookieStore;

	public LoginData getData() {
		return data;
	}

	public void setData(LoginData data) {
		this.data = data;
	}

	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(CookieStore cookieStore) {
		this.cookieStore = cookieStore;
	}
}
