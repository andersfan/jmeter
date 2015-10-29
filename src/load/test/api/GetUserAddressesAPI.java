package load.test.api;

import load.test.apibase.GetAPI;

public class GetUserAddressesAPI extends GetAPI {
	public GetUserAddressesAPI() {
		this.setCommonParamAndHeader_New();
	}

	public void setUrlParam(String logisticsType, String productBiz, String shopId) {
		this.uriParams.put("logisticsType", logisticsType);
		this.uriParams.put("productBiz", productBiz);
		this.uriParams.put("shopId", shopId);
	}
}
