package exchange.rate.information.service;

import exchange.rate.information.model.Currency;

import java.util.Map;
import java.util.Set;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

public interface AdapterService {

    Set<Currency> mapCastToCurrencies(Map<String, String> currenciesMap);

    Map<String, Double> proxyCurrentRateInformationMapCastValidCurrentRateInformationMap(Map<String, Double> proxyCurrentRateInformation, String sourceCurrency);
}
