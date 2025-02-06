package com.medicalstore.medicalstore.domain.model.entity.dashboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dashboard {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "medicinestats_id")
    private MedicineStats medicinestats;
    @ManyToOne
    @JoinColumn(name = "salesstats_id")
    private SalesStats salesstats;
    @ManyToOne
    @JoinColumn(name = "stockstats_id")
    private StockStats stockstats;
    @ManyToOne
    @JoinColumn(name = "expiringstats_id")
    private ExpiringStats expiringstats;
    @ManyToOne
    @JoinColumn(name = "expired_medicines_stats_id")
    private ExpiredMedicinesStats expiredMedicinesStats;
    @ManyToOne
    @JoinColumn(name = "customerstats_id")
    private CustomerStats customerstats;
    @ManyToOne
    @JoinColumn(name = "reportstats_id")
    private ReportStats reportstats;

    public String getId() {
        return id;
    }

    public MedicineStats getMedicinestats() {
        return medicinestats;
    }

    public SalesStats getSalesstats() {
        return salesstats;
    }

    public StockStats getStockstats() {
        return stockstats;
    }

    public ExpiringStats getExpiringstats() {
        return expiringstats;
    }

    public ExpiredMedicinesStats getExpiredMedicinesStats() {
        return expiredMedicinesStats;
    }

    public CustomerStats getCustomerstats() {
        return customerstats;
    }

    public ReportStats getReportstats() {
        return reportstats;
    }

}
