package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import com.medicalstore.medicalstore.domain.model.entity.common.Money;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExpiringStats {
    @Id
    private String id;
    private int total;
    // private LocalDateTime soon;
    @ManyToOne
    private Money soonAmount;

    public int getTotal() {
        return total;
    }

    // public LocalDateTime getSoon() {
    // return soon;
    // }

    public Money getSoonAmount() {
        return soonAmount;
    }
}
