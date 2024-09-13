package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void should_have_balance_0_when_create_account() {
        // Given When
        Account account = new Account();
        var expectedBalance = new Balance(BigDecimal.ZERO);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    void should_new_account_have_balance_of_10_when_deposit_an_amount_of_10() {
        // Given
        Account account = new Account();
        var expectedBalance = new Balance(BigDecimal.TEN);
        var amount = new Amount(BigDecimal.TEN);

        // When
        account.deposit(amount);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    void should_account_have_balance_of_100_when_deposit_an_amount_of_50_twice() {
        // Given
        Account account = new Account();
        var expectedBalance = new Balance(BigDecimal.valueOf(100));
        var amount = new Amount(BigDecimal.valueOf(50));
        // When
        account.deposit(amount);
        account.deposit(amount);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }
}
