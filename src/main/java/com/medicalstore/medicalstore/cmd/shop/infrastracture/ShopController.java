package com.medicalstore.medicalstore.cmd.shop.infrastracture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.medicalstore.medicalstore.cmd.shop.handler.ShopHandler;
import com.medicalstore.medicalstore.codegen.types.AddShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.CreateShopResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteShopResponse;
import com.medicalstore.medicalstore.codegen.types.Image;
import com.medicalstore.medicalstore.codegen.types.ImageInput;
import com.medicalstore.medicalstore.codegen.types.Shop;
import com.medicalstore.medicalstore.codegen.types.ShopInput;
import com.medicalstore.medicalstore.codegen.types.ShopUpdateInput;
import com.medicalstore.medicalstore.codegen.types.UpdateShopResponse;

@Controller
public class ShopController {

    @Autowired
    private ShopHandler shopHandler;

    @QueryMapping
    public Shop shop(@Argument String shopId) {
        Shop shop = shopHandler.getSingleShop(shopId);
        return shop;
    }

    @QueryMapping
    public List<Shop> shops(@Argument String accountId) {
        List<Shop> shops = shopHandler.getAllShops(accountId);
        return shops;
    }

    // Mutations

    @MutationMapping
    public CreateShopResponse createShop(@Argument ShopInput shopInput) {
        CreateShopResponse shop = shopHandler.createShop(shopInput);
        return shop;
    }

    @MutationMapping
    public UpdateShopResponse updateShop(@Argument ShopUpdateInput shopInput) {
        UpdateShopResponse shop = shopHandler.updateShop(shopInput);
        return shop;
    }

    @MutationMapping
    public DeleteShopResponse deleteShop(@Argument String shopId) {
        DeleteShopResponse shop = shopHandler.deleteShop(shopId);
        return shop;
    }
}
