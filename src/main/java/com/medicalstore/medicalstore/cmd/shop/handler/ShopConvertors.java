package com.medicalstore.medicalstore.cmd.shop.handler;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;
import com.medicalstore.medicalstore.codegen.types.Phone;
import com.medicalstore.medicalstore.codegen.types.PhoneInput;
import com.medicalstore.medicalstore.codegen.types.Shop;
import com.medicalstore.medicalstore.codegen.types.ShopInput;
import com.medicalstore.medicalstore.codegen.types.ShopUpdateInput;

@Component
public class ShopConvertors {

    // graphql to domain
    public Phone toPhone(String phone) {
        Phone phone1 = new Phone();
        String[] phoneArray = phone.split("-");
        phone1.setCountryCode(phoneArray[0].substring(0, 3));
        phone1.setNumber(phoneArray[1].substring(phoneArray[1].length() - 10));
        return phone1;
    }

    // domain to graphql
    public String toPhoneString(PhoneInput phone) {
        return phone.getCountryCode() + "-" + phone.getNumber();
    }

    // domain to graphql
    public Shop toShop(ShopData shop) {
        Shop shop1 = new Shop();
        shop1.setShopId(shop.getShopId());
        shop1.setAccountId(shop.getAccountId());
        shop1.setShopNumber(shop.getShopNumber());
        shop1.setName(shop.getShopName());
        shop1.setDescription(shop.getDescription());
        shop1.setPhone(toPhone(shop.getPhone()));
        shop1.setEmail(shop.getEmail());
        shop1.setIsActive(shop.isActive());
        shop1.setCreatedAt(shop.getCreatedAt());
        shop1.setUpdatedAt(shop.getUpdatedAt());
        return shop1;
    }

    // graphql to domain add ShopInput
    public ShopData toShopData(String shopId, ShopInput shop) {
        ShopData shop1 = new ShopData();
        shop1.setShopId(shopId);
        shop1.setAccountId(shop.getAccountId());
        // shop1.setShopNumber(shopNumber);
        shop1.setShopName(shop.getName());
        shop1.setDescription(shop.getDescription());
        shop1.setPhone(toPhoneString(shop.getPhone()));
        shop1.setEmail(shop.getEmail());
        shop1.setActive(true);
        shop1.setCreatedAt(LocalDateTime.now().toString());
        shop1.setUpdatedAt(LocalDateTime.now().toString());
        return shop1;
    }

    // graphql to domain add ShopUpdateInput
    public ShopData toShopData(ShopUpdateInput shop) {
        ShopData shop1 = new ShopData();
        shop1.setShopId(shop.getShopId());
        shop1.setAccountId(shop.getAccountId());
        shop1.setShopNumber(shop.getShopNumber());
        shop1.setShopName(shop.getName());
        shop1.setDescription(shop.getDescription());
        shop1.setPhone(toPhoneString(shop.getPhone()));
        shop1.setEmail(shop.getEmail());
        shop1.setActive(true);
        shop1.setUpdatedAt(LocalDateTime.now().toString());
        return shop1;
    }

}
