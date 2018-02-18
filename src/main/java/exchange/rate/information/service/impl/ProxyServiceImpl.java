package exchange.rate.information.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exchange.rate.information.service.ProxyService;
import exchange.rate.information.service.UrlBuilderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

@Service
public class ProxyServiceImpl implements ProxyService {

	@Autowired
	private UrlBuilderService urlBuilderService;

	@Override
	public Map<String, Double> getCurrentRateInformation(String source, List<String> currencies) {
		JSONObject jsonObject = new JSONObject(new RestTemplate().getForObject(urlBuilderService.live(source, currencies), String.class));
		Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		return new Gson().fromJson(String.valueOf(jsonObject.getJSONObject("quotes")), mapType);
	}

	@Override
	public Map<String, String> getAllCurrencies() {
		JSONObject jsonObject = new JSONObject(new RestTemplate().getForObject(urlBuilderService.list(), String.class));
		Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		return new Gson().fromJson(String.valueOf(jsonObject.getJSONObject("currencies")), mapType);
	}
}
