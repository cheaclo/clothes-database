package com.cheaclo.clothesdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductDetails {
    private String title;
    private Double price;
    private Double regularPrice;
    private String productUrl;
    private String imageUrl;
}
