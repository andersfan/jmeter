package load.test.apibase;

import java.io.IOException;
import java.net.URI;

import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;

public abstract class PostAPI extends BaseHttpEntityAPI {
	
	@Override
	public void createHttpMethodAndLogRequest() throws ParseException, IOException{
		URI uri = this.TransferUri();
		HttpPost httpPost = new HttpPost(uri);	
		this.setRequestBody(httpPost);
		this.request = httpPost;	
	}
	
}
