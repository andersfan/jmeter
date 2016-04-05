package load.test.api;

import java.util.HashMap;

import load.test.apibase.PostAPI;

public class PostMergeOrderAPI extends PostAPI {
	public PostMergeOrderAPI(){
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-rtType", "json_orig_result");
		this.uriParams.put("p-apiv", "2.1");
		this.uriParams.put("p-debug","true");
		this.uriParams.put("api_protocol_param","1.0");
		this.uriParams.put("city","杭州市");
		this.uriParams.put("cityCode","0571");
		this.uriParams.put("lng","120.136646");
		this.uriParams.put("lat","30.271359");
		this.headers.put("p-channel", "qiaoba");
	}
}
