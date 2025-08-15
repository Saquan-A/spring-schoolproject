package com.schoolprojects.demo.buget.Transaction;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
class Transaction {
    
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String role;

    Transaction() {

    }

    Transaction(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

}

