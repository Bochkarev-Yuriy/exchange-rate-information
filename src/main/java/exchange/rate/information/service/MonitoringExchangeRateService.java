package exchange.rate.information.service;

import exchange.rate.information.model.ExchangeRateInformationTimeFrame;
import exchange.rate.information.model.MonitoringExchangeRate;
import exchange.rate.information.model.TimeFrame;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

public interface MonitoringExchangeRateService {

    void addMonitoringExchangeRate(MonitoringExchangeRate monitoringExchangeRate);

    void updateMonitoringExchangeRate(MonitoringExchangeRate monitoringExchangeRate);

    List<ExchangeRateInformationTimeFrame> getRateByTimeFrame(TimeFrame timeFrame);

}
