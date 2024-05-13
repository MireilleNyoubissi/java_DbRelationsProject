package com.dbRelation.db_relationProject.transaction.controller;

import com.dbRelation.db_relationProject.transaction.entities.BankAccount;
import com.dbRelation.db_relationProject.transaction.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.createBankAccount(bankAccount);
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount) {
        bankAccountService.transferMoneyV2(fromAccountId, toAccountId, amount);
    }
}
