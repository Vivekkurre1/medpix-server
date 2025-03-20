package com.medicalstore.medicalstore.cmd.account.dmain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AddressData;

public interface AddressRepository extends JpaRepository<AddressData, String> {

}
