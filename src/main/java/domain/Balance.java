package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Balance {

    private BigDecimal amount;

    public Balance(BigDecimal value) {
        this.amount = value;
    }

    public Balance add(BigDecimal value) {
        return new Balance(this.amount.add(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance balance)) return false;
        return Objects.equals(amount, balance.amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
