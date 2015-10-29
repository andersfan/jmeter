package load.test.requestobject;

import java.util.List;

import load.test.objectbase.RequestObject;

public class PostOrderBuildRequestObject extends RequestObject {
	private String shopId;

	private boolean isLunch;
	
	private int productBiz;

	private int dateType;

	private List<Goods> goodsList;

	private boolean isSimple;

	private int payChannel;

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopId() {
		return this.shopId;
	}

	public void setIsLunch(boolean isLunch) {
		this.isLunch = isLunch;
	}

	public boolean getIsLunch() {
		return this.isLunch;
	}

	public void setDateType(int dateType) {
		this.dateType = dateType;
	}

	public int getDateType() {
		return this.dateType;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public List<Goods> getGoodsList() {
		return this.goodsList;
	}

	public void setIsSimple(boolean isSimple) {
		this.isSimple = isSimple;
	}

	public boolean getIsSimple() {
		return this.isSimple;
	}

	public void setPayChannel(int payChannel) {
		this.payChannel = payChannel;
	}

	public int getPayChannel() {
		return this.payChannel;
	}

	public int getProductBiz() {
		return productBiz;
	}

	public void setProductBiz(int productBiz) {
		this.productBiz = productBiz;
	}
}
