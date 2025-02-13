package com.medicalstore.medicalstore.domain.model.dashboard;

public class DashboardResponse {
    private Dashboard dashboard;

    public DashboardResponse(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}