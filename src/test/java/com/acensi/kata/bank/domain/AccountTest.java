package com.acensi.kata.bank.domain;

import com.acensi.kata.bank.exception.AmountNotAvailable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    private Account account;

    @Before
    public void initialise() {
        account = new Account();
    }

    @Test
    public void shouldCreateAccountWithInitialValue() {
        // then
        assertThat(account.getBalance().getAmount()).isZero();
        assertThat(account.getStatement().getTransactions().size()).isZero();
    }

    @Test
    public void shouldAddDepositInAccount() {
        // given
        float moneyToDeposit = 1000f;

        // when
        Money money = account.deposit(new Money(moneyToDeposit));

        // then
        assertThat(money.getAmount()).isEqualTo(moneyToDeposit);
        List<Transaction> transactions = account.getStatement().getTransactions();
        assertThat(transactions.size()).isEqualTo(1);
        assertThat(transactions.get(0).getBalance().getAmount()).isEqualTo(1000f);
        assertThat(transactions.get(0).getAmountOperation().getAmount()).isEqualTo(1000f);
        assertThat(transactions.get(0).getOperation()).isEqualTo(Operation.DEPOSIT);
    }

    @Test
    public void shouldReturnSumOfDepositOperation() {
        // given
        account.setBalance(new Money(5000f));
        float moneyToDeposit = 1000f;

        // when
        account.deposit(new Money(moneyToDeposit));
        account.deposit(new Money(moneyToDeposit));
        account.deposit(new Money(moneyToDeposit));

        // then
        assertThat(account.getBalance().getAmount()).isEqualTo(8000f);
    }

    @Test
    public void shouldSubtractsAmountWhenWithdrawalOperation() {
        // given
        account.setBalance(new Money(5000f));
        float moneyToWithdrawal = 1000f;

        // when
        Money money = account.withdrawal(new Money(moneyToWithdrawal));

        // then
        List<Transaction> transactions = account.getStatement().getTransactions();
        assertThat(money.getAmount()).isEqualTo(4000f);
        assertThat(transactions.size()).isEqualTo(1);
        assertThat(transactions.get(0).getBalance().getAmount()).isEqualTo(4000f);
        assertThat(transactions.get(0).getAmountOperation().getAmount()).isEqualTo(1000f);
        assertThat(transactions.get(0).getOperation()).isEqualTo(Operation.WITHDRAWAL);
    }

    @Test
    public void shouldSubtractAmountFromAccount() {
        // given
        account.setBalance(new Money(5000f));
        float moneyToWithdrawal = 1000f;

        // when
        account.withdrawal(new Money(moneyToWithdrawal));
        account.withdrawal(new Money(moneyToWithdrawal));
        account.withdrawal(new Money(moneyToWithdrawal));

        // then
        assertThat(account.getBalance().getAmount()).isEqualTo(2000f);
    }

    @Test
    public void shouldWithdrawTheEntireAmountInAccount() {
        // given
        account.setBalance(new Money(5000f));
        float moneyToWithdrawal = 5000f;

        // when
        Money money = account.withdrawal(new Money(moneyToWithdrawal));

        // then
        assertThat(money.getAmount()).isEqualTo(0f);
    }

    @Test(expected = AmountNotAvailable.class)
    public void shouldThrowExceptionWhenAmountToWithdrawalNotAvailable() {
        // given
        account.setBalance(new Money(4000f));
        float moneyToWithdrawal = 5000f;

        // when
        account.withdrawal(new Money(moneyToWithdrawal));
    }

}
