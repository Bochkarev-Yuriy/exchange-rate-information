package exchange.rate.information.service.impl;

import exchange.rate.information.dao.MonitoringExchangeRateDao;
import exchange.rate.information.dao.exceptions.PersistException;
import exchange.rate.information.model.MonitoringExchangeRate;
import exchange.rate.information.service.MonitoringExchangeRateService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        monitoringExchangeRateDao.update(monitoringExchangeRate);
    }
}
