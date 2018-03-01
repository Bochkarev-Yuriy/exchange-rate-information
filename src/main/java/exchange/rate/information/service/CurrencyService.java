package exchange.rate.information.service;

import exchange.rate.information.model.Currency;

import java.util.Collection;
import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

public interface CurrencyService {

	void addCurrency(Currency currency);

	void addCurrencies(Collection<Currency> currencies);

	Currency getCurrencyByBrief(String briefName);

	List<Currency> getAllCurrencies();
}
