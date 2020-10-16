package com.acensi.kata.bank.domain;

public enum Operation {
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal");

    private String operationType;

    private Operation(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return this.operationType;
    }
}
