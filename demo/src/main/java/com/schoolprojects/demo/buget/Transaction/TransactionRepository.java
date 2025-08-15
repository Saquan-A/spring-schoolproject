package com.schoolprojects.demo.buget.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Date;

interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Example of a derived query: find all transactions for a specific category
    List<Transaction> findByCategory(String category);
    // Example of a more complex derived query
    List<Transaction> findByAmountGreaterThanAndDateAfter(Double amount, Date date);
}
