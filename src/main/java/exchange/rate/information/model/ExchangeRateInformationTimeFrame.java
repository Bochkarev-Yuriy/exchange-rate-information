package exchange.rate.information.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuriy Bochkarev
 * @since 28.02.18.
 */

public class ExchangeRateInformationTimeFrame {

    private Date date;
    private Currency currency;
    private Set<CurrencyRate> currencies;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Set<CurrencyRate> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<CurrencyRate> currencies) {
        this.currencies = currencies;
    }

    public void addCurrencies(CurrencyRate currency) {
        if (currencies == null) {
            this.currencies = new HashSet<>();
        }
        currencies.add(currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeRateInformationTimeFrame that = (ExchangeRateInformationTimeFrame) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        return currencies != null ? currencies.equals(that.currencies) : that.currencies == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (currencies != null ? currencies.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExchangeRateInformationTimeFrame{" +
                "date=" + date +
                ", currency=" + currency +
                ", currencies=" + currencies +
                '}';
    }
}
