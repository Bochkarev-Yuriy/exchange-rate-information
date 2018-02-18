package exchange.rate.information.service.impl;

import exchange.rate.information.model.Currency;
import exchange.rate.information.service.AdapterService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

@Service
public class AdapterServiceImpl implements AdapterService {

	@Override
	public Set<Currency> mapCastToCurrencies(Map<String, String> currenciesMap) {
		Set<Currency> currencies = new HashSet<>();
		for (String key : currenciesMap.keySet()) {
			Currency currency = new Currency();
			currency.setBrief(key);
			currency.setName(currenciesMap.get(key));
			currencies.add(currency);
		}
		return currencies;
	}
}
