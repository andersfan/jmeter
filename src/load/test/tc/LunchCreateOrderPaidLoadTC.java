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

import load.test.api.GetUserAddressesAPI;
import load.test.api.PostCreateOrderAPI;
import load.test.api.PostUpdateOrderStatusAPI;
import load.test.api.PostUserAddressAPI;
import load.test.requestobject.Goods;
import load.test.requestobject.GoodsRice;
import load.test.requestobject.PostCreateOrderRequestObject;
import load.test.requestobject.PostUpdateOrderStatusRequestObject;
import load.test.requestobject.PostUserAddressRequestObject;
import load.test.responseobject.GetUserAddressesResponseObject;

public class LunchCreateOrderPaidLoadTC extends BaseLoadTC {
	GetUserAddressesResponseObject getUserAddressesResponseObject = null;

	@Override
	public void setupTest(JavaSamplerContext arg0) {
		this.results = new SampleResult();
		phoneNumber = arg0.getParameter("phoneNumber");
		password = arg0.getParameter("password");

		this.login(arg0);

		PostUserAddressAPI postUserAddressAPI = new PostUserAddressAPI();
		postUserAddressAPI.setHost(String.format("http://%s/api/user/%s/address", arg0.getParameter("host"),
				postLoginResponseObject.getData().getUserId()));
		PostUserAddressRequestObject postUserAddressRequestObject = new PostUserAddressRequestObject();
		postUserAddressRequestObject.setCity(arg0.getParameter("city"));
		postUserAddressRequestObject.setDistrictCode(arg0.getParameter("districtCode"));
		postUserAddressRequestObject.setType(Integer.parseInt(arg0.getParameter("addressType")));
		postUserAddressRequestObject.setAddressId(Integer.parseInt(arg0.getParameter("addressId")));
		postUserAddressRequestObject.setCityCode(arg0.getParameter("cityCode"));
		postUserAddressRequestObject.setProvinceCode(arg0.getParameter("provinceCode"));
		postUserAddressRequestObject.setDistrict(arg0.getParameter("district"));
		postUserAddressRequestObject.setLng(Double.parseDouble(arg0.getParameter("lng")));
		postUserAddressRequestObject.setIsDefault(Integer.parseInt(arg0.getParameter("isDefault")));
		postUserAddressRequestObject.setContactName(arg0.getParameter("contactName"));
		postUserAddressRequestObject.setAddrId(Integer.parseInt(arg0.getParameter("addrId")));
		postUserAddressRequestObject.setInputType(arg0.getParameter("inputType"));
		postUserAddressRequestObject.setContactPhone(arg0.getParameter("contactPhone"));
		postUserAddressRequestObject.setRelative(Integer.parseInt(arg0.getParameter("relative")));
		postUserAddressRequestObject.setProvince(arg0.getParameter("province"));
		postUserAddressRequestObject.setKeyWords(arg0.getParameter("keyWords"));
		postUserAddressRequestObject.setLat(Double.parseDouble(arg0.getParameter("lat")));
		postUserAddressAPI.setRequestObject(postUserAddressRequestObject);
		postUserAddressAPI.serializeRequestObject(postUserAddressAPI.getRequestObject());
		result += new Gson().toJson(postUserAddressRequestObject);
		try {
			postUserAddressAPI.sendRequest(postLoginResponseObject.getCookieStore());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result += postUserAddressAPI.getEntitystr();

		GetUserAddressesAPI getUserAddressesAPI = new GetUserAddressesAPI();
		getUserAddressesAPI.setHost("http://test-api.mishi.cn/gw/mishi.user.address.get/1.0");
		getUserAddressesAPI.setApiName("mishi.user.address.get");
		getUserAddressesAPI.setUrlParam(arg0.getParameter("logisticsType"), arg0.getParameter("productBiz"), arg0.getParameter("shopId"));

		try {
			getUserAddressesResponseObject = getUserAddressesAPI
					.getResponseObject(postLoginResponseObject.getCookieStore(), GetUserAddressesResponseObject.class);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result += new Gson().toJson(getUserAddressesResponseObject);
	}
	
	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("host", "test-api.mishi.cn");
		params.addArgument("phoneNumber", "12000000000");
		params.addArgument("password", "qqqqqq");
		params.addArgument("logisticsType", "1");
		params.addArgument("city", "上海市");
		params.addArgument("districtCode", "310104");
		params.addArgument("addressType", "0");
		params.addArgument("addressId", "0");
		params.addArgument("cityCode", "021");
		params.addArgument("provinceCode", "310000000000");
		params.addArgument("district", "徐汇区");
		params.addArgument("lng", "121.4273765771758");
		params.addArgument("isDefault", "0");
		params.addArgument("contactName", "范旭斐");
		params.addArgument("addrId", "0");
		params.addArgument("inputType", "2");
		params.addArgument("contactPhone", "12355555555");
		params.addArgument("relative", "0");
		params.addArgument("province", "上海市");
		params.addArgument("keyWords", "宜山路地铁站");
		params.addArgument("lat", "31.18596707143902");
		params.addArgument("dateType", "2");
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
		
		return params;
	}

	@Override
	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException, InvalidKeyException,
			NoSuchAlgorithmException {
		results.setDataEncoding("utf-8");
		results.setContentType("application/json");
		result += phoneNumber;

		PostCreateOrderAPI postCreateOrderAPI = new PostCreateOrderAPI();
		postCreateOrderAPI.setHost(String.format("http://%s/gw/mishi.order.create/1.0", arg0.getParameter("host")));
		postCreateOrderAPI.setApiName("mishi.order.create");
		PostCreateOrderRequestObject postCreateOrderRequestObject = new PostCreateOrderRequestObject();
		postCreateOrderAPI.setRequestObject(postCreateOrderRequestObject);
		postCreateOrderAPI.getRequestObject()
				.setLogisticsId(getUserAddressesResponseObject.getData().get(0).getAddrId());
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

		String orderID = postCreateOrderAPI.getEntitystr();
		orderID = orderID.substring(orderID.indexOf("orderId"));
		orderID = orderID.substring(orderID.indexOf(":\""));
		orderID = orderID.substring(2, 18);
		result += orderID;
		PostUpdateOrderStatusAPI postUpdateOrderStatusAPI = new PostUpdateOrderStatusAPI();
		postUpdateOrderStatusAPI.setHost(String.format("http://%s/api/order/%s", arg0.getParameter("host"), orderID));
		PostUpdateOrderStatusRequestObject postUpdateOrderStatusRequestObject = new PostUpdateOrderStatusRequestObject();
		postUpdateOrderStatusRequestObject.setAction("paidOrder");
		postUpdateOrderStatusRequestObject.setNeedEncrypt("true");
		postUpdateOrderStatusRequestObject.setUserType(0);
		postUpdateOrderStatusAPI.setRequestObject(postUpdateOrderStatusRequestObject);
		postUpdateOrderStatusAPI.serializeRequestObject(postUpdateOrderStatusAPI.getRequestObject());
		postUpdateOrderStatusAPI.sendRequest(postLoginResponseObject.getCookieStore());
		result += postUpdateOrderStatusAPI.getEntitystr();

	}

}
