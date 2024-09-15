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
    void should_print_all_operations() {
        // Given
        var amount = new Amount(BigDecimal.TEN);

        var balanceAfterFirstDeposit = new Balance(BigDecimal.TEN);
        var balanceAfterSecondDeposit = balanceAfterFirstDeposit.add(amount);

        var firstDeposit = new Operation(fakeDateProvider.now(), OperationType.DEPOSIT, amount, balanceAfterFirstDeposit);
        var secondDeposit = new Operation(fakeDateProvider.now(), OperationType.DEPOSIT, amount, balanceAfterSecondDeposit);

        var operations = List.of(firstDeposit, secondDeposit);

        StringBuilder sb = new StringBuilder();
        operations.forEach(sb::append);

        // When
        var actualPrint = consoleStatementPrinter.print(operations);

        // Then
        assertThat(actualPrint).isEqualTo(sb.toString());
    }

}