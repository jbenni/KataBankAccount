package domain;

import java.math.BigDecimal;

public class Account {

    private Balance balance;

    public Account() {
        this.balance = new Balance(BigDecimal.ZERO);
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.add(amount);
    }

    public Balance getBalance() {
        return this.balance;
    }

    public void withdraw(Amount withdrawAmount) {
    }
}
