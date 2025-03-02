package com.medicalstore.medicalstore.cmd.account.models.dmain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.account.models.dmain.hibernate.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
