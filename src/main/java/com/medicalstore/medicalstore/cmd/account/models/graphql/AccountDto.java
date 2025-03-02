package com.medicalstore.medicalstore.cmd.account.models.graphql;

import com.medicalstore.medicalstore.cmd.address.model.graphql.AddressDto;
import com.medicalstore.medicalstore.cmd.role.model.graphql.RoleDto;

public class AccountDto {
    String id;
    String name;
    String email;
    String password;
    String phone;
    Boolean status;
    AddressDto address;
    RoleDto role;
}
