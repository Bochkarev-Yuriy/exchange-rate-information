package exchange.rate.information.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Yuriy Bochkarev
 * @since 19.02.18.
 */

@Entity
@Table(name = "monitoring_exchange_rate")
public class MonitoringExchangeRate {

    @Id
    @TableGenerator(name = "monitoring_exchange_rate_gen",
            table = "sequences",
            pkColumnName = "name",
            valueColumnName = "number",
            pkColumnValue = "monitoring_exchange_rate",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "monitoring_exchange_rate_gen")
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = Currency.class)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @OneToOne(targetEntity = MonitoringExchange.class)
    @JoinColumn(name = "monitoring_exchange_id")
    private MonitoringExchange monitoringExchange;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public MonitoringExchange getMonitoringExchange() {
        return monitoringExchange;
    }

    public void setMonitoringExchange(MonitoringExchange monitoringExchange) {
        this.monitoringExchange = monitoringExchange;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonitoringExchangeRate that = (MonitoringExchangeRate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (monitoringExchange != null ? !monitoringExchange.equals(that.monitoringExchange) : that.monitoringExchange != null)
            return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (monitoringExchange != null ? monitoringExchange.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MonitoringExchangeRate{" +
                "id=" + id +
                ", currency=" + currency +
                ", monitoringExchange=" + monitoringExchange +
                ", rate=" + rate +
                ", date=" + date +
                '}';
    }
}
