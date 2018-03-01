package exchange.rate.information.dao.impl;

import exchange.rate.information.dao.MonitoringExchangeRateDao;
import exchange.rate.information.model.MonitoringExchangeRate;
import exchange.rate.information.model.TimeFrame;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Transactional
@Repository
public class MonitoringExchangeRateDaoImpl extends AbstractDao<Long, MonitoringExchangeRate> implements MonitoringExchangeRateDao {

    @Override
    public List<MonitoringExchangeRate> getMonitoringExchangeByTimeFrame(TimeFrame timeFrame) {
        return entityManager.createQuery("SELECT mer FROM MonitoringExchangeRate mer " +
                "WHERE mer.monitoringExchange.user.id = :userId " +
                "AND mer.date >= :startDate " +
                "AND mer.date <= :endDate " +
                "AND mer.monitoringExchange.sourceCurrency = :sourceCurrency",MonitoringExchangeRate.class)
                .setParameter("userId", timeFrame.getUser().getId())
                .setParameter("startDate", timeFrame.getStartDate())
                .setParameter("endDate", timeFrame.getEndDate())
                .setParameter("sourceCurrency", timeFrame.getSourceCurrency())
                .getResultList();
    }

}
