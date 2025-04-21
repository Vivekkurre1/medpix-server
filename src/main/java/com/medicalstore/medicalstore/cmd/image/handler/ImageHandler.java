package com.medicalstore.medicalstore.cmd.image.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.image.domain.hibernate.ImageData;
import com.medicalstore.medicalstore.cmd.image.service.ImageService;
import com.medicalstore.medicalstore.codegen.types.AddShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.DeleteShopImagesResponse;
import com.medicalstore.medicalstore.codegen.types.Image;
import com.medicalstore.medicalstore.codegen.types.ImageInput;

@Component
public class ImageHandler {

    @Autowired
    private ImageConvertors imageConvertors;

    @Autowired
    private ImageService imageService;

    public List<Image> getShopImages(String shopId) {
        List<ImageData> images = imageService.getImages(shopId);
        return imageConvertors.toImages(images);
    }

    public AddShopImagesResponse addShopImages(String shopId, List<ImageInput> images) {
        AddShopImagesResponse shop = new AddShopImagesResponse();
        return shop;
    }

    public DeleteShopImagesResponse deleteShopImages(String shopId, List<String> imageIds) {
        DeleteShopImagesResponse shop = new DeleteShopImagesResponse();

        return shop;
    }

}
