package domain;

import java.util.ArrayList;
import java.util.List;

public class OperationHistory {
    private List<Operation> operations = new ArrayList<>();

    public OperationHistory() {

    }

    public List<Operation> getOperations() {
        return operations;
    }
}
