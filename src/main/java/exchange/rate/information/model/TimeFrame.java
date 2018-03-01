package exchange.rate.information.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author Yuriy Bochkarev
 * @since 28.02.18.
 */

public class TimeFrame {

    @JsonIgnore
    private User user;
    private Date startDate;
    private Date endDate;
    private Currency sourceCurrency;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeFrame timeFrame = (TimeFrame) o;

        if (user != null ? !user.equals(timeFrame.user) : timeFrame.user != null) return false;
        if (startDate != null ? !startDate.equals(timeFrame.startDate) : timeFrame.startDate != null) return false;
        if (endDate != null ? !endDate.equals(timeFrame.endDate) : timeFrame.endDate != null) return false;
        return sourceCurrency != null ? sourceCurrency.equals(timeFrame.sourceCurrency) : timeFrame.sourceCurrency == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (sourceCurrency != null ? sourceCurrency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimeFrame{" +
                "user=" + user +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", sourceCurrency=" + sourceCurrency +
                '}';
    }
}
