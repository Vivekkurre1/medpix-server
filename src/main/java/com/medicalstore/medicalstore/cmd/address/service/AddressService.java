package com.medicalstore.medicalstore.cmd.address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.address.model.domain.hibernate.AddressData;
import com.medicalstore.medicalstore.cmd.address.model.domain.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<AddressData> getAllAddresses() {
        return addressRepository.findAll();
    }

    public AddressData createAddress(AddressData address) {
        return addressRepository.save(address);
    }

    public AddressData getAddressById(String id) {
        return addressRepository.findById(id).orElse(null);
    }
}
