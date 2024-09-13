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

        // When
        Balance newBalance = balance.add(BigDecimal.valueOf(50));

        // Then
        assertEquals(expectedBalance, newBalance);
    }

}