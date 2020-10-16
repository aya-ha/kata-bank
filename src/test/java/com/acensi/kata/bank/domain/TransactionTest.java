package com.acensi.kata.bank.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {


    @Test
    public void shouldFormatTransactionToString() {
        //given
        Transaction transaction = createTransaction(Operation.DEPOSIT, LocalDate.of(2020, 2, 6), new Money(100f), new Money(200f));

        //when
        String result = transaction.formatTransaction();

        //then
        assertThat(result).isEqualTo("DEPOSIT|2020-02-06|100.0|200.0");
    }

    public Transaction createTransaction(Operation operation, LocalDate date, Money amountOperation, Money balance) {
        return new Transaction(operation, date, amountOperation, balance);
    }
}
