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
            RoleData roleData = roleService.getRoleByName("admin");
            if (roleData == null) {
                message.setMessage("Role 'admin' not found");
                message.setIsIssue(true);
                response.setMessage(message);
                return response;
            }

            // Create account
            AccountData accountData = new AccountData();

            // Address
            if (accountInput.getAddress() != null) {
                if (accountInput.getAddress().getAddressId() == null) {
                    AddressInput address = accountInput.getAddress();
                    String addressId = UUID.randomUUID().toString();
                    address.setAddressId(addressId);
                    addressService.createAddress(addressConvertors.toAddressData(address));
                    // add addressId in accountInput of AddressInput of addressId
                    accountInput.getAddress().setAddressId(addressId);
                }

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
        UpdateAccountResponse response = new UpdateAccountResponse();
        Message message = new Message();

        try {
            if (accountInput == null) {
                message.setMessage("Account input is null");
                message.setIsIssue(true);
                response.setMessage(message);
                return response;
            }

            AccountData accountData = service.getAccount(accountId);
            if (accountData == null) {
                message.setMessage("Account not found");
                message.setIsIssue(true);
                response.setMessage(message);
                return response;
            }

            // Address
            if (accountInput.getAddress() != null && accountInput.getAddress().getAddressId() == null) {

                AddressInput address = accountInput.getAddress();
                String addressId = UUID.randomUUID().toString();
                address.setAddressId(addressId);
                addressService.createAddress(addressConvertors.toAddressData(address));
                // add addressId in accountInput of AddressInput of addressId
                accountInput.getAddress().setAddressId(addressId);

            } else {
                // Update address
                addressService.updateAddress(addressConvertors.toAddressData(accountInput.getAddress()));
            }

            accountData = converter.toAccountData(accountId, accountInput, accountData.getRoleData());
            accountData = service.updateAccount(accountData);
            if (accountData != null) {
                message.setMessage("Account updated successfully");
                message.setIsIssue(false);
                response.setMessage(message);
            } else {
                message.setMessage("Account not updated");
                message.setIsIssue(true);
                response.setMessage(message);
            }
        } catch (Exception e) {
            message.setMessage("An error occurred while updating the account: " + e.getMessage());
            message.setIsIssue(true);
            response.setMessage(message);
        }

        return response;
    }

    public DeleteAccountResponse deleteAccount(String accountId) {
        DeleteAccountResponse response = new DeleteAccountResponse();
        Message message = new Message();

        try {
            AccountData accountData = service.getAccount(accountId);
            if (accountData == null) {
                message.setMessage("Account not found");
                message.setIsIssue(true);
                response.setMessage(message);
                return response;
            }

            // Check if the account has an associated address and delete it
            if (accountData.getAddress() != null && accountData.getAddress().getAddressId() != null) {
                addressService.deleteAddress(accountData.getAddress().getAddressId());
            }

            service.deleteAccount(accountId);
            message.setMessage("Account and associated address (if any) deleted successfully");
            message.setIsIssue(false);
            response.setMessage(message);
        } catch (Exception e) {
            message.setMessage("An error occurred while deleting the account: " + e.getMessage());
            message.setIsIssue(true);
            response.setMessage(message);
        }

        return response;
    }

    public LogInResponse logIn(String email, String password) {
        LogInResponse response = new LogInResponse();
        Message message = new Message();
        AccountData accountData = new AccountData();

        try {
            accountData = service.getAccountByEmailAndPassword(email, password);
            if (accountData != null) {
                message.setMessage("Log in successful");
                message.setIsIssue(false);
                response.setMessage(message);
                response.setAccount(converter.toAccount(accountData));

            } else {
                message.setMessage("Invalid email or password");
                message.setIsIssue(true);
                response.setMessage(message);
                return response;
            }

        } catch (Exception e) {
            message.setMessage("An error occurred while logging in: " + e.getMessage());
            message.setIsIssue(true);
            response.setMessage(message);
            return response;
        }

        return response;
    }

}
