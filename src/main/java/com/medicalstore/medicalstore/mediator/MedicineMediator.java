package com.medicalstore.medicalstore.mediator;

import com.medicalstore.medicalstore.dto.MedicineDTO;
import com.medicalstore.medicalstore.dto.MedicineInputDTO;
import com.medicalstore.medicalstore.mapper.MedicineMapper;
import com.medicalstore.medicalstore.services.MedicialstoreService;
import com.medicalstore.medicalstore.validator.RequestValidator;
import com.medicalstore.medicalstore.domain.hibernate.Medicine;
import com.medicalstore.medicalstore.domain.hibernate.MedicineCategory;
import com.medicalstore.medicalstore.domain.repository.MedicineCategoryRepository;
// import com.medicalstore.medicalstore.domain.repository.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicineMediator {

    @Autowired
    private RequestValidator validator;

    @Autowired
    private MedicineMapper mapper;

    @Autowired
    private MedicialstoreService service;

    // @Autowired
    // private MedicineRepository medicineRepository;

    @Autowired
    private MedicineCategoryRepository categoryRepository;

    public List<MedicineDTO> getAllMedicines() {
        List<Medicine> medicines = service.getAllMedicines();
        return medicines.stream().map(medicine -> mapper.medicineEntityToDto(medicine, medicine.getCategory()))
                .collect(Collectors.toList());
    }

    public MedicineDTO getMedicineById(String id) {
        Medicine medicine = service.getMedicineById(id).orElseThrow(() -> new RuntimeException("Medicine not found"));
        return mapper.medicineEntityToDto(medicine, medicine.getCategory());
    }

    public MedicineDTO createMedicine(MedicineInputDTO medicineInputDto) {

        // validate the request
        validator.validateMedicineRequest(medicineInputDto);

        // get the category by category id from the request
        MedicineCategory category = categoryRepository.findById(medicineInputDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        //
        Medicine medicine = mapper.medicineDtoToEntity(medicineInputDto, mapper.categoryEntityToDto(category));

        // save the medicine and return the saved medicine
        Medicine savedMedicine = service.createMedicine(medicine);

        // return the saved medicine
        return mapper.medicineEntityToDto(savedMedicine, savedMedicine.getCategory());
    }
}
