package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SalesStats {
    @Id
    private String id;
    @ManyToOne
    private Sales total;
    @ManyToOne
    private Sales today;
    @ManyToOne
    private Sales week;
    @ManyToOne
    private Sales month;

    public Sales getTotal() {
        return total;
    }

    public Sales getToday() {
        return today;
    }

    public Sales getWeek() {
        return week;
    }

    public Sales getMonth() {
        return month;
    }
}