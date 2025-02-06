package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import com.medicalstore.medicalstore.domain.model.entity.common.Money;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Sales {
    @Id
    private String id;
    private int count;

    @ManyToOne
    private Money amount;

    public int getCount() {
        return count;
    }

    public Money getAmount() {
        return amount;
    }
}
