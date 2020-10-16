package com.acensi.kata.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    public static final String HEADER = "OPERATION   | DATE       | AMOUNT  | BALANCE";

    private List<Transaction> transactions;

    public Statement() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public String displayHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        if (transactions.isEmpty()) {
            stringBuilder.append("");
        }
        String newLine = System.getProperty("line.separator");
        for (Transaction transaction : transactions) {
            stringBuilder.append(newLine);
            stringBuilder.append(transaction.formatTransaction());
        }
        return stringBuilder.toString();
    }
}
