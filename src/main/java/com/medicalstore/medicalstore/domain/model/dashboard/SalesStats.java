package com.medicalstore.medicalstore.domain.model.dashboard;

public class SalesStats {
    private Sales total;
    private Sales today;
    private Sales week;
    private Sales month;

    public SalesStats(Sales total, Sales today, Sales week, Sales month) {
        this.total = total;
        this.today = today;
        this.week = week;
        this.month = month;
    }

    // Getters and setters

    public Sales getTotal() {
        return total;
    }

    public void setTotal(Sales total) {
        this.total = total;
    }

    public Sales getToday() {
        return today;
    }

    public void setToday(Sales today) {
        this.today = today;
    }

    public Sales getWeek() {
        return week;
    }

    public void setWeek(Sales week) {
        this.week = week;
    }

    public Sales getMonth() {
        return month;
    }

    public void setMonth(Sales month) {
        this.month = month;
    }

}