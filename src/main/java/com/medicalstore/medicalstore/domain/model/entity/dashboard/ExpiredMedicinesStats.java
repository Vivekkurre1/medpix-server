package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import com.medicalstore.medicalstore.domain.model.entity.common.Money;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ExpiredMedicinesStats {
    @Id
    private String id;
    private int total;
    @ManyToOne
    private Money totalAmount;

    public int getTotal() {
        return total;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }
}
