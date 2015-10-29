package load.test.responseobject;

public class GetUserAddressesData {
	private int addrId;

	private String binaryType;

	private BuyerAddrBO buyerAddrBO;

	private String contactName;

	private String contactPhone;

	private boolean isDefault;

	private boolean isInRange;

	private String keyWords;

	private String strAddr;

	private int type;

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public int getAddrId() {
		return this.addrId;
	}

	public void setBinaryType(String binaryType) {
		this.binaryType = binaryType;
	}

	public String getBinaryType() {
		return this.binaryType;
	}

	public void setBuyerAddrBO(BuyerAddrBO buyerAddrBO) {
		this.buyerAddrBO = buyerAddrBO;
	}

	public BuyerAddrBO getBuyerAddrBO() {
		return this.buyerAddrBO;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsInRange(boolean isInRange) {
		this.isInRange = isInRange;
	}

	public boolean getIsInRange() {
		return this.isInRange;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getKeyWords() {
		return this.keyWords;
	}

	public void setStrAddr(String strAddr) {
		this.strAddr = strAddr;
	}

	public String getStrAddr() {
		return this.strAddr;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

}
