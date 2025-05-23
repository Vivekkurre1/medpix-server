package com.medicalstore.medicalstore.cmd.image.domain.hibernate;

import com.medicalstore.medicalstore.cmd.shop.domain.hibernate.ShopData;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ImageData {
    @Id
    private String imageId;
    private String imageUrl;
    private boolean imageIsPrimary;
    private String label;
    // @JoinColumn(name = "shop_id") // Optional: customize the column name
    @ManyToOne
    @JoinColumn(table = "image_data", name = "shop_id", referencedColumnName = "shopId")
    private ShopData shop; // ⚠️ this field name must match `mappedBy = "shop"`

}
