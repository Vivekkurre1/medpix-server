package com.medicalstore.medicalstore.domain.model.dashboard;

public class Dashboard {
    private String shopId;
    private MedicineStats medicineStats;
    private SalesStats salesStats;
    private StockStats stockStats;
    private ExpiringStats expiringStats;
    private ExpiredMedicinesStats expiredMedicinesStats;
    private CustomerStats customerStats;
    private ReportStats reportStats;

    public Dashboard(String shopId, MedicineStats medicineStats, SalesStats salesStats, StockStats stockStats,
            ExpiringStats expiringStats, ExpiredMedicinesStats expiredMedicinesStats, CustomerStats customerStats,
            ReportStats reportStats) {
        this.shopId = shopId;
        this.medicineStats = medicineStats;
        this.salesStats = salesStats;
        this.stockStats = stockStats;
        this.expiringStats = expiringStats;
        this.expiredMedicinesStats = expiredMedicinesStats;
        this.customerStats = customerStats;
        this.reportStats = reportStats;
    }

    // Getters and setters for all fields

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public MedicineStats getMedicineStats() {
        return medicineStats;
    }

    public void setMedicineStats(MedicineStats medicineStats) {
        this.medicineStats = medicineStats;
    }

    public SalesStats getSalesStats() {
        return salesStats;
    }

    public void setSalesStats(SalesStats salesStats) {
        this.salesStats = salesStats;
    }

    public StockStats getStockStats() {
        return stockStats;
    }

    public void setStockStats(StockStats stockStats) {
        this.stockStats = stockStats;
    }

    public ExpiringStats getExpiringStats() {
        return expiringStats;
    }

    public void setExpiringStats(ExpiringStats expiringStats) {
        this.expiringStats = expiringStats;
    }

    public ExpiredMedicinesStats getExpiredMedicinesStats() {
        return expiredMedicinesStats;
    }

    public void setExpiredMedicinesStats(ExpiredMedicinesStats expiredMedicinesStats) {
        this.expiredMedicinesStats = expiredMedicinesStats;
    }

    public CustomerStats getCustomerStats() {
        return customerStats;
    }

    public void setCustomerStats(CustomerStats customerStats) {
        this.customerStats = customerStats;
    }

    public ReportStats getReportStats() {
        return reportStats;
    }

    public void setReportStats(ReportStats reportStats) {
        this.reportStats = reportStats;
    }

}