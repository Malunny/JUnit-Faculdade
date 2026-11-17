package com.moneyManager.app.controllers.requests;

import java.math.BigDecimal;

public class AddMoneyRequest {
    public BigDecimal amount;
    public String user;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getUser() {
        return user;
    }

}
