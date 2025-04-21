package com.medicalstore.medicalstore.cmd.image.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.cmd.image.domain.hibernate.ImageData;
import com.medicalstore.medicalstore.cmd.image.domain.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageData addImage(ImageData image) {
        return imageRepository.save(image);
    }

    public void deleteImage(String imageId) {
        imageRepository.deleteById(imageId);
    }

    public void deleteImages(List<String> imageIds) {
        imageRepository.deleteAllById(imageIds);
    }

    public List<ImageData> getImages(String shopId) {
        return imageRepository.findByShop_ShopId(shopId);
    }

    public ImageData getImage(String imageId) {
        return imageRepository.findById(imageId).orElse(null);
    }

}
