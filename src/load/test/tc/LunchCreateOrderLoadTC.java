package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.google.gson.Gson;

import load.test.api.PostCreateOrderAPI;
import load.test.requestobject.Goods;
import load.test.requestobject.GoodsRice;
import load.test.requestobject.PostCreateOrderRequestObject;

public class LunchCreateOrderLoadTC extends BaseLoadTC {

	@Override
	public void setupTest(JavaSamplerContext arg0) {
		this.results = new SampleResult();
		phoneNumber = arg0.getParameter("phoneNumber");
		password = arg0.getParameter("password");

		this.login(arg0);
	}
	
	@Override
	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException,
			InvalidKeyException, NoSuchAlgorithmException {
		results.setDataEncoding("utf-8");
		results.setContentType("application/json");
		result += phoneNumber;

		PostCreateOrderAPI postCreateOrderAPI = new PostCreateOrderAPI();
		postCreateOrderAPI.setHost(String.format("http://%s/gw/mishi.order.create/1.0", arg0.getParameter("host")));
		postCreateOrderAPI.setApiName("mishi.order.create");
		PostCreateOrderRequestObject postCreateOrderRequestObject = new PostCreateOrderRequestObject();
		postCreateOrderAPI.setRequestObject(postCreateOrderRequestObject);
		postCreateOrderAPI.getRequestObject().setLogisticsId(Integer.parseInt(arg0.getParameter("addrId")));
		postCreateOrderAPI.getRequestObject().setLogisticsType(Integer.parseInt(arg0.getParameter("logisticsType")));
		postCreateOrderAPI.getRequestObject().setLogisticsTime(arg0.getParameter("logisticsTime"));
		postCreateOrderAPI.getRequestObject().setShopId(Integer.parseInt(arg0.getParameter("shopId")));
		postCreateOrderAPI.getRequestObject().setArrivePeriod(arg0.getParameter("arrivePeriod"));
		postCreateOrderAPI.getRequestObject().setPayChannel(Integer.parseInt(arg0.getParameter("payChannel")));
		postCreateOrderAPI.getRequestObject().setProductBiz(Integer.parseInt(arg0.getParameter("productBiz")));
		postCreateOrderAPI.getRequestObject().setIgnoreWarn(false);
		GoodsRice goodsRice = new GoodsRice();
		goodsRice.setCumulative(0);
		goodsRice.setPrice(0);
		goodsRice.setGoodsId(-1);
		goodsRice.setName("米饭");
		goodsRice.setDayLimit(10);
		goodsRice.setCount(1);
		goodsRice.setMainPic(null);
		postCreateOrderAPI.getRequestObject().setGoodsRice(goodsRice);
		postCreateOrderAPI.getRequestObject().setDeliveryDistance(arg0.getParameter("deliveryDistance"));
		postCreateOrderAPI.getRequestObject().setDeliveryPeriod(arg0.getParameter("arrivePeriod"));
		List<Goods> goodsList = new ArrayList<Goods>();
		Goods goods = new Goods();
		goods.setCount(Integer.parseInt(arg0.getParameter("goodsCount")));
		goods.setGoodsId(arg0.getParameter("goodsId"));
		goods.setPrice(Integer.parseInt(arg0.getParameter("goodsPrice")));
		goods.setActivityGoodsId(0);
		goods.setName(arg0.getParameter("goodsName"));
		goodsList.add(goods);
		postCreateOrderAPI.getRequestObject().setGoodsList(goodsList);
		result += new Gson().toJson(postCreateOrderAPI.getRequestObject());
		postCreateOrderAPI.serializeRequestObject(postCreateOrderAPI.getRequestObject());
		results.sampleStart();
		postCreateOrderAPI.sendRequest(postLoginResponseObject.getCookieStore());
		results.sampleEnd();
		result += postCreateOrderAPI.getEntitystr();
		if (!postCreateOrderAPI.getEntitystr().contains("\"orderId\":\"")) {
			throw new IOException();
		}
	}

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test-api.mishi.cn");
		params.addArgument("phoneNumber", "12000000000");
		params.addArgument("password", "qqqqqq");
		params.addArgument("logisticsType", "1");	
		params.addArgument("shopId", "28823");
		params.addArgument("productBiz", "2");
		params.addArgument("goodsName", "审核后添加");
		params.addArgument("goodsCount", "1");
		params.addArgument("goodsId", "53924");
		params.addArgument("goodsPrice", "1");
		params.addArgument("logisticsTime", "2015-10-29");
		params.addArgument("arrivePeriod", "12:30-13:00");
		params.addArgument("payChannel", "1");
		params.addArgument("deliveryDistance", "1");
		params.addArgument("deliveryPeriod", "11:00-11:30");
		params.addArgument("addrId", "91794");
		return params;
	}

}
