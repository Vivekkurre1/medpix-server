package com.medicalstore.medicalstore.cmd.address.model.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.address.model.domain.hibernate.AddressData;

public interface AddressRepository extends JpaRepository<AddressData, String> {

}
