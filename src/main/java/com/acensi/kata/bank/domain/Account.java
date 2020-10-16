package com.acensi.kata.bank.domain;

import com.acensi.kata.bank.exception.AmountNotAvailable;

import java.time.LocalDate;

public class Account {

    private Money balance;
    private Statement statement;

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Account() {
        this.balance = new Money(0);
        this.statement = new Statement();
    }

    public Money deposit(Money moneyToDeposit) {
        balance = balance.plus(moneyToDeposit);
        statement.addTransaction(new Transaction(Operation.DEPOSIT, LocalDate.now(), moneyToDeposit, balance));
        return balance;
    }

    public Money withdrawal(Money moneyToWithdrawal) {
        if (moneyToWithdrawal.isGreaterThan(balance)) {
            throw new AmountNotAvailable();
        }
        balance = balance.minus(moneyToWithdrawal);
        statement.addTransaction(new Transaction(Operation.WITHDRAWAL, LocalDate.now(), moneyToWithdrawal, balance));
        return balance;
    }

    public void checkOperationHistory() {
        statement.displayHistory();
    }
}
