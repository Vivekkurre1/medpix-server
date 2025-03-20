package com.medicalstore.medicalstore.cmd.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;
import com.medicalstore.medicalstore.cmd.role.domain.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleData> getAllRoles() {
        return roleRepository.findAll();
    }

    public String createRole(RoleData role) {
        roleRepository.save(role);
        String message = "Role created successfully";
        return message;
    }

    public RoleData getRoleById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    public String updateRole(RoleData role) {
        roleRepository.save(role);
        String message = "Role updated successfully";
        return message;
    }

    public String deleteRole(String id) {
        roleRepository.deleteById(id);
        String message = "Role deleted successfully";
        return message;
    }

    public RoleData getRoleByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

}
