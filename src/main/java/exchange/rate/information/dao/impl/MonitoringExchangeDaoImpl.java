package exchange.rate.information.dao.impl;

import exchange.rate.information.dao.MonitoringExchangeDao;
import exchange.rate.information.model.MonitoringExchange;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Transactional
@Repository
public class MonitoringExchangeDaoImpl extends AbstractDao<Long, MonitoringExchange> implements MonitoringExchangeDao {
}
