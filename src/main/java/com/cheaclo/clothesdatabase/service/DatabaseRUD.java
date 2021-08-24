package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class DatabaseRUD {
    private final int MILISECOND_PER_MINUTE = 60000;
    @Autowired
    private ProductRepository productRepository;
    @Value("${products.expiration.minutes}")
    private int expirationMinutes;

    public void insertAndUpdateProducts(List<Product> products) {
        for (Product product : products) {
            Product dbProduct = productRepository.findFirstByHash(product.getHash());
            if (dbProduct == null)
                insertProduct(product);
            else
                updateProduct(dbProduct);
        }
    }

    public void updateProduct(Product dbProduct) {
        dbProduct.setLastUpdate(new Date());
        productRepository.save(dbProduct);
    }

    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteExpiredProducts() {
        Date expiryDate = new Date(System.currentTimeMillis() - expirationMinutes * MILISECOND_PER_MINUTE);
        productRepository.deleteByLastUpdateBefore(expiryDate);
    }
}
