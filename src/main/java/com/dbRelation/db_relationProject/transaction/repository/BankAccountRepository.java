package com.dbRelation.db_relationProject.transaction.repository;

import com.dbRelation.db_relationProject.transaction.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
