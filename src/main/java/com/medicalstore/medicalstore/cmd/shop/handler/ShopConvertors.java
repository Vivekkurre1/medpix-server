package com.medicalstore.medicalstore.cmd.shop.handler;

import java.time.ZoneOffset;
import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;
import com.medicalstore.medicalstore.codegen.types.Shop;

public class ShopConvertors {

    public Shop toShop(ShopData shop) {
        Shop shop1 = new Shop();
        shop1.setShopId(shop.getShopId());
        shop1.setAccountId(shop.getAccountId());
        shop1.setShopNumber(shop.getShopNumber());
        shop1.setName(shop.getShopName());
        shop1.setDescription(shop.getDescription());
        shop1.setPhone(shop.getPhone());
        shop1.setEmail(shop.getEmail());
        shop1.setIsActive(shop.isActive());
        shop1.setCreatedAt(shop.getCreatedAt().atOffset(ZoneOffset.UTC));
        shop1.setUpdatedAt(shop.getUpdatedAt().atOffset(ZoneOffset.UTC));
        return shop1;
    }

}
