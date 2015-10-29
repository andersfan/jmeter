package load.test.responseobject;

import java.util.List;

import load.test.objectbase.ResponseObject;

public class GetUserAddressesResponseObject extends ResponseObject {
	private List<GetUserAddressesData> data;

	public List<GetUserAddressesData> getData() {
		return data;
	}

	public void setData(List<GetUserAddressesData> data) {
		this.data = data;
	}
}
