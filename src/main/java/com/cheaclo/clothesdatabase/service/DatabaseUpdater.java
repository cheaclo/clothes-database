package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseUpdater {
    @Autowired
    private ProductRepository productRepository;

    public void insertAndUpdateProducts(List<Product> products) {
        for (Product product : products)
            productRepository.save(product);
    }
}
