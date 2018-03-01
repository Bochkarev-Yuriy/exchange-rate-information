package exchange.rate.information.dao;

import exchange.rate.information.config.SpringContextTestDao;
import exchange.rate.information.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Yuriy Bochkarev
 * @since 01.03.18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringContextTestDao.class})
@WebAppConfiguration
@Transactional
public class MonitoringExchangeRateDaoImplTest {

    @Autowired
    private MonitoringExchangeDao monitoringExchangeDao;

    @Autowired
    private CurrencyDao currencyDao;

    @Autowired
    private MonitoringExchangeRateDao monitoringExchangeRateDao;

    private MonitoringExchangeRate monitoringExchangeRate;

    @Before
    public void setUp() {
//		<---Adding MonitoringExchangeRate into a DB--->
        monitoringExchangeRate = new MonitoringExchangeRate();
        monitoringExchangeRate.setMonitoringExchange(monitoringExchangeDao.getEntityByKey(1L));
        monitoringExchangeRate.setCurrency(currencyDao.getCurrencyByBrief("USD"));
        monitoringExchangeRate.setRate(100500D);
        monitoringExchangeRate.setDate(new Date());
        monitoringExchangeRateDao.persist(monitoringExchangeRate);
    }

    @Test
    public void MonitoringExchangeRateDaoGetMonitoringExchangeRateByKey() {
        Assert.assertTrue(monitoringExchangeRate.equals(monitoringExchangeRateDao.getEntityByKey(monitoringExchangeRate.getId())));
    }

    @Test
    public void MonitoringExchangeRateDaoGetAllMonitoringExchangeRate() {
        Assert.assertTrue(monitoringExchangeRateDao.getAllEntity().contains(monitoringExchangeRate));
    }

    @Test
    public void MonitoringExchangeRateDaoUpdateMonitoringExchangeRate() {
        monitoringExchangeRate.setRate(999999D);
        monitoringExchangeRateDao.update(monitoringExchangeRate);
        Assert.assertTrue(monitoringExchangeRate.equals(monitoringExchangeRateDao.getEntityByKey(monitoringExchangeRate.getId())));
    }

    @Test
    public void MonitoringExchangeRateDaoDeleteMonitoringExchangeRateById() {
        monitoringExchangeRateDao.deleteByKey(monitoringExchangeRate.getId());
        Assert.assertNull(monitoringExchangeRateDao.getEntityByKey(monitoringExchangeRate.getId()));
    }
}
