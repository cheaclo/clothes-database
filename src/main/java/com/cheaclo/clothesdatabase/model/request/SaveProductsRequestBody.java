package com.cheaclo.clothesdatabase.model.request;

import com.cheaclo.clothesdatabase.model.Shop;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SaveProductsRequestBody {
    @NotNull
    private String senderName;

    @NotNull
    private String authenticationCode;

    @NotNull
    private Shop shop;

    @NotNull
    List<ProductRequestBody> products;
}
