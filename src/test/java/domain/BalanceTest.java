package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    @Test
    void should_have_balance_100_when_add_50_to_balance_50() {
        // Given
        Balance balance = new Balance(BigDecimal.valueOf(50));
        var expectedBalance = new Balance(BigDecimal.valueOf(100));
        var amount = new Amount(BigDecimal.valueOf(50));

        // When
        Balance newBalance = balance.add(amount);

        // Then
        assertEquals(expectedBalance, newBalance);
    }

    @Test
    void should_have_balance_0_when_substract_50_to_balance_50() {
        // Given
        Balance balance = new Balance(BigDecimal.valueOf(50));
        var expectedBalance = new Balance(BigDecimal.ZERO);
        var amount = new Amount(BigDecimal.valueOf(50));

        // When
        Balance newBalance = balance.substract(amount);

        // Then
        assertEquals(expectedBalance, newBalance);
    }

}