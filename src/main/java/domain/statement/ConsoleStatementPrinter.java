package domain.statement;

import domain.Amount;
import domain.Balance;
import domain.operation.Operation;
import domain.operation.OperationType;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter{

    @Override
    public String print(List<Operation> operations) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s | %-10s | %-10s | %-10s%n", "DATE", "OPERATION", "AMOUNT", "BALANCE"));
        sb.append("--------------------------------------------------------------\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        operations.forEach(operation -> sb.append(String.format("%-20s | %-10s | %-10s | %-10s%n",
                operation.getDate().format(formatter),
                operation.getOperationType(),
                operation.getAmount().getValue(),
                operation.getBalance().getValue())));


        return sb.toString();
    }
}
