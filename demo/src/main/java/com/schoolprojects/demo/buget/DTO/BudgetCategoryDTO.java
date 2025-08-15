package com.schoolprojects.demo.buget.DTO;

public class BudgetCategoryDTO {
    private String catName;
    private String catDes;
    private double amount;
    private int catType; // 0 for income, 1 for expense

    public BudgetCategoryDTO(String catName, String catDes, double amount, int catType) {
        this.catName = catName;
        this.catDes = catDes;
        this.amount = amount;
        this.catType = catType;
    }

    public String getCatName() {
        return catName;
    }

    public String getCatDes() {
        return catDes;
    }

    public double getAmount() {
        return amount;
    }

    public int getCatType() {
        return catType;
    }   
}
