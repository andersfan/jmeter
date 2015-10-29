package load.test.requestobject;

import load.test.objectbase.RequestObject;

public class PostUserAddressRequestObject extends RequestObject {
	private String city;

	private String districtCode;

	private int type;

	private int addressId;

	private String cityCode;

	private String provinceCode;

	private String district;

	private double lng;

	private int isDefault;

	private String contactName;

	private int addrId;

	private String inputType;

	private String contactPhone;

	private int relative;

	private String province;

	private String keyWords;

	private double lat;

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLng() {
		return this.lng;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getIsDefault() {
		return this.isDefault;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public int getAddrId() {
		return this.addrId;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getInputType() {
		return this.inputType;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setRelative(int relative) {
		this.relative = relative;
	}

	public int getRelative() {
		return this.relative;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return this.province;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getKeyWords() {
		return this.keyWords;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLat() {
		return this.lat;
	}
}
