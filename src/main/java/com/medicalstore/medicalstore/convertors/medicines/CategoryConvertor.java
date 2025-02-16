package com.medicalstore.medicalstore.convertors.medicines;

import com.medicalstore.medicalstore.domain.hibernate.MedicineCategory;
import com.medicalstore.medicalstore.dto.medicine.MedicineCategoryDTO;

public class CategoryConvertor {

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

}
