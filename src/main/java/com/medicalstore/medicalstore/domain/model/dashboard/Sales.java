package com.medicalstore.medicalstore.domain.model.dashboard;

public class Sales {
    private int count;
    private Money amount;

    public Sales(int count, Money amount) {
        this.count = count;
        this.amount = amount;
    }

    // Getters and setters

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

}