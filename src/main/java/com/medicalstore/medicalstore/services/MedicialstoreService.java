
// MedicineService.java
package com.medicalstore.medicalstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.domain.model.entity.medicine.Medicine;
import com.medicalstore.medicalstore.domain.model.entity.medicine_categories.MedicineCategory;
import com.medicalstore.medicalstore.domain.repository.MedicineCategoryRepository;
import com.medicalstore.medicalstore.domain.repository.MedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicialstoreService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private MedicineCategoryRepository categoryRepository;

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(String id) {
        return medicineRepository.findById(id);
    }

    public Medicine createMedicine(String id, String name, String categoryId, String description, Boolean status) {
        MedicineCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Medicine medicine = new Medicine();
        medicine.setId(id);
        medicine.setName(name);
        medicine.setCategory(category);
        medicine.setDescription(description);
        medicine.setStatus(status);
        return medicineRepository.save(medicine);
    }
}