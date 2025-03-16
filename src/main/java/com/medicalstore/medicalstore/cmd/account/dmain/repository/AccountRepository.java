package com.medicalstore.medicalstore.cmd.account.dmain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AccountData;

public interface AccountRepository extends JpaRepository<AccountData, String> {

}
