package domain;

import java.math.BigDecimal;

public class Account {

    private Balance balance;
    private final OperationHistory operationHistory;

    public Account(OperationHistory operationHistory) {
        this.balance = new Balance(BigDecimal.ZERO);
        this.operationHistory = operationHistory;
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(Amount amount) {
        this.balance = this.balance.substract(amount);
    }

    public Balance getBalance() {
        return this.balance;
    }

    public OperationHistory getOperationHistory() {
        return operationHistory;
    }
}
