package load.test.apibase;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import load.test.objectbase.ResponseObject;

public abstract class BaseAPI {
	protected String apiName;
	protected String entitystr;
	protected File uploadFile;
	protected HttpResponse httpResponse;
	protected Map<String, String> uriParams;
	protected String host;
	protected DefaultHttpClient httpClient;
	protected Map<String, String> headers = new HashMap<String, String>();
	protected HttpUriRequest request;

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return this.host;
	}

	public String getResponseEntityStr() throws IOException {
		HttpEntity entity = this.httpResponse.getEntity();
		String entitystr = EntityUtils.toString(entity);
		EntityUtils.consume(entity);
		return entitystr;
	}

	public String getResponseStatusCode() throws IOException {
		return Integer.toString(this.httpResponse.getStatusLine().getStatusCode());
	}

	public String getResponseStatusPhrase() throws IOException {
		return this.httpResponse.getStatusLine().getReasonPhrase();
	}
	
	public String getResponseHeaderString() {
		String headerString = "";
		for (Header header : this.httpResponse.getAllHeaders()) {
			headerString += header.getName();
			headerString += ":";
			headerString += header.getValue();
			headerString += ";";
		}
		return headerString;
	}

	public String getRequestHeaderString() {
		String headerString = "";
		for (String header : this.getHeaders().keySet()) {
			headerString += header;
			headerString += ":";
			headerString += this.getHeaders().get(header);
			headerString += ";";
		}
		return headerString;
	}

	public void setUriParams() {
		if (this.uriParams == null) {
			return;
		}

		if (this.uriParams.keySet().size() > 0) {
			this.host += "?";
		}

		for (String key : this.uriParams.keySet()) {
			this.host += key;
			this.host += "=";
			this.host += this.uriParams.get(key);
			this.host += "&";
		}

		if (this.uriParams.keySet().size() >= 1) {
			this.host = this.host.substring(0, this.host.length() - 1);
		}
	}

	public void closeConnection() throws IOException {
		httpClient.getConnectionManager().shutdown();
	}

	public void createHttpClientInstance(CookieStore cookieStore) {
		httpClient = new DefaultHttpClient();

		if (cookieStore == null) {
			httpClient.setCookieStore(new BasicCookieStore());
		} else {
			httpClient.setCookieStore(cookieStore);
		}
	}

	protected <T extends ResponseObject> T reflectResponseObject(Class<T> classType) throws IOException {
		Gson gson = new Gson();
		T responseObject = gson.fromJson(getEntitystr(), classType);
		return responseObject;
	}

	public void sendRequest(CookieStore cookieStore) throws ClientProtocolException, IOException {
		this.createHttpClientInstance(cookieStore);
		this.setUriParams();
		this.signKey();
		this.createHttpMethodAndLogRequest();
		this.executeAndLogResponse();
	}

	public void setUriParams(Map<String, String> uriParams) {
		this.uriParams = uriParams;
	}

	protected void executeAndLogResponse() throws IOException, ClientProtocolException {
		try {
			this.httpResponse = this.httpClient.execute(this.request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.entitystr = this.getResponseEntityStr();
	}

	public <T extends ResponseObject> T getResponseObject(CookieStore cookieStore, Class<T> classType)
			throws ClientProtocolException, IOException {
		this.sendRequest(cookieStore);
		T responseObject = this.reflectResponseObject(classType);
		return responseObject;
	}

	public abstract void createHttpMethodAndLogRequest() throws ParseException, IOException;

	public String getEntitystr() {
		return entitystr;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	protected void setHttpHeaders() {
		for (String key : this.getHeaders().keySet()) {
			this.request.setHeader(key, this.getHeaders().get(key));
		}
	}

	protected void setCommonParamAndHeader_New() {
		this.uriParams = new HashMap<String, String>();
		// this.uriParams.put("p-rtType", "json_orig_result");

		this.getHeaders().put("p-pv", "2.0");
		this.getHeaders().put("p-appv", "2.0.0.45");
		this.getHeaders().put("p-appkey", "20151003889");
		this.getHeaders().put("p-rtType", "json_orig_result");
		this.getHeaders().put("p-debug", "true");
	}

	protected String sign(String apiName, String httpBody, String secretKey) {

		// originStr example:
		// /mishi.configCenter.lunch.get/1.0&p-appkey=201456888&p-appv=0.5.0.8&p-pv=2.0

		Map<String, String> protocolParameters = new HashMap<String, String>();
		protocolParameters.put("p-appkey", "20151003889");
		protocolParameters.put("p-rtType", "json_orig_result");
		protocolParameters.put("p-debug", "true");
		protocolParameters.put("p-appv", "2.0.0.45");
		protocolParameters.put("p-pv", "2.0");

		return this.sign(apiName, "1.0", protocolParameters, httpBody, secretKey);
	}

	public abstract void signKey();

	protected String sign(String apiName, String apiVersion, Map<String, String> protocolParameters, String httpBody,
			String secret) {
		TreeMap<String, String> tmap = new TreeMap<String, String>();
		tmap.putAll(protocolParameters);

		StringBuilder originStr = new StringBuilder(128);
		originStr.append("/" + apiName + "/" + apiVersion);

		for (Map.Entry<String, String> e : tmap.entrySet()) {
			originStr.append("&");
			originStr.append(e.getKey());
			originStr.append("=");
			originStr.append(e.getValue());
		}

		if (httpBody != null && !httpBody.isEmpty()) {
			originStr.append("&" + httpBody);
		}

		Mac mac = null;
		try {
			mac = Mac.getInstance("HmacSHA1");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SecretKey secretKey = null;
		try {
			secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "HmacSHA1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			mac.init(secretKey);
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		char[] outputChars = null;
		try {
			outputChars = org.apache.commons.codec.binary.Hex
					.encodeHex(mac.doFinal(originStr.toString().getBytes("utf-8")));
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		StringBuilder newSB = new StringBuilder(128);
		for (char outputChar : outputChars) {
			newSB.append(outputChar);
		}

		return newSB.toString().toUpperCase();
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
}
