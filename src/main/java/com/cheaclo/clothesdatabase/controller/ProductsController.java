package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    private ProductsResponse productsResponse;

    @PostMapping("/save")
    public ProductsResponse saveProducts(@RequestBody List<Product> products) {
        return productsResponse.success();
    }
}
