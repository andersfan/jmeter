package load.test.apibase;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPut;

public abstract class PutAPI extends PostAPI {
	
	@Override
	public void createHttpMethodAndLogRequest() throws ParseException, IOException{
		HttpPut httpPut = new HttpPut(this.host);
		this.setRequestBody(httpPut);
		this.request = httpPut;	
	}
	
}
