package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Balance {

    private BigDecimal value;

    public Balance(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance balance)) return false;
        return Objects.equals(value, balance.value);
    }
}
