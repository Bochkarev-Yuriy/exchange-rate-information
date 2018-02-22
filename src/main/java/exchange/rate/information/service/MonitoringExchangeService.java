package exchange.rate.information.service;

import exchange.rate.information.model.MonitoringExchange;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

public interface MonitoringExchangeService {

    void addMonitoringExchange(MonitoringExchange monitoringExchange);

    List<MonitoringExchange> getAllMonitoringExchange();
}
