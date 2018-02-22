package exchange.rate.information.dao.impl;

import exchange.rate.information.dao.MonitoringExchangeRateDao;
import exchange.rate.information.model.MonitoringExchangeRate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Transactional
@Repository
public class MonitoringExchangeRateDaoImpl extends AbstractDao<Long, MonitoringExchangeRate> implements MonitoringExchangeRateDao {

}
