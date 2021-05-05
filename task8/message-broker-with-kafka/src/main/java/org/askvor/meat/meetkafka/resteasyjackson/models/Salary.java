package org.askvor.meat.meetkafka.resteasyjackson.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Salary {
    private String currency;
    private BigDecimal amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Objects.equals(currency, salary.currency) && Objects.equals(amount, salary.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
