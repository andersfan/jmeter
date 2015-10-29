package load.test.requestobject;

import load.test.objectbase.RequestObject;

public class PostUpdateOrderStatusRequestObject extends RequestObject {
	private String action;
	private String needEncrypt;
	private int userType;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getNeedEncrypt() {
		return needEncrypt;
	}

	public void setNeedEncrypt(String needEncrypt) {
		this.needEncrypt = needEncrypt;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
}
