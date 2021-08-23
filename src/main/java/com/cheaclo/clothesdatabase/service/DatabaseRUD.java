package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DatabaseRUD {
    @Autowired
    private ProductRepository productRepository;

    public void insertAndUpdateProducts(List<Product> products) {
        for (Product product : products) {
            Product dbProduct = productRepository.findFirstByHash(product.getHash());
            if (dbProduct == null)
                insertProduct(product);
            else
                updateProduct(dbProduct, product);
        }
    }

    public void updateProduct(Product dbProduct, Product product) {
        dbProduct.setLastUpdate(new Date());
        productRepository.save(dbProduct);
    }

    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteExpiredProducts() {

    }
}
