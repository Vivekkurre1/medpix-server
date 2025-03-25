package com.medicalstore.medicalstore.domain.model.dashboard;

public class ExpiringStats {
    private int total;
    private String soon;
    private Money soonAmount;

    public ExpiringStats(int total, String soon, Money soonAmount) {
        this.total = total;
        this.soon = soon;
        this.soonAmount = soonAmount;
    }

    // Getters and setters

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSoon() {
        return soon;
    }

    public void setSoon(String soon) {
        this.soon = soon;
    }

    public Money getSoonAmount() {
        return soonAmount;
    }

    public void setSoonAmount(Money soonAmount) {
        this.soonAmount = soonAmount;
    }

}