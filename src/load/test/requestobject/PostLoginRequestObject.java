package load.test.requestobject;

import load.test.objectbase.RequestObject;

public class PostLoginRequestObject extends RequestObject {
	private String needEncrypt;

	private String password;

	private String phoneNumber;

	public void setNeedEncrypt(String needEncrypt) {
		this.needEncrypt = needEncrypt;
	}

	public String getNeedEncrypt() {
		return this.needEncrypt;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}
