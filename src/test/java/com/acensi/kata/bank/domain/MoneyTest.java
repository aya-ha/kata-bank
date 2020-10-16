package com.acensi.kata.bank.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MoneyTest {

    private Money money;

    @Before
    public void initialise() {
        money = new Money(1000f);
    }

    @Test
    public void shouldAddAmountToBalance() {
        //given
        Money amountToAdd = new Money(100f);

        //when
        Money result = money.plus(amountToAdd);

        //then
        assertThat(result.getAmount()).isEqualTo(1100f);
    }

    @Test
    public void shouldSubtractAmountFromBalance() {
        //given
        Money amountToSubtract = new Money(100f);

        //when
        Money result = money.minus(amountToSubtract);

        //then
        assertThat(result.getAmount()).isEqualTo(900f);
    }

    @Test
    public void shouldReturnTrueWhenBalanceGraterThanAmountToAdd() {
        //given
        Money amountToAdd = new Money(100f);

        //when
        boolean result = money.isGreaterThan(amountToAdd);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenAmountToWithdrawalGreaterThanBalance() {
        //given
        Money amountToWithdrawal = new Money(2000f);

        //when
        boolean result = money.isGreaterThan(amountToWithdrawal);

        //then
        assertThat(result).isFalse();
    }
}
