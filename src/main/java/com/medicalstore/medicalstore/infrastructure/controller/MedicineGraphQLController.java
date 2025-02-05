
// MedicineGraphQLController.java
package com.medicalstore.medicalstore.infrastructure.controller;

import com.medicalstore.medicalstore.domain.model.entity.medicine.Medicine;
import com.medicalstore.medicalstore.services.MedicialstoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MedicineGraphQLController {

    @Autowired
    private MedicialstoreService medicineService;

    @QueryMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @QueryMapping
    public Medicine getMedicineById(@Argument String id) {
        return medicineService.getMedicineById(id).orElse(null);
    }

    @MutationMapping
    public Medicine createMedicine(@Argument String id,
            @Argument String name,
            @Argument String categoryId,
            @Argument String description,
            @Argument Boolean status) {
        return medicineService.createMedicine(id, name, categoryId, description, status);
    }
}
