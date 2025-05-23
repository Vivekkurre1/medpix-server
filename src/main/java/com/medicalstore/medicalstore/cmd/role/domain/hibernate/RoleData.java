package com.medicalstore.medicalstore.cmd.role.domain.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RoleData {
    @Id
    private String id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
