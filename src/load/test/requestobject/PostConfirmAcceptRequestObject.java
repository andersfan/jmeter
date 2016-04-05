package load.test.requestobject;

import java.util.List;

import load.test.objectbase.RequestObject;

public class PostConfirmAcceptRequestObject extends RequestObject {
	private String mergerOrderId;
	private List<String> orderIdList;

	public String getMergerOrderId() {
		return mergerOrderId;
	}

	public void setMergerOrderId(String mergerOrderId) {
		this.mergerOrderId = mergerOrderId;
	}

	public List<String> getOrderIdList() {
		return orderIdList;
	}

	public void setOrderIdList(List<String> orderIdList) {
		this.orderIdList = orderIdList;
	}
}
