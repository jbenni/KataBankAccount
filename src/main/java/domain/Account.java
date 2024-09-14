package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {

    private Balance balance;
    private final OperationHistory operationHistory;

    public Account(OperationHistory operationHistory) {
        this.balance = new Balance(BigDecimal.ZERO);
        this.operationHistory = operationHistory;
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.add(amount);
        this.operationHistory.add(OperationType.DEPOSIT, amount, this.balance);
    }

    public void withdraw(Amount amount) {
        this.balance = this.balance.substract(amount);
        this.operationHistory.add(OperationType.WITHDRAWAL, amount, this.balance);
    }

    public Balance getBalance() {
        return this.balance;
    }

    public OperationHistory getOperationHistory() {
        return operationHistory;
    }
}
