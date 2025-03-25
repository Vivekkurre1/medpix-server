package com.medicalstore.medicalstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.domain.hibernate.Medicine;
import com.medicalstore.medicalstore.domain.repository.MedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicialstoreService {
    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(String id) {
        return medicineRepository.findById(id);
    }

    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }
}