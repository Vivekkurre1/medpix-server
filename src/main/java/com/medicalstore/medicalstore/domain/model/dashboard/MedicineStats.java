package com.medicalstore.medicalstore.domain.model.dashboard;

public class MedicineStats {
    private int total;
    private int available;

    public MedicineStats(int total, int available) {
        this.total = total;
        this.available = available;
    }

    // Getters and setters

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }
}