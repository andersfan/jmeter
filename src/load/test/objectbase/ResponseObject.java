package load.test.objectbase;

public class ResponseObject extends JsonObject {
	protected String debugErrMsg;

	protected int errCode;

	protected String errMsg;

	protected boolean success;

	public String getDebugErrMsg() {
		return debugErrMsg;
	}

	public void setDebugErrMsg(String debugErrMsg) {
		this.debugErrMsg = debugErrMsg;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
