package load.test.responseobject;

import org.apache.http.client.CookieStore;

public class PostRegisterData {
	private boolean finishGettingUserIm;

	private boolean hasShop;

	private boolean newApp;

	private String nickname;

	private String phoneNumber;

	private String photo;

	private String registerTime;

	private int restNickNameModifyCount;

	private int userId;
	
	private PostRegisterH5UserImData userIm;
	
	private CookieStore cookieStore;

	public void setFinishGettingUserIm(boolean finishGettingUserIm) {
		this.finishGettingUserIm = finishGettingUserIm;
	}

	public boolean getFinishGettingUserIm() {
		return this.finishGettingUserIm;
	}

	public void setHasShop(boolean hasShop) {
		this.hasShop = hasShop;
	}

	public boolean getHasShop() {
		return this.hasShop;
	}

	public void setNewApp(boolean newApp) {
		this.newApp = newApp;
	}

	public boolean getNewApp() {
		return this.newApp;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRestNickNameModifyCount(int restNickNameModifyCount) {
		this.restNickNameModifyCount = restNickNameModifyCount;
	}

	public int getRestNickNameModifyCount() {
		return this.restNickNameModifyCount;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return this.userId;
	}

	public PostRegisterH5UserImData getUserIm() {
		return userIm;
	}

	public void setUserIm(PostRegisterH5UserImData userIm) {
		this.userIm = userIm;
	}

	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(CookieStore cookieStore) {
		this.cookieStore = cookieStore;
	}

}