package com.medicalstore.medicalstore.cmd.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;
import com.medicalstore.medicalstore.cmd.shop.domain.repository.ShopRepository;

import jakarta.transaction.Transactional;

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

    // public ShopData createShop(ShopData shop) {
    // return shopRepository.save(shop);
    // }

    @Transactional
    public ShopData createShop(ShopData shop) {
        // String latestShopNumber = shopRepository.findLatestShopNumber();
        // inside createShop
        List<String> topShopNumbers = shopRepository.findTopShopNumber(PageRequest.of(0, 1));
        String latestShopNumber = topShopNumbers.isEmpty() ? null : topShopNumbers.get(0);
        String nextShopNumber = generateNextShopNumber(latestShopNumber);
        shop.setShopNumber(nextShopNumber);

        return shopRepository.save(shop);
    }

    public ShopData updateShop(ShopData shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(String shopId) {
        shopRepository.deleteById(shopId);
    }

    // helper methods
    private String generateNextShopNumber(String latest) {
        int nextNumber = 1;
        if (latest != null && latest.startsWith("MADPIX-")) {
            String numberPart = latest.substring("MADPIX-".length());
            try {
                nextNumber = Integer.parseInt(numberPart) + 1;
            } catch (NumberFormatException ignored) {
            }
        }
        return String.format("MADPIX-%04d", nextNumber);
    }

}
