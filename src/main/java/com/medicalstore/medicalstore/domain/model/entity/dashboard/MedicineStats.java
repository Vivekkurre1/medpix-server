package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import com.medicalstore.medicalstore.domain.model.entity.common.Money;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicineStats {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Money total;
    private int available;

    public Money getTotal() {
        return total;
    }

    public int getAvailable() {
        return available;
    }
}
