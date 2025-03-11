package com.medicalstore.medicalstore.cmd.role.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.role.service.RoleService;
import com.medicalstore.medicalstore.codegen.types.Message;
import com.medicalstore.medicalstore.codegen.types.Role;
import com.medicalstore.medicalstore.codegen.types.RoleInput;

@Component
public class RoleHandler {

    @Autowired
    private RoleService service;

    public List<Role> roles() {
        // List<Role> roles = service.getAllRoles();
        return List.of();
    }

    public Message createRole(RoleInput roleInput) {
        // return service.createRole(role);
        String message = "Role created successfully";
        boolean isIssue = false;

        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setIsIssue(isIssue);

        return messageObj;
    }

    public Message updateRole(String roleId, RoleInput roleInput) {
        // return service.updateRole(role);
        String message = "Role updated successfully";
        boolean isIssue = false;

        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setIsIssue(isIssue);

        return messageObj;
    }

    public Message deleteRole(String roleId) {
        // service.deleteRole(roleId);
        String message = "Role deleted successfully";
        boolean isIssue = false;

        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setIsIssue(isIssue);

        return messageObj;
    }
}
