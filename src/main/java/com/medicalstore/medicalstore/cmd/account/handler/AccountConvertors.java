package com.medicalstore.medicalstore.cmd.account.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AccountData;
import com.medicalstore.medicalstore.cmd.address.handler.AddressConvertors;
import com.medicalstore.medicalstore.cmd.address.model.domain.hibernate.AddressData;
import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;
import com.medicalstore.medicalstore.cmd.role.handler.RoleConvertors;
import com.medicalstore.medicalstore.codegen.types.Account;
import com.medicalstore.medicalstore.codegen.types.AccountInput;
import com.medicalstore.medicalstore.codegen.types.Address;
import com.medicalstore.medicalstore.codegen.types.Role;

@Component
public class AccountConvertors {

    @Autowired
    private RoleConvertors roleConvertors;
    @Autowired
    private AddressConvertors addressConvertors;

    public Account toAccount(AccountData account) {
        Account account1 = new Account();
        Role role = roleConvertors.toRole(account.getRole());
        Address address = addressConvertors.toAddress(account.getAddress());
        account1.setId(account.getId());
        account1.setName(account.getName());
        account1.setEmail(account.getEmail());
        account1.setPhone(account.getPhone());
        account1.setStatus(account.getStatus());
        account1.setRole(role);
        account1.setAddress(address);
        return account1;
    }

    public AccountData toAccountData(String accountId, AccountInput accountInput, RoleData roleData) {
        AccountData account = new AccountData();
        AddressData address = new AddressData();
        account.setId(accountId);
        account.setName(accountInput.getName());
        account.setEmail(accountInput.getEmail());
        account.setPhone(accountInput.getPhone());
        account.setStatus(accountInput.getStatus());
        account.setAddress(address);
        account.setRole(roleData);
        return account;
    }
}
