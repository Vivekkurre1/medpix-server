package com.medicalstore.medicalstore.cmd.image.infrastracture;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.medicalstore.medicalstore.codegen.types.AddShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.Image;
import com.medicalstore.medicalstore.codegen.types.ImageInput;

@Controller
public class ImageController {

    @QueryMapping
    public List<Image> images(@Argument String shopId) {
        List<Image> images = null;
        return images;
    }

    @MutationMapping
    public AddShopImagesResponse addShopImages(@Argument String shopId, @Argument List<ImageInput> images) {
        AddShopImagesResponse shop = new AddShopImagesResponse();
        return shop;
    }

    @MutationMapping
    public DeleteShopImagesResponse deleteShopImages(@Argument String shopId, @Argument List<String> imageIds) {
        DeleteShopImagesResponse shop = new DeleteShopImagesResponse();
        return shop;
    }

}
