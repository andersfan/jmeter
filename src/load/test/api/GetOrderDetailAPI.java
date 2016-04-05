package load.test.api;

import load.test.apibase.GetAPI;

public class GetOrderDetailAPI extends GetAPI {
	public GetOrderDetailAPI() {
		this.setCommonParamAndHeader_New();
	}
	
	public void setOrderId(String orderId){
		this.uriParams.put("orderId", orderId);
	}
}
