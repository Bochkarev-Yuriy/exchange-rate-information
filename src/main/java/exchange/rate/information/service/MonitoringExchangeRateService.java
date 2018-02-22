package exchange.rate.information.service;

import exchange.rate.information.model.MonitoringExchangeRate;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

public interface MonitoringExchangeRateService {

    void addMonitoringExchangeRate(MonitoringExchangeRate monitoringExchangeRate);

    void updateMonitoringExchangeRate(MonitoringExchangeRate monitoringExchangeRate);
}
