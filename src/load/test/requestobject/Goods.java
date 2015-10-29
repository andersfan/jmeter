package load.test.requestobject;

public class Goods {
	private String goodsId;

	private int count;
	
	private int price;
	
	private String name;
	
	private int activityGoodsId;

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActivityGoodsId() {
		return activityGoodsId;
	}

	public void setActivityGoodsId(int activityGoodsId) {
		this.activityGoodsId = activityGoodsId;
	}
}
