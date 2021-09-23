package com.cheaclo.clothesdatabase.model.request;

import com.cheaclo.clothesdatabase.model.ProductType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProductRequestBody {
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

    @NotNull
    private List<String> categories;

    @NotNull
    private ProductType type;
}
