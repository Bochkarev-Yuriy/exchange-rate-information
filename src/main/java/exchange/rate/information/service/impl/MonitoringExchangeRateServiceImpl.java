package exchange.rate.information.service.impl;

import exchange.rate.information.dao.MonitoringExchangeRateDao;
import exchange.rate.information.dao.exceptions.MergeException;
import exchange.rate.information.dao.exceptions.PersistException;
import exchange.rate.information.model.*;
import exchange.rate.information.model.Currency;
import exchange.rate.information.service.MonitoringExchangeRateService;
import exchange.rate.information.service.exceptions.NotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Service
public class MonitoringExchangeRateServiceImpl implements MonitoringExchangeRateService {

    private final static Logger logger = Logger.getLogger(MonitoringExchangeRateServiceImpl.class);

    @Autowired
    private MonitoringExchangeRateDao monitoringExchangeRateDao;

    @Override
    public void addMonitoringExchangeRate(MonitoringExchangeRate monitoringExchangeRate) {
        try {
            monitoringExchangeRateDao.persist(monitoringExchangeRate);
            logger.info("Added : " + monitoringExchangeRate);
        } catch (HibernateException e) {
            logger.error("Failed to add an monitoringExchangeRate " + monitoringExchangeRate);
            throw new PersistException("Failed to add an monitoringExchangeRate", e);
        }
    }

    @Override
    public void updateMonitoringExchangeRate(MonitoringExchangeRate monitoringExchangeRate) {
        try {
            monitoringExchangeRateDao.update(monitoringExchangeRate);
            logger.info("Update : " + monitoringExchangeRate);
        } catch (HibernateException e) {
            logger.error("Failed to update an monitoringExchangeRate " + monitoringExchangeRate);
            throw new MergeException("Failed to update an monitoringExchangeRate", e);
        }
    }

    @Override
    public List<ExchangeRateInformationTimeFrame> getRateByTimeFrame(TimeFrame timeFrame) {
        List<MonitoringExchangeRate> monitoringExchangeRateList = monitoringExchangeRateDao.getMonitoringExchangeByTimeFrame(timeFrame);

        if (monitoringExchangeRateList == null) {
            logger.info("The monitoringExchangeRateList is not found. TimeFrame: " + timeFrame);
            throw new NotFoundException("The monitoringExchangeRateList is not found.");
        }

        Map<Date, Map<Currency, List<MonitoringExchangeRate>>> history = new HashMap<>();
        for (MonitoringExchangeRate monitoringExchangeRate : monitoringExchangeRateList) {
            history.computeIfAbsent(monitoringExchangeRate.getDate(), k -> new HashMap<>());
            history.get(monitoringExchangeRate.getDate()).computeIfAbsent(monitoringExchangeRate.getMonitoringExchange().getSourceCurrency(), k -> new ArrayList<>());
            history.get(monitoringExchangeRate.getDate()).get(monitoringExchangeRate.getMonitoringExchange().getSourceCurrency()).add(monitoringExchangeRate);
        }

        List<ExchangeRateInformationTimeFrame> exchangeRateInformationTimeFrameList = new ArrayList<>();
        for (Date date : history.keySet()) {
            ExchangeRateInformationTimeFrame exchangeRateInformationTimeFrame = new ExchangeRateInformationTimeFrame();
            exchangeRateInformationTimeFrame.setDate(date);
            for (Currency sourceCurrency : history.get(date).keySet()) {
                exchangeRateInformationTimeFrame.setCurrency(sourceCurrency);
                for (MonitoringExchangeRate monitoringExchangeRate : history.get(date).get(sourceCurrency)) {
                    CurrencyRate currencyRate = new CurrencyRate();
                    currencyRate.setCurrency(monitoringExchangeRate.getCurrency());
                    currencyRate.setRate(monitoringExchangeRate.getRate());
                    exchangeRateInformationTimeFrame.addCurrencies(currencyRate);
                }
            }
            exchangeRateInformationTimeFrameList.add(exchangeRateInformationTimeFrame);
        }
        return exchangeRateInformationTimeFrameList;
    }
}
