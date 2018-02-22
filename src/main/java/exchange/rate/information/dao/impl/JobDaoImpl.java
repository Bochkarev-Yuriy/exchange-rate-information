package exchange.rate.information.dao.impl;

import exchange.rate.information.dao.JobDao;
import exchange.rate.information.model.Job;
import exchange.rate.information.model.MonitoringExchange;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Transactional
@Repository
public class JobDaoImpl extends AbstractDao<Long, Job> implements JobDao {

    @Override
    public Job getJobByMonitoringExchangeId(MonitoringExchange monitoringExchange) {
        return entityManager.createQuery("SELECT j FROM Job j WHERE j.monitoringExchange = :monitoringExchange", Job.class).setParameter("monitoringExchange", monitoringExchange).getSingleResult();
    }
}
