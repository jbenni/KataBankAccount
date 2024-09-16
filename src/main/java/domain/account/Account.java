package domain.account;

import domain.Amount;
import domain.Balance;
import domain.exception.WithdrawNotAllowedException;
import domain.operation.OperationHistory;
import domain.operation.OperationType;
import domain.statement.StatementPrinter;

import java.math.BigDecimal;

public class Account {

    private Balance balance;
    private final OperationHistory operationHistory;
    private final StatementPrinter statementPrinter;

    public Account(OperationHistory operationHistory, StatementPrinter statementPrinter) {
        this.balance = new Balance(BigDecimal.ZERO);
        this.operationHistory = operationHistory;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.add(amount);
        this.operationHistory.add(OperationType.DEPOSIT, amount, this.balance);
    }

    public void withdraw(Amount amount) {
        if(!isWithdrawAllowed(amount)) {
            throw new WithdrawNotAllowedException("Withdraw amount must be less than account balance.");
        }

        this.balance = this.balance.substract(amount);
        this.operationHistory.add(OperationType.WITHDRAWAL, amount, this.balance);
    }

    public Balance getBalance() {
        return this.balance;
    }

    public OperationHistory getOperationHistory() {
        return operationHistory;
    }

    public String print() {
        return statementPrinter.print(operationHistory.getOperations());
    }

    private boolean isWithdrawAllowed(Amount amount) {
        return balance.getValue().compareTo(amount.getValue()) >= 0;
    }
}
