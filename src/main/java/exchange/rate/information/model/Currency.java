package exchange.rate.information.model;

import javax.persistence.*;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "brief", length = 50, nullable = false, unique = true)
    private String brief;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (id != null ? !id.equals(currency.id) : currency.id != null) return false;
        if (brief != null ? !brief.equals(currency.brief) : currency.brief != null) return false;
        return name != null ? name.equals(currency.name) : currency.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", brief='" + brief + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
