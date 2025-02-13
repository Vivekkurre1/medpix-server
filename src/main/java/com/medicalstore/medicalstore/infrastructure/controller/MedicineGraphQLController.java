package com.medicalstore.medicalstore.infrastructure.controller;

import com.medicalstore.medicalstore.domain.hibernate.MedicineCategory;
import com.medicalstore.medicalstore.dto.MedicineDTO;
import com.medicalstore.medicalstore.dto.MedicineInputDTO;
import com.medicalstore.medicalstore.mediator.MedicineMediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MedicineGraphQLController {

    @Autowired
    private MedicineMediator medicineMediator;

    @QueryMapping
    public List<MedicineDTO> getAllMedicines() {
        return medicineMediator.getAllMedicines();
    }

    @QueryMapping
    public MedicineDTO getMedicineById(@Argument String id) {
        return medicineMediator.getMedicineById(id);
    }

    @MutationMapping
    public MedicineDTO createMedicine(@Argument String id,
            @Argument String name,
            @Argument MedicineCategory category,
            @Argument String description,
            @Argument Boolean status) {
        MedicineInputDTO medicineInputDto = new MedicineInputDTO();
        medicineInputDto.setId(id);
        medicineInputDto.setName(name);
        medicineInputDto.setCategoryId(category.getId());
        medicineInputDto.setDescription(description);
        medicineInputDto.setStatus(status);
        return medicineMediator.createMedicine(medicineInputDto);
    }
}