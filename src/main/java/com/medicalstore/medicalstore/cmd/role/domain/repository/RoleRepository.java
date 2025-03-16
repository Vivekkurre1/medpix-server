package com.medicalstore.medicalstore.cmd.role.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;

public interface RoleRepository extends JpaRepository<RoleData, String> {

}
