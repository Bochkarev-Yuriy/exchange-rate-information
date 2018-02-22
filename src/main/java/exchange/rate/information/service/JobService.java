package exchange.rate.information.service;

import exchange.rate.information.model.Job;
import exchange.rate.information.model.MonitoringExchange;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

public interface JobService {

    Job getJobByMonitoringExchangeId(MonitoringExchange id);

    void addJob(Job job);

    List<Job> getAllJob();

    void updateJob(Job job);
}
