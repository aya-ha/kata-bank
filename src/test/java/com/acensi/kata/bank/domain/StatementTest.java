package com.acensi.kata.bank.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    private Statement statement;

    @Before
    public void initialise() {
        statement = new Statement();
    }

    @Test
    public void shouldInsertStatementObjectInStatementList() {
        // given
        Transaction transaction = createTransaction(Operation.DEPOSIT, LocalDate.of(2020, 2, 6), new Money(700f), new Money(1000f));

        // when
        statement.addTransaction(transaction);

        // then
        assertThat(statement.getTransactions().size()).isEqualTo(1);
    }

    @Test
    public void shouldPopulateStatementWithTransactions() {
        // given
        Transaction transaction = createTransaction(Operation.DEPOSIT, LocalDate.of(2020, 2, 6), new Money(700f), new Money(1000f));

        // when
        statement.addTransaction(transaction);
        statement.addTransaction(transaction);
        statement.addTransaction(transaction);

        // then
        assertThat(statement.getTransactions().size()).isEqualTo(3);
    }

    @Test
    public void shouldDisplayOperationHistory() {
        // given
        Transaction transaction = createTransaction(Operation.DEPOSIT, LocalDate.of(2020, 2, 6), new Money(700f), new Money(1000f));
        statement.addTransaction(transaction);
        String newLine = System.getProperty("line.separator");

        // when

        String result = statement.displayHistory();

        // then
        assertThat(result).isEqualTo("OPERATION   | DATE       | AMOUNT  | BALANCE" + newLine +
                "DEPOSIT|2020-02-06|700.0|1000.0");
    }

    @Test
    public void shouldDisplayOnlyHeaderWhenNoOperationFound() {
        // when
        String result = statement.displayHistory();

        // then
        assertThat(result).isEqualTo("OPERATION   | DATE       | AMOUNT  | BALANCE");
    }

    public Transaction createTransaction(Operation operation, LocalDate date, Money amountOperation, Money balance) {
        return new Transaction(operation, date, amountOperation, balance);
    }

}
