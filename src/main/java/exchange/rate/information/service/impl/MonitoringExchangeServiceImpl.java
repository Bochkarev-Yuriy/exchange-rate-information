package exchange.rate.information.service.impl;

import exchange.rate.information.dao.MonitoringExchangeDao;
import exchange.rate.information.dao.exceptions.PersistException;
import exchange.rate.information.model.MonitoringExchange;
import exchange.rate.information.service.MonitoringExchangeService;
import exchange.rate.information.service.exceptions.NotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Service
public class MonitoringExchangeServiceImpl implements MonitoringExchangeService {

    private final static Logger logger = Logger.getLogger(MonitoringExchangeServiceImpl.class);

    @Autowired
    private MonitoringExchangeDao monitoringExchangeDao;

    @Override
    public void addMonitoringExchange(MonitoringExchange monitoringExchange) {
        try {
            monitoringExchangeDao.persist(monitoringExchange);
            logger.info("Added : " + monitoringExchange);
        } catch (HibernateException e) {
            logger.error("Failed to add an monitoringExchange " + monitoringExchange);
            throw new PersistException("Failed to add an monitoringExchange", e);
        }
    }

    @Override
    public List<MonitoringExchange> getAllMonitoringExchange() {
        List<MonitoringExchange> monitoringExchangeListFromDB = monitoringExchangeDao.getAllEntity();
        if (monitoringExchangeListFromDB == null) {
            throw new NotFoundException("The monitoring exchange list is not found.");
        }
        return monitoringExchangeListFromDB;
    }
}
