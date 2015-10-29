package load.test.apibase;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;

public abstract class PostAPI extends BaseHttpEntityAPI {
	
	@Override
	public void createHttpMethodAndLogRequest() throws ParseException, IOException{
		HttpPost httpPost = new HttpPost(this.host);	
		this.setRequestBody(httpPost);
		this.request = httpPost;	
	}
	
}
