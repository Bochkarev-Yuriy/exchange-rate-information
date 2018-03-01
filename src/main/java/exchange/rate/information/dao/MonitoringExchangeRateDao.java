package exchange.rate.information.dao;

import exchange.rate.information.model.MonitoringExchangeRate;
import exchange.rate.information.model.TimeFrame;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

public interface MonitoringExchangeRateDao extends GenericDao<Long, MonitoringExchangeRate> {

    List<MonitoringExchangeRate> getMonitoringExchangeByTimeFrame(TimeFrame timeFrame);
}
