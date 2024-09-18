package com.simplifiedtransaction.repositories;

import com.simplifiedtransaction.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
