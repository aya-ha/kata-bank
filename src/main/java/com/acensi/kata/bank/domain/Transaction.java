package com.acensi.kata.bank.domain;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private Operation operation;
    private Money amountOperation;
    private Money balance;

    public Transaction(Operation operation, LocalDate date, Money amountOperation, Money balance) {
        this.date = date;
        this.operation = operation;
        this.amountOperation = amountOperation;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Money getAmountOperation() {
        return amountOperation;
    }

    public void setAmountOperation(Money amountOperation) {
        this.amountOperation = amountOperation;
    }

    public String formatTransaction() {
        return operation + "|" + date + "|" + amountOperation.getAmount() + "|" + balance.getAmount();
    }
}
