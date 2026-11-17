package com.moneyManager.app.services;

import com.moneyManager.app.services.MoneyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
public class MoneyServiceTests {
    @Autowired
    private MoneyService moneyService;

    private Collection<BigDecimal> transactions;

    @BeforeEach
    private void setUpData() {
        transactions = new ArrayList<BigDecimal>();
        transactions.add(new BigDecimal(100));
        transactions.add(new BigDecimal(92));
        transactions.add(new BigDecimal(-20));
        transactions.add(new BigDecimal(-12.2));
    }

    @Test
    @DisplayName("Must calculate correctly the sum of all values")
    void mustAddToBalanceCorrectly()
    {
        moneyService.clearTransactions();

        BigDecimal expectedBalance = new BigDecimal(100.5 + 20);

        assertEquals(expectedBalance, moneyService.getBalance());
    }

    @Test
    @DisplayName("Must return the sum of all values considering negative values.")
    void calculateBalanceWithNegativeValues() {
        moneyService.clearTransactions();

        List<BigDecimal> values = new ArrayList<>();
        values.add(new BigDecimal(100));
        values.add(new BigDecimal(-10));
        values.add(new BigDecimal(-20));

//        for (var value : values)
//        {
//            moneyService.addTransaction(value);
//        }

        BigDecimal expectedBalance = new BigDecimal(100 - 10 - 20);

        assertEquals(expectedBalance, moneyService.getBalance());
    }
}
