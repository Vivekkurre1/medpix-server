package com.medicalstore.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.medicalstore.medicalstore.domain.model.aggregates.medicine.Medicine;
import com.medicalstore.medicalstore.services.MedicialstoreService;

@RestController
@RequestMapping("/medpix")
public class MedicineController {

    @Autowired
    private MedicialstoreService medicialstoreService;

    // Fetch all medicines
    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines() {
        return medicialstoreService.getAllMedicines();
    }

    // Fetch a medicine by its ID
    @GetMapping("/medicines/{id}")
    public Medicine getMedicineById(@PathVariable String id) {
        return medicialstoreService.getMedicineById(id).orElse(null);
    }

    // Create a new medicine
    @PostMapping("/medicines")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicialstoreService.createMedicine(medicine);
    }

    // Update an existing medicine
    @PutMapping("/medicines/{id}")
    public Medicine updateMedicine(@PathVariable String id, @RequestBody Medicine medicine) {
        return medicialstoreService.updateMedicine(id, medicine);
    }

    // Delete a medicine by its ID
    @DeleteMapping("/medicines/{id}")
    public void deleteMedicine(@PathVariable String id) {
        medicialstoreService.deleteMedicine(id);
    }

}
