package exchange.rate.information.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @TableGenerator(name = "job_gen",
            table = "sequences",
            pkColumnName = "name",
            valueColumnName = "number",
            pkColumnValue = "jobs",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "job_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "last_start_job")
    private Date lastStartJob;

    @OneToOne(targetEntity = MonitoringExchange.class)
    @JoinColumn(name = "job_id")
    private MonitoringExchange monitoringExchange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastStartJob() {
        return lastStartJob;
    }

    public void setLastStartJob(Date lastStartJob) {
        this.lastStartJob = lastStartJob;
    }

    public MonitoringExchange getMonitoringExchange() {
        return monitoringExchange;
    }

    public void setMonitoringExchange(MonitoringExchange monitoringExchange) {
        this.monitoringExchange = monitoringExchange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job1 = (Job) o;

        if (id != null ? !id.equals(job1.id) : job1.id != null) return false;
        if (lastStartJob != null ? !lastStartJob.equals(job1.lastStartJob) : job1.lastStartJob != null) return false;
        return monitoringExchange != null ? monitoringExchange.equals(job1.monitoringExchange) : job1.monitoringExchange == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastStartJob != null ? lastStartJob.hashCode() : 0);
        result = 31 * result + (monitoringExchange != null ? monitoringExchange.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", lastStartJob=" + lastStartJob +
                ", monitoringExchange=" + monitoringExchange +
                '}';
    }
}
