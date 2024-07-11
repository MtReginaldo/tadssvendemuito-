package com.mercado.model;

public class Customer {
    private int customerId;
    private String emailAddress;
    private String fullName;

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "{" +
                "\"customerId\": " + customerId + ", " +
                "\"emailAddress\": \"" + emailAddress + "\", " +
                "\"fullName\": \"" + fullName + "\"" +
                "}";
    }
}