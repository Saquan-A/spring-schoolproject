package com.schoolprojects.demo.buget.DTO;

public class ContactDTO {
    private String homeAddress;
    private String phone;
    private String email;
    
    public ContactDTO(String homeAddress, String phone, String email) {
        this.homeAddress = homeAddress;
        this.phone = phone;
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Home Address: " + homeAddress + ", Phone: " + phone + ", Email: " + email;
    }
}
