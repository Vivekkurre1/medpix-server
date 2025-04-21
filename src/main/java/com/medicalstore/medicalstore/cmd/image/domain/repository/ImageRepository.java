package com.medicalstore.medicalstore.cmd.image.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.image.domain.hibernate.ImageData;

@Component
public interface ImageRepository extends JpaRepository<ImageData, String> {

    List<ImageData> findByShop_ShopId(String shopId);

}
