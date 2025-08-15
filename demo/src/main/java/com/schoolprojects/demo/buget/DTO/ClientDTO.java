package com.schoolprojects.demo.buget.DTO;

public class ClientDTO {
    private String firstName;
    private String lastName;
    private ContactDTO contact;
    private BudgetDTO budget;
    private TrackerDTO tracker;

    public ClientDTO(String firstName, String lastName, ContactDTO contact, BudgetDTO budget, TrackerDTO tracker) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.budget = budget;
        this.tracker = tracker;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public ContactDTO getContact() {
        return contact;
    }
    public BudgetDTO getBudget() {
        return budget;
    }
    public TrackerDTO getTracker() {
        return tracker;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
