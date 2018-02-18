package exchange.rate.information.service;

import java.util.List;
import java.util.Map;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

public interface ProxyService {

	Map<String, Double> getCurrentRateInformation(String source, List<String> currencies);

	Map<String, String> getAllCurrencies();
}
