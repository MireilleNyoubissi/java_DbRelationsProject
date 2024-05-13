package com.dbRelation.db_relationProject.transaction.services;

import com.dbRelation.db_relationProject.transaction.entities.BankAccount;
import com.dbRelation.db_relationProject.transaction.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {

        BankAccount fromAccount = bankAccountRepository.findById(fromAccountId).orElseThrow(()-> new RuntimeException("From account not found"));
        BankAccount toAccount = bankAccountRepository.findById(toAccountId).orElseThrow(()-> new RuntimeException("To account not found"));

        if(fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        bankAccountRepository.save(fromAccount);
        bankAccountRepository.save(toAccount);
    }

    public void transferMoneyV2(Long fromAccountId, Long toAccountId, double amount) {

        BankAccount fromAccount = bankAccountRepository.findById(fromAccountId).orElseThrow(()-> new RuntimeException("From account not found"));
        BankAccount toAccount = bankAccountRepository.findById(toAccountId).orElseThrow(()-> new RuntimeException("To account not found"));

        if(fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        bankAccountRepository.save(fromAccount);

        if(fromAccount.getBalance() < 1000) {
            throw new RuntimeException("Balance too low");
        }

        bankAccountRepository.save(toAccount);
    }

}
