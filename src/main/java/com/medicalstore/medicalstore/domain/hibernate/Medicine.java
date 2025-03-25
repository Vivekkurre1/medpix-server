package com.medicalstore.medicalstore.domain.hibernate;

import jakarta.persistence.*;

@Entity
public class Medicine {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private MedicineCategory category;
    private String description;
    private Boolean status;

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicineCategory getCategory() {
        return category;
    }

    public void setCategory(MedicineCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // public Inventory getInventory() {
    // return inventory;
    // }

    // public void setInventory(Inventory inventory) {
    // this.inventory = inventory;
    // }

    // public Pricing getPricing() {
    // return pricing;
    // }

    // public void setPricing(Pricing pricing) {
    // this.pricing = pricing;
    // }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}