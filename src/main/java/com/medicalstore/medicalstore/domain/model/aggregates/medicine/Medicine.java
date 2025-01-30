package com.medicalstore.medicalstore.domain.model.aggregates.medicine;

import com.medicalstore.medicalstore.domain.model.aggregates.medicine_categories.MedicineCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicine {
    @Id
    private String id;
    private String name;
    // add this field private MedicineCategory category;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Creates a foreign key column
    private MedicineCategory category;
    private String description;
    // private Image image;
    // private DateTime expiryDate;
    // private Inventory inventory;
    // private Pricing pricing;
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

    public Medicine(String id, String name, MedicineCategory category, String description,
            Boolean status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        // this.inventory = inventory;
        // this.pricing = pricing;
        this.status = status;
    }

    public Medicine() {
    }

}
