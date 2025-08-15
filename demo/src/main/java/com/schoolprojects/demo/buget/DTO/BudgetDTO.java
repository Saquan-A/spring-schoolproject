package com.schoolprojects.demo.buget.DTO;

import java.util.ArrayList;

public class BudgetDTO {
    private ArrayList<BudgetCategoryDTO> categories;
    private double totalAllocated;
    private double totalIncome;
    private double allocationBalance;

    public BudgetDTO(ArrayList<BudgetCategoryDTO> categories, double totalAllocated, double totalIncome, double allocationBalance) {
        this.categories = categories;
        this.totalAllocated = totalAllocated;
        this.totalIncome = totalIncome;
        this.allocationBalance = allocationBalance;
    }
    public ArrayList<BudgetCategoryDTO> getCategories() {
        return categories;
    }   
    public double getTotalAllocated() {
        return totalAllocated;
    }
    public double getTotalIncome() {
        return totalIncome;
    }
    public double getAllocationBalance() {
        return allocationBalance;
    }
    public void setCategories(ArrayList<BudgetCategoryDTO> categories) {
        this.categories = categories;
    }
    public void setTotalAllocated(double totalAllocated) {
        this.totalAllocated = totalAllocated;
    }
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }
    public void setAllocationBalance(double allocationBalance) {
        this.allocationBalance = allocationBalance;
    }
}
