package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void should_have_balance_0_when_create_account() {
        // Given When
        Account account = new Account(new OperationHistory());
        var expectedBalance = new Balance(BigDecimal.ZERO);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    void should_new_account_have_balance_of_10_when_deposit_an_amount_of_10() {
        // Given
        Account account = new Account(new OperationHistory());
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
        Account account = new Account(new OperationHistory());
        var expectedBalance = new Balance(BigDecimal.valueOf(100));
        var amount = new Amount(BigDecimal.valueOf(50));

        // When
        account.deposit(amount);
        account.deposit(amount);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    void should_new_account_have_balance_of_minus_50_when_withdraw_50() {
        // Given
        Account account = new Account(new OperationHistory());
        var expectedBalance = new Balance(BigDecimal.valueOf(-50));
        var withdrawAmount = new Amount(BigDecimal.valueOf(50));

        // When
        account.withdraw(withdrawAmount);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    void should_account_have_balance_of_minus_100_when_withdraw_50_twice() {
        // Given
        Account account = new Account(new OperationHistory());
        var expectedBalance = new Balance(BigDecimal.valueOf(-100));
        var withdrawAmount = new Amount(BigDecimal.valueOf(50));

        // When
        account.withdraw(withdrawAmount);
        account.withdraw(withdrawAmount);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @ParameterizedTest
    @EnumSource(value = OperationType.class)
    void should_account_have_deposit_and_withdraw_operation_after_a_deposit_and_a_withdrawal(OperationType operationType) {
        // Given
        Account account = new Account(new OperationHistory());
        Amount amount = new Amount(BigDecimal.TEN);

        // When
        account.deposit(amount);
        account.withdraw(amount);

        // Then
        assertThat(account.getOperationHistory().getOperations())
                .hasSize(2)
                .extracting(Operation::getOperationType)
                .containsExactlyInAnyOrder(OperationType.DEPOSIT, OperationType.WITHDRAWAL);
    }
}
