package com.medicalstore.medicalstore.cmd.image.infrastracture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.medicalstore.medicalstore.cmd.image.handler.ImageHandler;
import com.medicalstore.medicalstore.codegen.types.AddShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.Image;
import com.medicalstore.medicalstore.codegen.types.ImageInput;

@Controller
public class ImageController {

    @Autowired
    private ImageHandler handler;

    @QueryMapping
    public List<Image> shopImages(@Argument String shopId) {
        List<Image> images = handler.getShopImages(shopId);
        return images;
    }

    @MutationMapping
    public AddShopImagesResponse addShopImages(@Argument String shopId, @Argument List<ImageInput> images) {
        AddShopImagesResponse shop = handler.addShopImages(shopId, images);

        return shop;
    }

    @MutationMapping
    public DeleteShopImagesResponse deleteShopImages(@Argument String shopId, @Argument List<String> imageIds) {
        DeleteShopImagesResponse shop = handler.deleteShopImages(shopId, imageIds);
        return shop;
    }

}
