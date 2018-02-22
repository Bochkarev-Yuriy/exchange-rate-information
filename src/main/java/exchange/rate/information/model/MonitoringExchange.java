package exchange.rate.information.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

@Entity
@Table(name = "monitoring_exchange")
public class MonitoringExchange {

    @Id
    @TableGenerator(name = "monitoring_exchange_gen",
            table = "sequences",
            pkColumnName = "name",
            valueColumnName = "number",
            pkColumnValue = "monitoring_exchange",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "monitoring_exchange_gen")
    @JsonIgnore
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(targetEntity = Currency.class)
    @JoinColumn(name = "source_currency_id")
    private Currency sourceCurrency;

    @Column(name = "interval")
    private Long interval;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Currency.class)
    @JoinTable(name = "source_currency_currencies",
            joinColumns = {@JoinColumn(name = "monitoring_exchange_id")},
            inverseJoinColumns = {@JoinColumn(name = "currency_id")})
    private Set<Currency> currencies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Set<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<Currency> currencies) {
        this.currencies = currencies;
    }

    public void addCurrency(Currency currency) {
        if (currency == null) {
            currencies = new HashSet<>();
        }
        currencies.add(currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonitoringExchange that = (MonitoringExchange) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (sourceCurrency != null ? !sourceCurrency.equals(that.sourceCurrency) : that.sourceCurrency != null)
            return false;
        if (interval != null ? !interval.equals(that.interval) : that.interval != null) return false;
        return currencies != null ? currencies.equals(that.currencies) : that.currencies == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (sourceCurrency != null ? sourceCurrency.hashCode() : 0);
        result = 31 * result + (interval != null ? interval.hashCode() : 0);
        result = 31 * result + (currencies != null ? currencies.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MonitoringExchange{" +
                "id=" + id +
                ", user=" + user +
                ", sourceCurrency=" + sourceCurrency +
                ", interval=" + interval +
                ", currencies=" + currencies +
                '}';
    }
}
