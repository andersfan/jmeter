package load.test.apibase;

import java.io.IOException;
import java.net.URI;

import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPut;

public abstract class PutAPI extends PostAPI {
	
	@Override
	public void createHttpMethodAndLogRequest() throws ParseException, IOException{
		URI uri = this.TransferUri();
		HttpPut httpPut = new HttpPut(uri);
		this.setRequestBody(httpPut);
		this.request = httpPut;	
	}
	
}
