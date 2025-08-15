package com.schoolprojects.demo.buget.DTO;
import java.util.ArrayList;

public class TrackerDTO {
    private ArrayList<TransactionDTO> transactions;
    private double balance;
    private BudgetDTO budget;

    public TrackerDTO(ArrayList<TransactionDTO> transactions, double balance, BudgetDTO budget) {
        this.transactions = transactions;
        this.balance = balance;
        this.budget = budget;
    }
    public ArrayList<TransactionDTO> getTransactions() {
        return transactions;
    }
    public double getBalance() {
        return balance;
    }
    public BudgetDTO getBudget() {
        return budget;
    }
    public void setTransactions(ArrayList<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setBudget(BudgetDTO budget) {
        this.budget = budget;
    }

}
