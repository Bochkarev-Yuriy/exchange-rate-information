package exchange.rate.information.dao.impl;

import exchange.rate.information.dao.CurrencyDao;
import exchange.rate.information.model.Currency;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

@Transactional
@Repository
public class CurrencyDaoImpl extends AbstractDao<Long, Currency> implements CurrencyDao {

	@Override
	public Currency getCurrencyByBrief(String brief) {
		return entityManager.createQuery("FROM Currency WHERE brief = :brief", Currency.class).setParameter("brief", brief).getSingleResult();
	}
}
