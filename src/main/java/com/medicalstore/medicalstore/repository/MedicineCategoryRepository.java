package com.medicalstore.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.domain.model.aggregates.medicine_categories.MedicineCategory;

public interface MedicineCategoryRepository extends JpaRepository<MedicineCategory, String> {

}