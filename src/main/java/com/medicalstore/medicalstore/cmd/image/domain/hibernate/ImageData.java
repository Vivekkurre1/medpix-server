package com.medicalstore.medicalstore.cmd.image.domain.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private boolean isPrimary;
    private String label;

}
