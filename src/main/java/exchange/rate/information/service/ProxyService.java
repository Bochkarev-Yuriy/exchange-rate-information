package exchange.rate.information.service;

import exchange.rate.information.constant.Constant;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ProxyService {


	public static void main(String[] args) {
		ProxyService obj = new ProxyService();
		obj.getLive();
	}

	public void getLive() {
		JSONObject jsonObject = new JSONObject(new RestTemplate().getForObject(buildUrl(), String.class));
		System.out.println(jsonObject);
	}

	public String buildUrl() {
		return Constant.ROOT_ADDRESS + Constant.LIVE + Constant.PARAM_ACCESS_KEY + Constant.USER_ACCESS_KEY;
//		return LIVE +
//				"?access_key=" + ACCESS_KEY +
////				"&source=GBP" +
//				"&currencies=USD,AUD,CAD,PLN,MXN";
//				+
//				"&format=1";
	}
}
