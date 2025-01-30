package com.medicalstore.medicalstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.domain.model.aggregates.medicine.Medicine;
import com.medicalstore.medicalstore.domain.model.aggregates.medicine_categories.MedicineCategory;
import com.medicalstore.medicalstore.repository.MedicineCategoryRepository;
import com.medicalstore.medicalstore.repository.MedpixRepository;

@Service
public class MedicialstoreService {

    @Autowired
    private MedpixRepository medpixRepository;

    public List<Medicine> getAllMedicines() {
        return medpixRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(String id) {
        return medpixRepository.findById(id);
    }

    @Autowired
    private MedicineCategoryRepository medicineCategoryRepository; // Inject MedicineCategory repository

    public Medicine createMedicine(Medicine medicine) {
        if (medicine.getCategory() != null) {
            String categoryId = medicine.getCategory().getId();
            Optional<MedicineCategory> categoryOptional = medicineCategoryRepository.findById(categoryId);

            if (categoryOptional.isEmpty()) {
                throw new RuntimeException("MedicineCategory with id " + categoryId + " does not exist.");
            }

            medicine.setCategory(categoryOptional.get()); // Set the fetched category
        }

        return medpixRepository.save(medicine);
    }

    public Medicine updateMedicine(String id, Medicine medicine) {
        Optional<Medicine> existingMedicine = medpixRepository.findById(id);
        if (existingMedicine.isPresent()) {
            Medicine updatedMedicine = existingMedicine.get();
            updatedMedicine.setName(medicine.getName());
            updatedMedicine.setDescription(medicine.getDescription());
            // updatedMedicine.setPricing(medicine.getPricing());
            // updatedMedicine.setInventory(medicine.getInventory());
            updatedMedicine.setStatus(medicine.getStatus());
            return medpixRepository.save(updatedMedicine);
        }
        return null;
    }

    public void deleteMedicine(String id) {
        medpixRepository.deleteById(id);
    }

}