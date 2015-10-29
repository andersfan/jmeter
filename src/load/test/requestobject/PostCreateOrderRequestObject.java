package load.test.requestobject;

import java.util.List;

import load.test.objectbase.RequestObject;

public class PostCreateOrderRequestObject extends RequestObject {
	private int logisticsId;

	private List<Goods> goodsList;

	private int logisticsType;

	private int payChannel;

	private String logisticsTime;

	private boolean ignoreWarn;

	private int productBiz;
	
	private String arrivePeriod;
	
	private GoodsRice goodsRice;
	
	private String deliveryDistance;
	
	private String deliveryPeriod;
	
	private List<String> couponSnList;

	private int shopId;

	public void setLogisticsId(int logisticsId) {
		this.logisticsId = logisticsId;
	}

	public int getLogisticsId() {
		return this.logisticsId;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public List<Goods> getGoodsList() {
		return this.goodsList;
	}

	public void setLogisticsType(int logisticsType) {
		this.logisticsType = logisticsType;
	}

	public int getLogisticsType() {
		return this.logisticsType;
	}

	public void setPayChannel(int payChannel) {
		this.payChannel = payChannel;
	}

	public int getPayChannel() {
		return this.payChannel;
	}

	public void setLogisticsTime(String logisticsTime) {
		this.logisticsTime = logisticsTime;
	}

	public String getLogisticsTime() {
		return this.logisticsTime;
	}

	public void setIgnoreWarn(boolean ignoreWarn) {
		this.ignoreWarn = ignoreWarn;
	}

	public boolean getIgnoreWarn() {
		return this.ignoreWarn;
	}

	public void setProductBiz(int productBiz) {
		this.productBiz = productBiz;
	}

	public int getProductBiz() {
		return this.productBiz;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getShopId() {
		return this.shopId;
	}

	public String getArrivePeriod() {
		return arrivePeriod;
	}

	public void setArrivePeriod(String arrivePeriod) {
		this.arrivePeriod = arrivePeriod;
	}

	public GoodsRice getGoodsRice() {
		return goodsRice;
	}

	public void setGoodsRice(GoodsRice goodsRice) {
		this.goodsRice = goodsRice;
	}

	public String getDeliveryDistance() {
		return deliveryDistance;
	}

	public void setDeliveryDistance(String deliveryDistance) {
		this.deliveryDistance = deliveryDistance;
	}

	public String getDeliveryPeriod() {
		return deliveryPeriod;
	}

	public void setDeliveryPeriod(String deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	public List<String> getCouponSnList() {
		return couponSnList;
	}

	public void setCouponSnList(List<String> couponSnList) {
		this.couponSnList = couponSnList;
	}
}
