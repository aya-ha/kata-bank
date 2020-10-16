package com.acensi.kata.bank.domain;

public class Money {

    private float amount;

    public Money(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Money plus(Money value) {
        return new Money(amount + value.amount);
    }


    public Money minus(Money value) {
        return new Money(amount - value.amount);
    }

    public boolean isGreaterThan(Money money) {
        return Float.compare(this.amount, money.amount) > 0;
    }
}
