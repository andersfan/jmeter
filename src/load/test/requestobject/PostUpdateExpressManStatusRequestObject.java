package load.test.requestobject;

import load.test.objectbase.RequestObject;

public class PostUpdateExpressManStatusRequestObject extends RequestObject {
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
