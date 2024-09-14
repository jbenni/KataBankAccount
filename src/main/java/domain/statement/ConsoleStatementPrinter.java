package domain.statement;

import domain.operation.Operation;

import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter{

    @Override
    public String print(List<Operation> operations) {
        StringBuilder sb = new StringBuilder();
        operations.forEach(sb::append);
        return sb.toString();
    }
}
