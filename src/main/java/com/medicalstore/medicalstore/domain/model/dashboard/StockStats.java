package com.medicalstore.medicalstore.domain.model.dashboard;

public class StockStats {
    private int total;

    public StockStats(int total) {
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