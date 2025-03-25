package com.medicalstore.medicalstore.cmd.account.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.medicalstore.medicalstore.cmd.account.handler.AccountHandler;
import com.medicalstore.medicalstore.codegen.types.*;

@Controller
public class AccountController {

    @Autowired
    private AccountHandler accountHandler;

    @QueryMapping
    public Account account(@Argument String id) {
        Account account = accountHandler.account(id);
        return account;

    }

    @MutationMapping
    public CreateAccountResponse createAccount(@Argument AccountInput accountInput) {
        CreateAccountResponse createAccountResponse = accountHandler.createAccount(accountInput);
        return createAccountResponse;
    }

    @MutationMapping
    public UpdateAccountResponse updateAccount(@Argument String accountId, @Argument AccountInput accountInput) {
        UpdateAccountResponse updateAccountResponse = accountHandler.updateAccount(accountId, accountInput);
        return updateAccountResponse;
    }

    @MutationMapping
    public DeleteAccountResponse deleteAccount(@Argument String accountId) {
        DeleteAccountResponse deleteAccountResponse = accountHandler.deleteAccount(accountId);
        return deleteAccountResponse;
    }

    @MutationMapping
    public LogInResponse logIn(@Argument String email, @Argument String password) {
        LogInResponse logInResponse = accountHandler.logIn(email, password);
        return logInResponse;
    }

}
