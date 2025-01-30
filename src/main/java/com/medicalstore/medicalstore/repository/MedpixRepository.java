package com.medicalstore.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.domain.model.aggregates.medicine.Medicine;

public interface MedpixRepository extends JpaRepository<Medicine, String> {
    // Custom queries can be added here if needed
}
