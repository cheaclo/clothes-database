package com.cheaclo.clothesdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductDetails {
    @Id
    @SequenceGenerator(
            name = "product_details_seq",
            sequenceName = "product_details_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_details_seq"
    )
    @Column(name = "product_details_id")
    private Long id;
    private String title;
    private Double price;
    private Double regularPrice;
    private String productUrl;
    private String imageUrl;
}
