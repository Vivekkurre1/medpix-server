package com.medicalstore.medicalstore.cmd.shop.domain.hibernate;

import java.util.List;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AddressData;
import com.medicalstore.medicalstore.cmd.image.domain.hibernate.ImageData;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShopData {
    @Id
    private String shopId;
    private String accountId;
    @Column(name = "shop_number", unique = true, nullable = false)
    private String shopNumber;
    private String shopName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressData address;
    private String phone;
    private String email;
    private boolean active;
    private String createdAt;
    private String updatedAt;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageData> images;
}
