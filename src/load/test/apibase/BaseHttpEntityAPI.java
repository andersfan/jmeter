package load.test.apibase;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import com.google.gson.Gson;

import load.test.objectbase.RequestObject;

public abstract class BaseHttpEntityAPI extends BaseAPI {

	protected List<NameValuePair> requestContent;
	protected String requestString;

	public void setRequestContent(List<NameValuePair> requestContent) {
		this.requestContent = requestContent;
	}

	public void setRequestString(String requestString) {
		this.requestString = requestString;
	}

	protected void setRequestBody(HttpEntityEnclosingRequestBase httpPost) throws UnsupportedEncodingException {
		if (this.requestContent != null) {
			httpPost.setEntity(new UrlEncodedFormEntity(this.requestContent));
		} else if (requestString != null) {
			StringEntity entity = new StringEntity(this.requestString, "utf-8");
			this.getHeaders().put("Content-Type", "application/json");
			httpPost.setEntity(entity);
		} else if (uploadFile != null) {
			MultipartEntity mutiEntity = new MultipartEntity();
			mutiEntity.addPart("pic", new FileBody(uploadFile));
			httpPost.setEntity(mutiEntity);
			//this.headers.put("Content-Disposition", "form-data;name=\"file\";filename=" + uploadFile.getName());
			//this.headers.put("content-type","application/octet-stream;charset=UTF-8");
			//this.headers.put("Content-Transfer-Encoding","binary");
		}	

		for (String key : this.getHeaders().keySet()) {
			httpPost.setHeader(key, this.getHeaders().get(key));
		}
	}

	public <T extends RequestObject> void serializeRequestObject(T requestObject) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(requestObject);
		this.setRequestString(jsonStr);
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public void signKey() {
		String sign = this.sign(this.apiName, this.requestString, "q1w2e3r4t5y6u7i8o9p0");
		//String sign = this.sign(this.apiName, this.requestString, "J9\\5lwVu(-eez*pp\\dIt*z-Asogtp)SAXi^bxqMY6Iu6BjqnwPLUDVH+wi#Jzz9*");
		this.getHeaders().put("x-sign", sign);
	}
}
