package com.medicalstore.medicalstore.cmd.address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.address.model.domain.hibernate.Address;
import com.medicalstore.medicalstore.cmd.address.model.domain.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(String id) {
        return addressRepository.findById(id).orElse(null);
    }
}
