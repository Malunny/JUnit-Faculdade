package com.moneyManager.app.services;

import com.moneyManager.app.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MoneyService {
    private final Collection<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void addTransaction(BigDecimal amount, String user) {
        var transaction = new Transaction(amount, user);
        transactions.add(transaction);
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public void clearTransactions() {
        this.transactions.clear();
    }
    public BigDecimal getBalance() {
        BigDecimal balance = new BigDecimal(0);

        for (var transaction : transactions) {
            balance = balance.add(transaction.getAmount());
        }

        return balance;
    }
}
