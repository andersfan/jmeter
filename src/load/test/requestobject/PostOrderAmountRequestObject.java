package load.test.requestobject;

import java.util.List;

import load.test.objectbase.RequestObject;

public class PostOrderAmountRequestObject extends RequestObject {
	private int shopId;
	private List<Goods> goodsList;

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
}
