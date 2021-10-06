package com.cheaclo.clothesdatabase.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_seq",
            sequenceName = "product_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_seq"
    )
    private Long id;

    @Embedded
    @NonNull
    private ProductDetails details;

    @ManyToMany(fetch = FetchType.EAGER)
    @NonNull
    private Set<ProductCategory> categories;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @NonNull
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    @NonNull
    private ProductType type;

    @NonNull
    private Date lastUpdate;

    private Integer hash;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return details.equals(product.details) && categories.equals(product.categories) && shop.equals(product.shop) && type.equals(product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details, shop, type);
    }
}
