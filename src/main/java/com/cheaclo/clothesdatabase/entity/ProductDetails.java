package com.cheaclo.clothesdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetails that = (ProductDetails) o;
        return title.equals(that.title) && price.equals(that.price) && regularPrice.equals(that.regularPrice) && productUrl.equals(that.productUrl) && imageUrl.equals(that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, regularPrice, productUrl, imageUrl);
    }
}
