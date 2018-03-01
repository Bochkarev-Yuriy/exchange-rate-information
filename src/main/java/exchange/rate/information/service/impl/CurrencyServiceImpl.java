package exchange.rate.information.service.impl;

import exchange.rate.information.dao.CurrencyDao;
import exchange.rate.information.dao.exceptions.PersistException;
import exchange.rate.information.model.Currency;
import exchange.rate.information.service.CurrencyService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

import java.util.Collection;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	private final static Logger logger = Logger.getLogger(CurrencyServiceImpl.class);

	@Autowired
	private CurrencyDao currencyDao;

	@Override
	public void addCurrency(Currency currency) {
		try {
			currencyDao.persist(currency);
			logger.info("Added : " + currency);
		} catch (HibernateException e) {
			logger.error("Failed to add an currency " + currency);
			throw new PersistException("Failed to add an currency", e);
		}
	}

	@Override
	public void addCurrencies(Collection<Currency> currencies) {
		for (Currency currency : currencies) {
			addCurrency(currency);
		}
	}

	@Override
	public Currency getCurrencyByBrief(String briefName) {
		return currencyDao.getCurrencyByBrief(briefName);
	}

	@Override
	public List<Currency> getAllCurrencies() {
		return currencyDao.getAllEntity();
	}
}
