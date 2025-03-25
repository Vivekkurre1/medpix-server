package com.medicalstore.medicalstore.domain.model.dashboard;

public class CustomerStats {
    private int total;

    public CustomerStats(int total) {
        this.total = total;
    }

    // Getters and setters

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}