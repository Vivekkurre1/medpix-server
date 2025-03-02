package com.medicalstore.medicalstore.cmd.account.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.medicalstore.medicalstore.cmd.account.handler.AccountHandler;

@Controller
public class AccountController {
    @Autowired
    private AccountHandler accountHandler;

    @QueryMapping
    public String getAccount(@Argument String id) {
        return "Account";
    }

    @MutationMapping
    public String createAccount() {
        return "Account created";
    }

    @MutationMapping
    public String updateAccount() {
        return "Account updated";
    }

    @MutationMapping
    public String deleteAccount() {
        return "Account deleted";
    }

}
