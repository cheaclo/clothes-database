package com.cheaclo.clothesdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductType {
    @Id
    @SequenceGenerator(
            name = "product_type_seq",
            sequenceName = "product_type_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_type_seq"
    )
    @Column(name = "product_type_id")
    private Long id;
    private String name;
}
