package load.test.apibase;

import org.apache.http.client.methods.HttpDelete;

public abstract class DeleteAPI extends GetAPI {	
	
	@Override
	public void createHttpMethodAndLogRequest(){
		this.request = new HttpDelete(this.host);
		this.setHttpHeaders();	
	}
	
}
