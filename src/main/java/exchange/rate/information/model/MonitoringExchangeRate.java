package exchange.rate.information.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Yuriy Bochkarev
 * @since 18.02.18.
 */

@Entity
@Table(name = "monitoring_exchange_rate")
public class MonitoringExchangeRate {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(targetEntity = Currency.class)
	@JoinColumn(name = "source_currency_id")
	private Currency sourceCurrency;

	@Column(name = "date")
	private Date date;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Currency.class)
	@JoinTable(name = "source_currency_currencies",
			joinColumns = {@JoinColumn(name = "monitoring_exchange_rate_id")},
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Set<Currency> currencies) {
		this.currencies = currencies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MonitoringExchangeRate that = (MonitoringExchangeRate) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (user != null ? !user.equals(that.user) : that.user != null) return false;
		if (sourceCurrency != null ? !sourceCurrency.equals(that.sourceCurrency) : that.sourceCurrency != null)
			return false;
		if (date != null ? !date.equals(that.date) : that.date != null) return false;
		return currencies != null ? currencies.equals(that.currencies) : that.currencies == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (user != null ? user.hashCode() : 0);
		result = 31 * result + (sourceCurrency != null ? sourceCurrency.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		result = 31 * result + (currencies != null ? currencies.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "MonitoringExchangeRate{" +
				"id=" + id +
				", user=" + user +
				", sourceCurrency=" + sourceCurrency +
				", date=" + date +
				", currencies=" + currencies +
				'}';
	}
}
