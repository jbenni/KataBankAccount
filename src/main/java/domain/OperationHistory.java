package domain;

import java.util.ArrayList;
import java.util.List;

public class OperationHistory {
    private List<Operation> operations = new ArrayList<>();
    private DateProvider dateProvider;

    public OperationHistory(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    public void add(OperationType operationType, Amount amount, Balance balance) {
        this.operations.add(new Operation(dateProvider.now(), operationType, amount, balance));
    }

    public List<Operation> getOperations() {
        return operations;
    }

}
