package com.medicalstore.medicalstore.cmd.account.handler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AccountData;
import com.medicalstore.medicalstore.cmd.account.service.AccountService;
import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;
import com.medicalstore.medicalstore.cmd.role.service.RoleService;
import com.medicalstore.medicalstore.codegen.types.Account;
import com.medicalstore.medicalstore.codegen.types.AccountInput;
import com.medicalstore.medicalstore.codegen.types.AddressInput;
import com.medicalstore.medicalstore.codegen.types.CreateAccountResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteAccountResponse;
import com.medicalstore.medicalstore.codegen.types.LogInResponse;
import com.medicalstore.medicalstore.codegen.types.Message;
import com.medicalstore.medicalstore.codegen.types.UpdateAccountAddressResponse;
import com.medicalstore.medicalstore.codegen.types.UpdateAccountResponse;

@Component
public class AccountHandler {

    @Autowired
    private AccountConvertors converter;

    @Autowired
    private AccountService service;

    // Role service
    @Autowired
    private RoleService roleService;

    public Account account(String id) {
        Account account = new Account();
        AccountData accountData = service.getAccount(id);

        if (accountData != null) {
            account = converter.toAccount(accountData);
        }

        return account;
    }

    public CreateAccountResponse createAccount(AccountInput accountInput) {
        CreateAccountResponse response = new CreateAccountResponse();

        // generate uuid for roleId
        String accountId = UUID.randomUUID().toString();

        // role
        RoleData roleData = roleService.getRoleByName("Admin");

        AccountData accountData = service.createAccount(converter.toAccountData(accountId, accountInput, roleData));
        Message message = new Message();
        message.setMessage("Account created successfully");
        message.setIsIssue(false);
        if (accountData != null) {
            response.setMessage(message);
        } else {
            message.setMessage("Account not created");
            message.setIsIssue(true);
            response.setMessage(message);
        }

        return response;
    }

    public UpdateAccountResponse updateAccount(String accountId, AccountInput accountInput) {
        return new UpdateAccountResponse();
    }

    public UpdateAccountAddressResponse updateAccountAddress(String accountId, AddressInput addressInput) {
        return new UpdateAccountAddressResponse();
    }

    public DeleteAccountResponse deleteAccount(String accountId) {
        return new DeleteAccountResponse();
    }

    public LogInResponse logIn(String email, String password) {
        return new LogInResponse();
    }

}
