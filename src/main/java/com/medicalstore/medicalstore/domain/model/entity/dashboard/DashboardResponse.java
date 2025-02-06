package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import jakarta.persistence.ManyToOne;

public class DashboardResponse {
    @ManyToOne
    private Dashboard dashboard;

    public DashboardResponse(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
}
