package load.test.tc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.google.gson.Gson;

import load.test.api.GetUserAddressesAPI;
import load.test.api.PostCreateOrderAPI;
import load.test.api.PostLoginAPI;
import load.test.api.PostRegisterAPI;
import load.test.api.PostSendSmsCaptchaAPI;
import load.test.api.PostUserAddressAPI;
import load.test.api.PostValidateSmsCaptchaAPI;
import load.test.requestobject.Goods;
import load.test.requestobject.GoodsRice;
import load.test.requestobject.PostCreateOrderRequestObject;
import load.test.requestobject.PostLoginRequestObject;
import load.test.requestobject.PostRegisterRequestObject;
import load.test.requestobject.PostSendSmsCaptchaRequestObject;
import load.test.requestobject.PostUserAddressRequestObject;
import load.test.requestobject.PostValidateSmsCaptchaRequestObject;
import load.test.responseobject.GetUserAddressesResponseObject;
import load.test.responseobject.PostLoginResponseObject;
import load.test.responseobject.PostRegisterResponseObject;
import load.test.responseobject.PostSendSmsCaptchaResponseObject;
import load.test.responseobject.PostValidateSmsCaptchaResponseObject;

public class LunchCreateOrderLoadTC extends BaseLoadTC {
	GetUserAddressesResponseObject getUserAddressesResponseObject = null;
	PostLoginResponseObject postLoginResponseObject = null;
	
	@Override
	public void test(JavaSamplerContext arg0) throws UnsupportedEncodingException, IOException, ClientProtocolException, InvalidKeyException,
			NoSuchAlgorithmException {
		results.setDataEncoding("utf-8");
		results.setContentType("application/json");
		result += phoneNumber;
		
		PostCreateOrderAPI postCreateOrderAPI = new PostCreateOrderAPI();
		postCreateOrderAPI.setHost("http://test-api.mishi.cn/gw/mishi.order.create/1.0");
		postCreateOrderAPI.setApiName("mishi.order.create");
		PostCreateOrderRequestObject postCreateOrderRequestObject = new PostCreateOrderRequestObject();
		postCreateOrderAPI.setRequestObject(postCreateOrderRequestObject);
		postCreateOrderAPI.getRequestObject().setLogisticsId(getUserAddressesResponseObject.getData().get(0).getAddrId());
		postCreateOrderAPI.getRequestObject().setLogisticsType(1);
		postCreateOrderAPI.getRequestObject().setLogisticsTime("2015-10-29");
		postCreateOrderAPI.getRequestObject().setShopId(28823);
		postCreateOrderAPI.getRequestObject().setArrivePeriod("12:30-13:00");
		postCreateOrderAPI.getRequestObject().setPayChannel(1);
		postCreateOrderAPI.getRequestObject().setProductBiz(2);
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
		postCreateOrderAPI.getRequestObject().setDeliveryDistance("1");
		postCreateOrderAPI.getRequestObject().setDeliveryPeriod("11:00-11:30");
		List<Goods> goodsList = new ArrayList<Goods>();
		Goods goods = new Goods();
		goods.setCount(1);
		goods.setGoodsId("53924");
		goods.setPrice(1);
		goods.setActivityGoodsId(0);
		goods.setName("审核后添加");
		goodsList.add(goods);
		postCreateOrderAPI.getRequestObject().setGoodsList(goodsList);
		result += new Gson().toJson(postCreateOrderAPI.getRequestObject());
		postCreateOrderAPI.serializeRequestObject(postCreateOrderAPI.getRequestObject());
		results.sampleStart();
		postCreateOrderAPI.sendRequest(postLoginResponseObject.getCookieStore());
		results.sampleEnd();
		result += postCreateOrderAPI.getEntitystr();
	}

	@Override
	public void setupTest(JavaSamplerContext arg0) {
		this.results = new SampleResult();
		phoneNumber = arg0.getParameter("phoneNumber");
		password = arg0.getParameter("password");
//		
//		PostSendSmsCaptchaAPI postSendSmsCaptchaAPI = null;
//		try {
//			postSendSmsCaptchaAPI = new PostSendSmsCaptchaAPI();
//		} catch (InvalidKeyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		postSendSmsCaptchaAPI.setHost("http://test-api.mishi.cn/gw/mishi.captcha.sms.send/1.0");
//		postSendSmsCaptchaAPI.setApiName("mishi.captcha.sms.send");
//		PostSendSmsCaptchaRequestObject postSendSmsCaptchaRequestObject = new PostSendSmsCaptchaRequestObject();
//		postSendSmsCaptchaRequestObject.setPhoneNumber(phoneNumber);
//		postSendSmsCaptchaRequestObject.setType(1);
//		postSendSmsCaptchaAPI.setRequestObject(postSendSmsCaptchaRequestObject);
//		postSendSmsCaptchaAPI.serializeRequestObject(postSendSmsCaptchaAPI.getRequestObject());
//		results.setRequestHeaders(postSendSmsCaptchaAPI.getRequestHeaderString());
//		result += new Gson().toJson(postSendSmsCaptchaRequestObject);
//		PostSendSmsCaptchaResponseObject postSendSmsCaptchaResponseObject = null;
//		try {
//			postSendSmsCaptchaResponseObject = postSendSmsCaptchaAPI
//					.getResponseObject(null, PostSendSmsCaptchaResponseObject.class);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		result += new Gson().toJson(postSendSmsCaptchaResponseObject);
//
//		PostValidateSmsCaptchaAPI postValidateSmsCaptchaAPI = new PostValidateSmsCaptchaAPI();
//		postValidateSmsCaptchaAPI.setHost("http://test-api.mishi.cn/gw/mishi.captcha.sms.validate/1.0");
//		postValidateSmsCaptchaAPI.setApiName("mishi.captcha.sms.validate");
//		PostValidateSmsCaptchaRequestObject postValidateSmsCaptchaRequestObject = new PostValidateSmsCaptchaRequestObject();
//		postValidateSmsCaptchaAPI.setRequestObject(postValidateSmsCaptchaRequestObject);
//		postValidateSmsCaptchaAPI.getRequestObject().setToken(postSendSmsCaptchaResponseObject.getData().getToken());
//		postValidateSmsCaptchaAPI.getRequestObject().setType(1);
//		postValidateSmsCaptchaAPI.getRequestObject().setCaptcha("1111");
//		postValidateSmsCaptchaAPI.serializeRequestObject(postValidateSmsCaptchaAPI.getRequestObject());
//		result += new Gson().toJson(postValidateSmsCaptchaRequestObject);
//		PostValidateSmsCaptchaResponseObject postValidateSmsCaptchaResponseObject = null;
//		try {
//			postValidateSmsCaptchaResponseObject = postValidateSmsCaptchaAPI
//					.getResponseObject(null, PostValidateSmsCaptchaResponseObject.class);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		result += new Gson().toJson(postValidateSmsCaptchaResponseObject);
//
//		PostRegisterAPI postRegisterAPI = new PostRegisterAPI();
//		postRegisterAPI.setHost("http://test-api.mishi.cn/user/register?rnd=" + phoneNumber);
//		result += postRegisterAPI.getHost();
//		PostRegisterRequestObject postRegisterRequestObject = new PostRegisterRequestObject();
//		postRegisterAPI.setRequestObject(postRegisterRequestObject);
//		postRegisterAPI.getRequestObject().setNeedEncrypt(false);
//		postRegisterAPI.getRequestObject().setPassword(password);
//		postRegisterAPI.getRequestObject().setNickname("隔壁老王");
//		postRegisterAPI.getRequestObject().setToken(postSendSmsCaptchaResponseObject.getData().getToken());
//		postRegisterAPI.serializeRequestObject(postRegisterAPI.getRequestObject());
//		result += new Gson().toJson(postRegisterRequestObject);
//		try {
//			PostRegisterResponseObject postRegisterResponseObject = postRegisterAPI.getResponseObject(null,
//					PostRegisterResponseObject.class);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		result += postRegisterAPI.getEntitystr();

		PostLoginAPI postLoginAPI = new PostLoginAPI();
		postLoginAPI.setHost("http://test-api.mishi.cn/gw/mishi.user.lunch.login/1.0");
		postLoginAPI.setApiName("mishi.user.lunch.login");
		PostLoginRequestObject postLoginRequestObject = new PostLoginRequestObject();
		postLoginAPI.setRequestObject(postLoginRequestObject);
		postLoginAPI.getRequestObject().setNeedEncrypt("false");
		postLoginAPI.getRequestObject().setPhoneNumber(phoneNumber);
		postLoginAPI.getRequestObject().setPassword(password);
		postLoginAPI.serializeRequestObject(postLoginAPI.getRequestObject());
		result += new Gson().toJson(postLoginRequestObject);
		
		try {
			postLoginResponseObject = postLoginAPI.getResponseObject(null,
					PostLoginResponseObject.class);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		postLoginResponseObject.setCookieStore(postLoginAPI.getCookieStore());
		result += new Gson().toJson(postLoginResponseObject);

		PostUserAddressAPI postUserAddressAPI = new PostUserAddressAPI();
		postUserAddressAPI.setHost(String.format("http://test-api.mishi.cn/api/user/%s/address",
				postLoginResponseObject.getData().getUserId()));
		PostUserAddressRequestObject postUserAddressRequestObject = new PostUserAddressRequestObject();
		postUserAddressRequestObject.setCity("上海市");
		postUserAddressRequestObject.setDistrictCode("310104");
		postUserAddressRequestObject.setType(0);
		postUserAddressRequestObject.setAddressId(0);
		postUserAddressRequestObject.setCityCode("021");
		postUserAddressRequestObject.setProvinceCode("310000000000");
		postUserAddressRequestObject.setDistrict("徐汇区");
		postUserAddressRequestObject.setLng(121.4273765771758);
		postUserAddressRequestObject.setIsDefault(0);
		postUserAddressRequestObject.setContactName("范旭斐");
		postUserAddressRequestObject.setAddrId(0);
		postUserAddressRequestObject.setInputType("2");
		postUserAddressRequestObject.setContactPhone("12355555555");
		postUserAddressRequestObject.setRelative(0);
		postUserAddressRequestObject.setProvince("上海市");
		postUserAddressRequestObject.setKeyWords("宜山路地铁站");
		postUserAddressRequestObject.setLat(31.18596707143902);
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
		result +=  postUserAddressAPI.getEntitystr();

		GetUserAddressesAPI getUserAddressesAPI = new GetUserAddressesAPI();
		getUserAddressesAPI.setHost("http://test-api.mishi.cn/gw/mishi.user.address.get/1.0");
		getUserAddressesAPI.setApiName("mishi.user.address.get");
		getUserAddressesAPI.setUrlParam("1", "2", "28823");
	
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

}
