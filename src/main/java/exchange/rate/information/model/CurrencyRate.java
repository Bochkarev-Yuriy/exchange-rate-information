package exchange.rate.information.model;

/**
 * @author Yuriy Bochkarev
 * @since 28.02.18.
 */

public class CurrencyRate {

    private Currency currency;
    private Double rate;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyRate that = (CurrencyRate) o;

        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        return rate != null ? rate.equals(that.rate) : that.rate == null;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "currency=" + currency +
                ", rate=" + rate +
                '}';
    }
}
