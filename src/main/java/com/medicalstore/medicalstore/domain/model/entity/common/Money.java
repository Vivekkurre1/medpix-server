package com.medicalstore.medicalstore.domain.model.entity.common;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Money {
    @Id
    private String id;
    private double amount;
    private String currency;

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

}
