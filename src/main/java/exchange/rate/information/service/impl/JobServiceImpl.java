package exchange.rate.information.service.impl;

import exchange.rate.information.dao.JobDao;
import exchange.rate.information.dao.exceptions.MergeException;
import exchange.rate.information.dao.exceptions.PersistException;
import exchange.rate.information.model.Job;
import exchange.rate.information.model.MonitoringExchange;
import exchange.rate.information.service.JobService;
import exchange.rate.information.service.exceptions.NotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Service
public class JobServiceImpl implements JobService {

    private final static Logger logger = Logger.getLogger(JobServiceImpl.class);

    @Autowired
    private JobDao jobDao;

    @Override
    public Job getJobByMonitoringExchangeId(MonitoringExchange monitoringExchange) {
        Job jobFromDB = null;
        try {
            jobFromDB = jobDao.getJobByMonitoringExchangeId(monitoringExchange);
            logger.info("getJobByMonitoringExchange : " + monitoringExchange);
        } catch (NoResultException e) {
            logger.error("The job is not found " + monitoringExchange);
        }
        return jobFromDB;
    }

    @Override
    public void addJob(Job job) {
        try {
            jobDao.persist(job);
            logger.info("Added : " + job);
        } catch (HibernateException e) {
            logger.error("Failed to add an job " + job);
            throw new PersistException("Failed to add an job", e);
        }
    }

    @Override
    public List<Job> getAllJob() {
        List<Job> jobsFromDB = jobDao.getAllEntity();
        if (jobsFromDB == null) {
            throw new NotFoundException("The jobs is not found.");
        }
        return jobsFromDB;
    }

    @Override
    public void updateJob(Job job) {
        try {
            jobDao.update(job);
            logger.info("Update : " + job);
        } catch (HibernateException e) {
            logger.error("Failed to update an job " + job);
            throw new MergeException("Failed to update an job", e);
        }
    }
}
