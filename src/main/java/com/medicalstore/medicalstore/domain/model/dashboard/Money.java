package com.medicalstore.medicalstore.domain.model.dashboard;

public class Money {
    private double total;
    private String currency;

    public Money(double total, String currency) {
        this.total = total;
        this.currency = currency;
    }

    // Getters and setters

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
