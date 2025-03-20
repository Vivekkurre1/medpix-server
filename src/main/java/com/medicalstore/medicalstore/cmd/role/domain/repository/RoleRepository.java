package com.medicalstore.medicalstore.cmd.role.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;

public interface RoleRepository extends JpaRepository<RoleData, String> {

    Optional<RoleData> findByName(String name);

}
