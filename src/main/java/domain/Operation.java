package domain;

import java.time.LocalDateTime;

public class Operation {
    private final LocalDateTime date;
    private final OperationType operationType;
    private final Amount amount;
    private final Balance balance;

    public Operation(LocalDateTime date, OperationType operationType, Amount amount, Balance balance) {
        this.date = date;
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Amount getAmount() {
        return amount;
    }

    public Balance getBalance() {
        return balance;
    }
}
