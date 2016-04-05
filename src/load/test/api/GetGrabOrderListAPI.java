package load.test.api;

import load.test.apibase.GetAPI;

public class GetGrabOrderListAPI extends GetAPI {
	public GetGrabOrderListAPI(){
		this.setCommonParamAndHeader_New();
	}
	
	public void setAddress(String lng, String lat){
		this.uriParams.put("lng", lng);
		this.uriParams.put("lat", lat);
	}
}
