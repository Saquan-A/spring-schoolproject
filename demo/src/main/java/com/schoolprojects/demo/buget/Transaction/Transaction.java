package com.schoolprojects.demo.buget.Transaction;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Transaction {
    
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String category;
    private Date date;
    private Double amount;
    private String description;

    Transaction() {

    }

    public Transaction(String category, Date date, Double amount, String description) {
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(category, that.category) && Objects.equals(date, that.date) && Objects.equals(amount, that.amount) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, date, amount, description);
    }
}
