package load.test.requestobject;

import load.test.objectbase.RequestObject;

public class PostRegisterRequestObject extends RequestObject {
	private String token;
	private String password;
	private boolean needEncrypt;
	private String nickname;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getNeedEncrypt() {
		return needEncrypt;
	}

	public void setNeedEncrypt(boolean needEncrypt) {
		this.needEncrypt = needEncrypt;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
