package com.medicalstore.medicalstore.domain.model.aggregates.pricing;

public class Discount {
    private double percentage;
    private Money amount;

    // Getters and Setters

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
