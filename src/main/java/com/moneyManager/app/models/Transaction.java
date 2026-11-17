package com.moneyManager.app.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private BigDecimal amount;
    private LocalDate occurredAt;
    private String doneBy;

    public String getDoneBy() {
        return doneBy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getOccurredAt() {
        return occurredAt;
    }

    public Transaction(BigDecimal amount, String doneBy) {
        this.doneBy = doneBy;
        this.amount = amount;
        this.occurredAt = LocalDate.now();
    }
}
