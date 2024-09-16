package domain.statement;

import domain.Amount;
import domain.Balance;
import domain.FakeDateProvider;
import domain.operation.Operation;
import domain.operation.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleStatementPrinterTest {
    private FakeDateProvider fakeDateProvider;
    private ConsoleStatementPrinter consoleStatementPrinter;

    @BeforeEach
    void setUp() {
        fakeDateProvider = new FakeDateProvider();
        consoleStatementPrinter = new ConsoleStatementPrinter();
    }

    @Test
    void should_print_operations_correctly() {
        // Given
        var amount = new Amount(BigDecimal.TEN);
        var balanceAfterFirstDeposit = new Balance(BigDecimal.TEN);
        var balanceAfterWithdrawal = balanceAfterFirstDeposit.substract(amount);

        Operation deposit = new Operation(fakeDateProvider.now(), OperationType.DEPOSIT, amount, balanceAfterFirstDeposit);
        Operation withdrawal = new Operation(fakeDateProvider.now().plusHours(2), OperationType.WITHDRAWAL, amount, balanceAfterWithdrawal);

        List<Operation> operations = List.of(deposit, withdrawal);

        // When
        String result = consoleStatementPrinter.print(operations);

        // Then
        String expectedOutput = "DATE                 | OPERATION  | AMOUNT     | BALANCE    \n" +
                "--------------------------------------------------------------\n" +
                "2024-09-14T12:00:00  | DEPOSIT    | 10         | 10         \n" +
                "2024-09-14T14:00:00  | WITHDRAWAL | 5          | 5          \n";

        assertThat(result).isEqualTo(expectedOutput);
    }
}