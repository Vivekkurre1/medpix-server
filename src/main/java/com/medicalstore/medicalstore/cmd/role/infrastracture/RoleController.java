package com.medicalstore.medicalstore.cmd.role.infrastracture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.medicalstore.medicalstore.cmd.role.handler.RoleHandler;
import com.medicalstore.medicalstore.codegen.types.CreateRoleResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteRoleResponse;
import com.medicalstore.medicalstore.codegen.types.Message;
import com.medicalstore.medicalstore.codegen.types.Role;
import com.medicalstore.medicalstore.codegen.types.RoleInput;
import com.medicalstore.medicalstore.codegen.types.UpdateRoleResponse;

@Controller
public class RoleController {

    @Autowired
    private RoleHandler roleHandler;

    @QueryMapping
    public List<Role> roles() {
        List<Role> roles = roleHandler.roles();
        return roles;
    }

    @MutationMapping
    public CreateRoleResponse createRole(@Argument RoleInput roleInput) {
        if (roleInput == null) {
            throw new IllegalArgumentException("RoleInput is required and cannot be null.");
        }

        Message message = roleHandler.createRole(roleInput);

        CreateRoleResponse createRoleResponse = new CreateRoleResponse();
        createRoleResponse.setMessage(message);
        return createRoleResponse;
    }

    @MutationMapping
    public UpdateRoleResponse updateRole(@Argument String roleId, @Argument RoleInput roleInput) {

        Message message = roleHandler.updateRole(roleId, roleInput);

        UpdateRoleResponse updateRoleResponse = new UpdateRoleResponse();
        updateRoleResponse.setMessage(message);
        return updateRoleResponse;
    }

    @MutationMapping
    public DeleteRoleResponse deleteRole(@Argument String roleId) {

        Message message = roleHandler.deleteRole(roleId);

        DeleteRoleResponse deleteRoleResponse = new DeleteRoleResponse();
        deleteRoleResponse.setMessage(message);
        return deleteRoleResponse;
    }
}
