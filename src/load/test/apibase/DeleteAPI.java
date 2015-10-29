package load.test.apibase;

import java.net.URI;

import org.apache.http.client.methods.HttpDelete;

public abstract class DeleteAPI extends GetAPI {	
	
	@Override
	public void createHttpMethodAndLogRequest(){
		URI uri = this.TransferUri();
		this.request = new HttpDelete(uri);
		this.setHttpHeaders();	
	}
	
}
