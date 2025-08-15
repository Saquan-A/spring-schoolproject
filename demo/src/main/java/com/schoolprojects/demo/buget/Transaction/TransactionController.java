package com.schoolprojects.demo.buget.Transaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping("/transactions")
    public String getTransactions() {
        return "List of transactions";
    }

    @GetMapping("/transactions/{id}")
    public String getTransactionById() {
        return "Transaction details for ID";
    }

    @PostMapping("/transaction")
    public String createTransaction() {
        return "Transaction created";
    }

    @PutMapping("/transaction/{id}")
    public String updateTransaction() {
        return "Transaction updated";
    }

    @DeleteMapping("/transaction/{id}")
    public String deleteTransaction() {
        return "Transaction deleted";
    }
}
