package com.schoolprojects.demo.buget.DTO;

import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TransactionDTO {
    private Long id;
    @NotBlank(message = "Category cannot be blank")
    @Size(min = 2, max = 50, message = "Category must be between 2 and 50 characters")
    private String category;
    @NotNull(message = "Date cannot be null")
    @PastOrPresent(message = "Transaction date cannot be in the future")
    private Date date;
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private Double amount;
    private String description;

    public TransactionDTO(Long id, String category, Date date, Double amount, String description) {
        this.id = id;
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
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

}
