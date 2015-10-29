package load.test.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import load.test.apibase.PostAPI;

public class PostAlipayCallbackAPI extends PostAPI {
	public PostAlipayCallbackAPI() throws UnsupportedEncodingException {
		 
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-apiv", "1.0");
		this.uriParams.put("p-debug", "true");
		this.uriParams.put("discount", "0.00");
		this.uriParams.put("payment_type", "1");
		this.uriParams.put("subject",  "%25E8%25A7%2585%25E9%25A3%259F+-+%25E7%25A7%2581%25E5%258E%25A8%25E5%25BA%2597%25E5%2590%258D+%25E5%258D%2596%25E5%25AE%25B6+-+%25E8%25B4%25AD%25E4%25B9%25B0%25E7%25BE%258E%25E9%25A3%259F2%25E4%25BB%25BD");
		this.uriParams.put("trade_no", "201507080246947000467013");
		this.uriParams.put("buyer_email", "xenos_liu@163.com");	
		this.uriParams.put("gmt_create", "2015-06-19%2009:44:02");
		this.uriParams.put("notify_type", "trade_status_sync");
		this.uriParams.put("quantity", "1");
		this.uriParams.put("notify_id", "7426a734b158e67944bdb63ecd8b1cca4y");
		this.uriParams.put("seller_id", "2088711763956591");	
		this.uriParams.put("notify_time", "2015-04-14%2009:48:15");
		this.uriParams.put("body", "%25E9%259D%259E%25E6%25B4%25BB%25E5%258A%25A8%25E7%25BE%258E%25E9%25A3%259F1%25E4%25BB%25BD%252C%25E6%258B%2594%25E8%258D%2589%25E4%25BA%25BA%25E8%25AF%2595%25E5%2590%25831%25E4%25BB%25BD");
		this.uriParams.put("trade_status", "TRADE_SUCCESS");
		this.uriParams.put("is_total_fee_adjust", "Y");
		this.uriParams.put("seller_email", "yuanyuan.xu@mishi.cn");
		this.uriParams.put("buyer_id", "2088002493920533");
		this.uriParams.put("notify_id", "7426a734b158e67944bdb63ecd8b1cca4y");
		this.uriParams.put("use_coupon", "N");
	}

	public void setUrlParam(String orderid, String price) {
		this.uriParams.put("out_trade_no", orderid);
		this.uriParams.put("price", price);
		this.uriParams.put("total_fee", price);
	}
}
