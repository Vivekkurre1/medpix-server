package com.medicalstore.medicalstore.cmd.role.handler;

import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;
import com.medicalstore.medicalstore.codegen.types.Role;
import com.medicalstore.medicalstore.codegen.types.RoleInput;

@Component
public class RoleConvertors {
    public Role toRole(RoleData role) {
        Role role1 = new Role();
        role1.setId(role.getId());
        role1.setName(role.getName());
        role1.setDescription(role.getDescription());
        return role1;
    }

    public RoleData toNewRoleData(String roleId, RoleInput roleInput) {
        RoleData role = new RoleData();
        role.setId(roleId);
        role.setName(roleInput.getName());
        role.setDescription(roleInput.getDescription());
        return role;
    }

}
