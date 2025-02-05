package com.medicalstore.medicalstore.domain.model.entity.medicine_categories;

import jakarta.persistence.*;
// import java.util.UUID;

@Entity
public class MedicineCategory {
    @Id
    // @GeneratedValue(strategy = GenerationType.UUID) // Use UUID for ID generation
    private String id;
    private String name;
    private String description;

    // Getters and Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
