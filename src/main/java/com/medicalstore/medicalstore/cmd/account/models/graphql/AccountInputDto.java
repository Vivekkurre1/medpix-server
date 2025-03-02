package com.medicalstore.medicalstore.cmd.account.models.graphql;

import com.medicalstore.medicalstore.cmd.address.model.graphql.AddressInputDto;

public class AccountInputDto {
    String name;
    String email;
    String password;
    String phone;
    Boolean status;
    AddressInputDto address;
}
