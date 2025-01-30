package com.medicalstore.medicalstore.domain.model.aggregates.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {
    @Id
    private String medicineId;
    private int quantity;
    private String unit;
    // private Date manufacturingDate;
    // private Date expiryDate;

    // getters and setters

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    // public Date getManufacturingDate() {
    // return manufacturingDate;
    // }

    // public void setManufacturingDate(Date manufacturingDate) {
    // this.manufacturingDate = manufacturingDate;
    // }

    // public Date getExpiryDate() {
    // return expiryDate;
    // }

    // public void setExpiryDate(Date expiryDate) {
    // this.expiryDate = expiryDate;
    // }

    public Inventory(String medicineId, int quantity, String unit) {
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.unit = unit;
        // this.manufacturingDate = manufacturingDate;
        // this.expiryDate = expiryDate;
    }

    public Inventory() {
    }
}
