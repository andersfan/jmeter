package load.test.requestobject;

import java.util.List;

import load.test.objectbase.RequestObject;

public class PostOrderPeriodsRequestObject extends RequestObject {
	private List<Integer> goodsIds;

	private int logisticsId;

	private String logisticsTime;

	private int logisticsType;

	private int shopId;

	public void setGoodsIds(List<Integer> goodsIds) {
		this.goodsIds = goodsIds;
	}

	public List<Integer> getGoodsIds() {
		return this.goodsIds;
	}

	public void setLogisticsId(int logisticsId) {
		this.logisticsId = logisticsId;
	}

	public int getLogisticsId() {
		return this.logisticsId;
	}

	public void setLogisticsTime(String logisticsTime) {
		this.logisticsTime = logisticsTime;
	}

	public String getLogisticsTime() {
		return this.logisticsTime;
	}

	public void setLogisticsType(int logisticsType) {
		this.logisticsType = logisticsType;
	}

	public int getLogisticsType() {
		return this.logisticsType;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getShopId() {
		return this.shopId;
	}
}
