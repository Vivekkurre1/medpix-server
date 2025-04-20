package com.medicalstore.medicalstore.cmd.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;
import com.medicalstore.medicalstore.cmd.shop.domain.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public ShopData getSingleShop(String shopId) {
        return shopRepository.findById(shopId).orElse(null);
    }

    public List<ShopData> getAllShops(String accountId) {
        return shopRepository.findByAccountId(accountId);
    }

    public ShopData createShop(ShopData shop) {
        return shopRepository.save(shop);
    }

    public ShopData updateShop(ShopData shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(String shopId) {
        shopRepository.deleteById(shopId);
    }
}
