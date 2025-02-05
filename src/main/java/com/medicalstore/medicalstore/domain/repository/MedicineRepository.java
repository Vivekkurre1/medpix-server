package com.medicalstore.medicalstore.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.domain.model.entity.medicine.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
}