package exchange.rate.information.dao;

import exchange.rate.information.model.Job;
import exchange.rate.information.model.MonitoringExchange;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

public interface JobDao extends GenericDao<Long, Job> {

    Job getJobByMonitoringExchangeId(MonitoringExchange id);
}
