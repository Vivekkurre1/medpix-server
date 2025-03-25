package com.medicalstore.medicalstore.cmd.role.handler;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;
import com.medicalstore.medicalstore.cmd.role.service.RoleService;
import com.medicalstore.medicalstore.codegen.types.Message;
import com.medicalstore.medicalstore.codegen.types.Role;
import com.medicalstore.medicalstore.codegen.types.RoleInput;

@Component
public class RoleHandler {

    @Autowired
    private RoleConvertors converter;

    @Autowired
    private RoleService service;

    public List<Role> roles() {
        List<RoleData> rolesData = service.getAllRoles();
        List<Role> roles = rolesData.stream().map(role -> converter.toRole(role)).toList();
        return roles;
    }

    public Message createRole(RoleInput roleInput) {

        // generate uuid for roleId
        String roleId = UUID.randomUUID().toString();

        RoleData roleData = converter.toNewRoleData(roleId, roleInput);
        service.createRole(roleData);

        String message = "Role created successfully";
        boolean isIssue = false;

        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setIsIssue(isIssue);

        return messageObj;
    }

    public Message updateRole(String roleId, RoleInput roleInput) {

        RoleData roleData = converter.toNewRoleData(roleId, roleInput);
        service.updateRole(roleData);

        String message = "Role updated successfully";
        boolean isIssue = false;

        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setIsIssue(isIssue);

        return messageObj;
    }

    public Message deleteRole(String roleId) {

        service.deleteRole(roleId);

        String message = "Role deleted successfully";
        boolean isIssue = false;

        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setIsIssue(isIssue);

        return messageObj;
    }

    // public RoleData getRole(String name) {
    // RoleData roleData = service.getRoleByName(name);
    // return roleData;
    // }
}
