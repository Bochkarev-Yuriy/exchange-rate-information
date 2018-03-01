package exchange.rate.information.dao;

import exchange.rate.information.config.SpringContextTestDao;
import exchange.rate.information.model.Job;
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
public class JobDaoImplTest {

    @Autowired
    private MonitoringExchangeDao monitoringExchangeDao;

    @Autowired
    private JobDao jobDao;

    private Job job;

    @Before
    public void setUp() {
        job = new Job();
        job.setLastStartJob(new Date());
        job.setMonitoringExchange(monitoringExchangeDao.getEntityByKey(1L));
        jobDao.persist(job);
    }

    @Test
    public void JobDaoGetJobByKey() {
        Assert.assertTrue(job.equals(jobDao.getEntityByKey(job.getId())));
    }

    @Test
    public void JobDaoGetAllJob() {
        Assert.assertTrue(jobDao.getAllEntity().contains(job));
    }

    @Test
    public void JobDaoUpdateJob() {
        job.setLastStartJob(new Date(0L));
        jobDao.update(job);
        Assert.assertTrue(job.equals(jobDao.getEntityByKey(job.getId())));
    }

    @Test
    public void JobDaoDeleteJobById() {
        jobDao.deleteByKey(job.getId());
        Assert.assertNull(jobDao.getEntityByKey(job.getId()));
    }
}
