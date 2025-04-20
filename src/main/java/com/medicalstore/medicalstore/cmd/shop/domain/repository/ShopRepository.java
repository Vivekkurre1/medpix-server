package com.medicalstore.medicalstore.cmd.shop.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;

public interface ShopRepository extends JpaRepository<ShopData, String> {

    List<ShopData> findByAccountId(String accountId);

}
