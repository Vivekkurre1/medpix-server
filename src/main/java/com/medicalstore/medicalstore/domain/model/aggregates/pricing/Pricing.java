package com.medicalstore.medicalstore.domain.model.aggregates.pricing;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pricing {
    @Id
    private String medicineId;
    // private Money price;
    // private Discount discount;
    private double tax;
    // private Money total;

    // Getters and Setters

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    // public Money getPrice() {
    // return price;
    // }

    // public void setPrice(Money price) {
    // this.price = price;
    // }

    // public Discount getDiscount() {
    // return discount;
    // }

    // public void setDiscount(Discount discount) {
    // this.discount = discount;
    // }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    // public Money getTotal() {
    // return total;
    // }

    // public void setTotal(Money total) {
    // this.total = total;
    // }

    public Pricing(String medicineId, double tax) {
        this.medicineId = medicineId;
        // this.price = price;
        // this.discount = discount;
        this.tax = tax;
        // this.total = total;
    }

    public Pricing() {
    }
}
