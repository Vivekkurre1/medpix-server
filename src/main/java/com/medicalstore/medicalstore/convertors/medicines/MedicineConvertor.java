package com.medicalstore.medicalstore.convertors.medicines;

import com.medicalstore.medicalstore.domain.hibernate.Medicine;
import com.medicalstore.medicalstore.domain.hibernate.MedicineCategory;
import com.medicalstore.medicalstore.dto.medicine.MedicineCategoryDTO;
import com.medicalstore.medicalstore.dto.medicine.MedicineDTO;
import com.medicalstore.medicalstore.dto.medicine.MedicineInputDTO;

import org.springframework.stereotype.Component;

@Component
public class MedicineConvertor {

    private CategoryConvertor categoryConvertor;

    // medicine dtoToEntity
    public Medicine medicineDtoToEntity(MedicineInputDTO medicineDTO, MedicineCategoryDTO category) {

        MedicineCategory medicineCategory = categoryConvertor.categoryDtoToEntity(category);

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

        MedicineCategoryDTO medicineCategoryDTO = categoryConvertor.categoryEntityToDto(category);

        MedicineDTO medicineDTO = new MedicineDTO();
        medicineDTO.setId(medicine.getId());
        medicineDTO.setName(medicine.getName());
        medicineDTO.setCategory(medicineCategoryDTO);
        medicineDTO.setDescription(medicine.getDescription());
        medicineDTO.setStatus(medicine.getStatus());
        return medicineDTO;
    }
}