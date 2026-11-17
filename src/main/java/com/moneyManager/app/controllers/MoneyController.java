package com.moneyManager.app.controllers;

import com.moneyManager.app.controllers.requests.AddMoneyRequest;
import com.moneyManager.app.models.Transaction;
import com.moneyManager.app.services.MoneyService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/money")
public class MoneyController {
    private final MoneyService moneyService;
    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    @PostMapping(path = "/add/")
    public void addTransaction(@RequestBody AddMoneyRequest addMoneyRequest) {
        moneyService.addTransaction(addMoneyRequest.getAmount(), addMoneyRequest.getUser());
    }

    @GetMapping(path = "/")
    public Collection<Transaction> getTransactions() {
        return moneyService.getTransactions();
    }
}
