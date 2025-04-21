package com.medicalstore.medicalstore.cmd.shop.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;

public interface ShopRepository extends JpaRepository<ShopData, String> {

    List<ShopData> findByAccountId(String accountId);

    // @Query("SELECT s.shopNumber FROM ShopData s ORDER BY s.shopNumber DESC
    // LIMIT1")
    // String findLatestShopNumber();

    @Query("SELECT s.shopNumber FROM ShopData s ORDER BY s.shopNumber DESC")
    List<String> findTopShopNumber(Pageable pageable);
    // is findLatestShopNumber() is not working

    // @Query("SELECT s.shopNumber FROM ShopData s ORDER BY s.shopNumber DESC")
    // List<String> findAllShopNumbersDesc(PageRequest pageable);

}
