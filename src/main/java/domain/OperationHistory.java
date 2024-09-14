package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OperationHistory {
    private List<Operation> operations = new ArrayList<>();

    public OperationHistory() {

    }

    public void add(LocalDateTime date, OperationType operationType, Amount amount, Balance balance) {
        this.operations.add(new Operation(date, operationType, amount, balance));
    }

    public List<Operation> getOperations() {
        return operations;
    }

}
