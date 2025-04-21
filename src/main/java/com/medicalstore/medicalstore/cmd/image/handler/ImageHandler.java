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
import com.medicalstore.medicalstore.codegen.types.Message;

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
        Message message = new Message();
        AddShopImagesResponse shop = new AddShopImagesResponse();
        try {
            if (shopId == null || images == null || images.isEmpty()) {
                message.setMessage("Invalid input");
                message.setIsIssue(true);
            } else {
                var imageData = imageConvertors.toImageData(shopId, images);
                List<ImageData> addedImage = imageService.addImages(imageData);
                if (addedImage == null || addedImage.isEmpty()) {
                    message.setMessage("Images not added");
                    message.setIsIssue(true);
                } else {
                    shop.setImages(imageConvertors.toImages(addedImage));
                    message.setMessage("Images added successfully");
                    message.setIsIssue(false);
                }
            }
        } catch (Exception e) {
            message.setMessage("Exception occurred while adding images. Please contact administrator");
            message.setIsIssue(true);
        }
        shop.setMessage(message);

        return shop;
    }

    public DeleteShopImagesResponse deleteShopImages(String shopId, List<String> imageIds) {
        Message message = new Message();
        DeleteShopImagesResponse shop = new DeleteShopImagesResponse();
        try {
            if (shopId == null || imageIds == null || imageIds.isEmpty()) {
                message.setMessage("Invalid input");
                message.setIsIssue(true);
            } else {
                imageService.deleteImages(imageIds);
                message.setMessage("Images deleted successfully");
                message.setIsIssue(false);
            }
        } catch (Exception e) {
            message.setMessage("Exception occurred while deleting images. Please contact administrator");
            message.setIsIssue(true);
        }
        shop.setMessage(message);

        return shop;
    }

}
