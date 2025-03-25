package com.medicalstore.medicalstore.validator;

import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.dto.medicine.MedicineInputDTO;

@Component
public class RequestValidator {

    public void validateMedicineRequest(MedicineInputDTO medicineInputDto) {
        if (medicineInputDto.getId() == null || medicineInputDto.getId().isEmpty()) {
            throw new IllegalArgumentException("Medicine ID is missing");
        }
        if (medicineInputDto.getName() == null || medicineInputDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Medicine name is missing");
        }
        if (medicineInputDto.getCategoryId() == null || medicineInputDto.getCategoryId().isEmpty()) {
            throw new IllegalArgumentException("Category ID is missing");
        }
    }
}