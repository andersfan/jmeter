package load.test.apibase;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;

public abstract class GetAPI extends BaseAPI {
	
	@Override
	public void createHttpMethodAndLogRequest(){
		URI uri = this.TransferUri();
		this.request = new HttpGet(uri);		
		this.setHttpHeaders();	
	}
	
	@Override
	public void signKey() {
		String sign = this.sign(this.apiName, null, "q1w2e3r4t5y6u7i8o9p0");
		//String sign = this.sign(this.apiName, null, "J9\\5lwVu(-eez*pp\\dIt*z-Asogtp)SAXi^bxqMY6Iu6BjqnwPLUDVH+wi#Jzz9*");
		this.getHeaders().put("x-sign", sign);
	}
}
