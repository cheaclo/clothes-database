package com.cheaclo.clothesdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductDetails {
    @NotNull
    @Size(min=2, max=30)
    private String title;

    @NotNull
    private Double price;

    @NotNull
    private Double regularPrice;

    @NotNull
    private String productUrl;

    @NotNull
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
