package com.cheaclo.clothesdatabase.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@NoArgsConstructor
public class ProductsResponse {
    @Value("${products.response.success}")
    private String successMessage;

    @Value("${products.response.fail}")
    private String failMessage;

    public boolean success;
    public String message;

    public ProductsResponse fail() {
        success = false;
        message = failMessage;
        return this;
    }

    public ProductsResponse success() {
        success = true;
        message = successMessage;
        return this;
    }
}
