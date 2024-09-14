package domain;

import domain.account.Account;
import domain.operation.Operation;
import domain.operation.OperationHistory;
import domain.operation.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

public class AccountTest {

    private OperationHistory operationHistory;
    private FakeDateProvider fakeDateProvider;
    private Account account;
    private static final LocalDateTime FIXED_LOCAL_DATE_TIME = LocalDateTime.of(2024, 9, 14, 12, 0);

    @BeforeEach
    void setUp() {
        fakeDateProvider = new FakeDateProvider();
        operationHistory = new OperationHistory(fakeDateProvider);
        account = new Account(operationHistory);
    }

    @Test
    void should_have_balance_0_when_create_account() {
        // Given When
        var expectedBalance = new Balance(BigDecimal.ZERO);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    void should_new_account_have_balance_of_10_when_deposit_an_amount_of_10() {
        // Given
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
        var expectedBalance = new Balance(BigDecimal.valueOf(-100));
        var withdrawAmount = new Amount(BigDecimal.valueOf(50));

        // When
        account.withdraw(withdrawAmount);
        account.withdraw(withdrawAmount);

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }

    @Test
    void should_account_have_deposit_and_withdraw_operation_after_a_deposit_and_a_withdrawal() {
        // Given
        Amount amount = new Amount(BigDecimal.TEN);

        // When
        account.deposit(amount);
        account.withdraw(amount);

        // Then
        assertThat(account.getOperationHistory().getOperations())
                .hasSize(2)
                .extracting(Operation::getOperationType, Operation::getDate)
                .containsExactlyInAnyOrder(
                        tuple(OperationType.DEPOSIT, FIXED_LOCAL_DATE_TIME),
                        tuple(OperationType.WITHDRAWAL, FIXED_LOCAL_DATE_TIME));
    }
}
