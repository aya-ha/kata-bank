package com.acensi.kata.bank.exception;

public class AmountNotAvailable extends RuntimeException {
    public AmountNotAvailable() {
        super("Amount requested not available");
    }
}
