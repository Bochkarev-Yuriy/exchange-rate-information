package exchange.rate.information.dao;

import exchange.rate.information.config.SpringContextTestDao;
import exchange.rate.information.model.MonitoringExchange;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuriy Bochkarev
 * @since 01.03.18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringContextTestDao.class})
@WebAppConfiguration
@Transactional
public class MonitoringExchangeDaoImplTest {

    @Autowired
    private MonitoringExchangeDao monitoringExchangeDao;

    private MonitoringExchange monitoringExchange;

    @Before
    public void setUp() {
        monitoringExchange = monitoringExchangeDao.getEntityByKey(1L);
    }

    @Test
    public void MonitoringExchangeDaoGetMonitoringExchangeByKey() {
        Assert.assertTrue(monitoringExchange.equals(monitoringExchangeDao.getEntityByKey(monitoringExchange.getId())));
    }

    @Test
    public void MonitoringExchangeDaoGetAllMonitoringExchange() {
        Assert.assertTrue(monitoringExchangeDao.getAllEntity().contains(monitoringExchange));
    }

    @Test
    public void MonitoringExchangeDaoUpdateMonitoringExchange() {
        monitoringExchange.setInterval(999999L);
        monitoringExchangeDao.update(monitoringExchange);
        Assert.assertTrue(monitoringExchange.equals(monitoringExchangeDao.getEntityByKey(monitoringExchange.getId())));
    }

    @Test
    public void MonitoringExchangeDaoDeleteMonitoringExchangeById() {
        monitoringExchangeDao.deleteByKey(monitoringExchange.getId());
        Assert.assertNull(monitoringExchangeDao.getEntityByKey(monitoringExchange.getId()));
    }
}
