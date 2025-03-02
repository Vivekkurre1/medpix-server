package com.medicalstore.medicalstore.cmd.role.model.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.role.model.domain.hibernate.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
