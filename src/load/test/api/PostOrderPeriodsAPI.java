package load.test.api;

import java.util.HashMap;

import load.test.apibase.PostAPI;

public class PostOrderPeriodsAPI extends PostAPI {
	public PostOrderPeriodsAPI() {
		this.uriParams = new HashMap<String, String>();
		this.uriParams.put("p-pv", "1.0");
		this.uriParams.put("p-rtType", "json_orig_result");
		this.uriParams.put("p-apiv", "1.0");
		this.uriParams.put("p-debug","true");
		this.headers.put("p-channel", "qiaoba");
	}
}
