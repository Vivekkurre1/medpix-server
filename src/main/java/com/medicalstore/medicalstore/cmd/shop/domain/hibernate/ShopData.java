package com.medicalstore.medicalstore.cmd.shop.domain.hibernate;

import java.time.LocalDateTime;
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
    private String shopNumber;
    private String shopName;
    private String description;
    @ManyToOne
    private AddressData address;
    private String phone;
    private String email;
    private boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ImageData> images;
}
