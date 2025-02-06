package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReportStats {
    @Id
    private String id;
    private int total;

    public int getTotal() {
        return total;
    }
}