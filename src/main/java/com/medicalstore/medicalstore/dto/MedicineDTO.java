package com.medicalstore.medicalstore.dto;

public class MedicineDTO {
    private String id;
    private String name;
    private MedicineCategoryDTO category;
    private String description;
    private Boolean status;

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

    public MedicineCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(MedicineCategoryDTO category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}