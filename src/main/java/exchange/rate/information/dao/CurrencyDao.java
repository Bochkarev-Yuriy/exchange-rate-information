package exchange.rate.information.dao;

import exchange.rate.information.model.Currency;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

public interface CurrencyDao extends GenericDao<Long, Currency> {

	Currency getCurrencyByBrief(String brief);
}
