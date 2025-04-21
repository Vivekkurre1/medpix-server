package com.medicalstore.medicalstore.cmd.shop.handler;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;
import com.medicalstore.medicalstore.cmd.shop.service.ShopService;
import com.medicalstore.medicalstore.codegen.types.CreateShopResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteShopResponse;
import com.medicalstore.medicalstore.codegen.types.Message;
import com.medicalstore.medicalstore.codegen.types.Shop;
import com.medicalstore.medicalstore.codegen.types.ShopInput;
import com.medicalstore.medicalstore.codegen.types.ShopUpdateInput;
import com.medicalstore.medicalstore.codegen.types.UpdateShopResponse;

@Component
public class ShopHandler {

    @Autowired
    private ShopService service;

    @Autowired
    private ShopConvertors convertors;

    public Shop getSingleShop(String shopId) {
        ShopData shop = service.getSingleShop(shopId);
        return convertors.toShop(shop);
    }

    public List<Shop> getAllShops(String accountId) {
        return service.getAllShops(accountId)
                .stream()
                .map(convertors::toShop)
                .collect(Collectors.toList());
    }

    public CreateShopResponse createShop(ShopInput shop) {
        CreateShopResponse response = new CreateShopResponse();
        Message message = new Message();
        try {
            String shopId = UUID.randomUUID().toString();
            ShopData shop1 = convertors.toShopData(shopId, shop);
            ShopData shop2 = service.createShop(shop1);
            if (shop2 != null) {
                response.setShop(convertors.toShop(shop2));
                message.setMessage("Shop created successfully");
                message.setIsIssue(false);
            } else {
                message.setMessage("Shop creation failed");
                message.setIsIssue(true);
            }
        } catch (Exception e) {
            message.setMessage("Exception occurred while creating shop. Please contact administrator");
            message.setIsIssue(true);
        }
        response.setMessage(message);
        return response;

    }

    public UpdateShopResponse updateShop(ShopUpdateInput shop) {
        UpdateShopResponse response = new UpdateShopResponse();
        Message message = new Message();
        try {
            ShopData shop1 = convertors.toShopData(shop);
            ShopData shop2 = service.updateShop(shop1);
            if (shop2 != null) {
                response.setShop(convertors.toShop(shop2));
                message.setMessage("Shop updated successfully");
                message.setIsIssue(false);
            } else {
                message.setMessage("Shop update failed");
                message.setIsIssue(true);
            }
        } catch (Exception e) {
            message.setMessage("Exception occurred while updating shop. Please contact administrator");
            message.setIsIssue(true);
        }
        response.setMessage(message);
        return response;
    }

    public DeleteShopResponse deleteShop(String shopId) {
        DeleteShopResponse response = new DeleteShopResponse();
        Message message = new Message();
        try {
            service.deleteShop(shopId);
            message.setMessage("Shop deleted successfully");
            message.setIsIssue(false);
        } catch (Exception e) {
            message.setMessage("Exception occurred while deleting shop. Please contact administrator");
            message.setIsIssue(true);
        }
        response.setMessage(message);
        return response;
    }

}
