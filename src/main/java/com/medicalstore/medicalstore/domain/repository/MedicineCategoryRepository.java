package com.medicalstore.medicalstore.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.domain.hibernate.MedicineCategory;

public interface MedicineCategoryRepository extends JpaRepository<MedicineCategory, String> {
}
