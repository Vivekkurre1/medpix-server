package com.medicalstore.medicalstore.domain.model.dashboard;

public class ReportStats {
    private int total;

    public ReportStats(int total) {
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