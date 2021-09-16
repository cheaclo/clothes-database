package com.cheaclo.clothesdatabase.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProductsResponse {
    @Value("${products.response.success}")
    private String successMessage;

    public boolean success;
    public String message;

    public ProductsResponse fail(String errorMessage) {
        success = false;
        message = errorMessage;
        return this;
    }

    public ProductsResponse success() {
        success = true;
        message = successMessage;
        return this;
    }
}
