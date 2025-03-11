package com.medicalstore.medicalstore.cmd.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.role.model.domain.hibernate.Role;
import com.medicalstore.medicalstore.cmd.role.model.domain.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }

}
