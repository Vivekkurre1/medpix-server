package com.medicalstore.medicalstore.domain.model.dashboard;

public class ExpiredMedicinesStats {
    private int total;
    private Money totalAmount;

    public ExpiredMedicinesStats(int total, Money totalAmount) {
        this.total = total;
        this.totalAmount = totalAmount;
    }

    // Getters and setters

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Money totalAmount) {
        this.totalAmount = totalAmount;
    }
}