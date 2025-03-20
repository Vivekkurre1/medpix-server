package com.medicalstore.medicalstore.cmd.account.handler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AccountData;
import com.medicalstore.medicalstore.cmd.account.service.AccountService;
import com.medicalstore.medicalstore.cmd.account.service.AddressService;
import com.medicalstore.medicalstore.cmd.role.domain.hibernate.RoleData;
import com.medicalstore.medicalstore.cmd.role.service.RoleService;
import com.medicalstore.medicalstore.codegen.types.Account;
import com.medicalstore.medicalstore.codegen.types.AccountInput;
import com.medicalstore.medicalstore.codegen.types.AddressInput;
import com.medicalstore.medicalstore.codegen.types.CreateAccountResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteAccountResponse;
import com.medicalstore.medicalstore.codegen.types.LogInResponse;
import com.medicalstore.medicalstore.codegen.types.Message;
import com.medicalstore.medicalstore.codegen.types.UpdateAccountResponse;

@Component
public class AccountHandler {

    @Autowired
    private AccountConvertors converter;

    @Autowired
    private AddressConvertors addressConvertors;

    @Autowired
    private AccountService service;

    @Autowired
    private AddressService addressService;

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
        Message message = new Message();

        try {
            if (accountInput == null) {
                message.setMessage("Account input is null");
                message.setIsIssue(true);
                response.setMessage(message);
                return response;
            }

            // Generate UUID for accountId
            String accountId = UUID.randomUUID().toString();

            // Fetch role
            RoleData roleData = roleService.getRoleByName("Admin");
            if (roleData == null) {
                message.setMessage("Role 'Admin' not found");
                message.setIsIssue(true);
                response.setMessage(message);
                return response;
            }

            // Create account
            AccountData accountData = new AccountData();

            // Address
            if (accountInput.getAddress() != null && accountInput.getAddress().getAddressId() == null) {

                AddressInput address = accountInput.getAddress();
                String addressId = UUID.randomUUID().toString();
                address.setAddressId(addressId);
                addressService.createAddress(addressConvertors.toAddressData(address));
                // add addressId in accountInput of AddressInput of addressId
                accountInput.getAddress().setAddressId(addressId);

            }
            accountData = converter.toAccountData(accountId, accountInput, roleData);

            accountData = service.createAccount(accountData);
            if (accountData != null) {
                message.setMessage("Account created successfully");
                message.setIsIssue(false);
                response.setMessage(message);
            } else {
                message.setMessage("Account not created");
                message.setIsIssue(true);
                response.setMessage(message);
            }
        } catch (Exception e) {
            message.setMessage("An error occurred while creating the account: " + e.getMessage());
            message.setIsIssue(true);
            response.setMessage(message);
        }

        return response;
    }

    public UpdateAccountResponse updateAccount(String accountId, AccountInput accountInput) {
        return new UpdateAccountResponse();
    }

    public DeleteAccountResponse deleteAccount(String accountId) {
        return new DeleteAccountResponse();
    }

    public LogInResponse logIn(String email, String password) {
        return new LogInResponse();
    }

}
