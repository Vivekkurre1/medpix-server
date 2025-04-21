package com.medicalstore.medicalstore.cmd.image.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.image.domain.hibernate.ImageData;
import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;
import com.medicalstore.medicalstore.codegen.types.Image;
import com.medicalstore.medicalstore.codegen.types.ImageInput;

@Component
public class ImageConvertors {

    public Image toImage(ImageData images) {
        Image image = new Image();
        image.setId(images.getImageId());
        image.setUrl(images.getImageUrl());
        image.setIsPrimary(images.isImageIsPrimary());
        image.setLabel(images.getLabel());
        return image;

    }

    public List<Image> toImages(List<ImageData> images) {
        return images.stream().map(this::toImage).toList();
    }

    public ImageData toImageData(String shopId, ImageInput imageInput) {
        ImageData imageData = new ImageData();
        imageData.setImageId(imageInput.getId());
        imageData.setImageUrl(imageInput.getUrl());
        imageData.setImageIsPrimary(imageInput.getIsPrimary());
        imageData.setLabel(imageInput.getLabel());
        // link with shop by shopId
        // imageData.setShopId(shopId);
        ShopData shopData = new ShopData();
        shopData.setShopId(shopId);
        imageData.setShop(shopData);
        return imageData;
    }

    public List<ImageData> toImageData(String shopId, List<ImageInput> imageInputs) {
        return imageInputs.stream().map(image -> toImageData(shopId, image)).toList();
    }

}
