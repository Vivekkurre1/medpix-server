package com.medicalstore.medicalstore.mapper;

import com.medicalstore.medicalstore.domain.hibernate.Medicine;
import com.medicalstore.medicalstore.domain.hibernate.MedicineCategory;
import com.medicalstore.medicalstore.dto.MedicineCategoryDTO;
import com.medicalstore.medicalstore.dto.MedicineDTO;
import com.medicalstore.medicalstore.dto.MedicineInputDTO;

import org.springframework.stereotype.Component;

@Component
public class MedicineMapper {

    // category dtoToEntity
    public MedicineCategory categoryDtoToEntity(MedicineCategoryDTO categoryDTO) {

        MedicineCategory medicineCategory = new MedicineCategory();
        medicineCategory.setId(categoryDTO.getId());
        medicineCategory.setName(categoryDTO.getName());
        medicineCategory.setDescription(categoryDTO.getDescription());
        return medicineCategory;
    }

    // category entityToDto
    public MedicineCategoryDTO categoryEntityToDto(MedicineCategory category) {

        MedicineCategoryDTO medicineCategoryDTO = new MedicineCategoryDTO();
        medicineCategoryDTO.setId(category.getId());
        medicineCategoryDTO.setName(category.getName());
        medicineCategoryDTO.setDescription(category.getDescription());
        return medicineCategoryDTO;
    }

    // medicine dtoToEntity
    public Medicine medicineDtoToEntity(MedicineInputDTO medicineDTO, MedicineCategoryDTO category) {

        MedicineCategory medicineCategory = categoryDtoToEntity(category);

        Medicine medicine = new Medicine();
        medicine.setId(medicineDTO.getId());
        medicine.setName(medicineDTO.getName());
        medicine.setCategory(medicineCategory);
        medicine.setDescription(medicineDTO.getDescription());
        medicine.setStatus(medicineDTO.getStatus());
        return medicine;
    }

    // medicine entityToDto
    public MedicineDTO medicineEntityToDto(Medicine medicine, MedicineCategory category) {

        MedicineCategoryDTO medicineCategoryDTO = categoryEntityToDto(category);

        MedicineDTO medicineDTO = new MedicineDTO();
        medicineDTO.setId(medicine.getId());
        medicineDTO.setName(medicine.getName());
        medicineDTO.setCategory(medicineCategoryDTO);
        medicineDTO.setDescription(medicine.getDescription());
        medicineDTO.setStatus(medicine.getStatus());
        return medicineDTO;
    }
}