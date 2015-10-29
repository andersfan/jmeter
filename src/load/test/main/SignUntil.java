package load.test.main;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class SignUntil {

	public String sign(String apiName, String httpBody, String secretKey)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

		// originStr example:
		// /mishi.configCenter.lunch.get/1.0&p-appkey=201456888&p-appv=0.5.0.8&p-pv=2.0

		Map<String, String> protocolParameters = new HashMap<String, String>();
		protocolParameters.put("p-appkey", "20151003889");
		protocolParameters.put("p-appv", "2.0.0.45");
		protocolParameters.put("p-pv", "2.0");
		protocolParameters.put("p-debug", "true");
		protocolParameters.put("p-rtType", "json_orig_result");
		
		return this.sign(apiName, "1.0", protocolParameters, httpBody, secretKey);
	}

	public String sign(String apiName, String apiVersion, Map<String, String> protocolParameters, String httpBody,
			String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
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

		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKey secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "HmacSHA1");
		mac.init(secretKey);
		char[] outputChars = Hex.encodeHex(mac.doFinal(originStr.toString().getBytes("utf-8")));

		StringBuilder newSB = new StringBuilder(128);
		for (char outputChar : outputChars) {
			newSB.append(outputChar);
		}

		return newSB.toString().toUpperCase();
	}
}
