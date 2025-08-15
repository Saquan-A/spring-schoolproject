package com.schoolprojects.demo.buget.Transaction;

import java.util.Date;

public class TransactionDTO {
    private String category;
    private Date date;
    private Double amount;
    private String description;

    public TransactionDTO(String category, Date date, Double amount, String description) {
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.description = description;
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

}
