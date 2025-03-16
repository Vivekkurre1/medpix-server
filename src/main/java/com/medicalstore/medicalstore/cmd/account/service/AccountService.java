package com.medicalstore.medicalstore.cmd.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AccountData;
import com.medicalstore.medicalstore.cmd.account.dmain.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountData getAccount(String accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public AccountData createAccount(AccountData account) {
        return accountRepository.save(account);
    }

    public AccountData updateAccount(AccountData account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }

}
