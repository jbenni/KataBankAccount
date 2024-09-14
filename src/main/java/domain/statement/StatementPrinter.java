package domain.statement;

import domain.operation.Operation;

import java.util.List;

public interface StatementPrinter {
    String print(List<Operation> operations);
}
