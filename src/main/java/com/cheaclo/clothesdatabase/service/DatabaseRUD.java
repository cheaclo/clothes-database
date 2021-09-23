package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.entity.Shop;
import com.cheaclo.clothesdatabase.repository.ProductRepository;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DatabaseRUD {
    private final long MILLISECOND_PER_MINUTE = 60000;

    @Value("${products.expiration.minutes}")
    private int expirationMinutes;

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;


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

    public void deleteExpiredProducts(com.cheaclo.clothesdatabase.model.Shop shop) throws ModelParseException {
        Shop selectedShop = shopRepository.findFirstByNameIgnoreCase(shop.toString());
        if (selectedShop == null)
            throw new ModelParseException("Cannot find shop '" + shop + "' in database");

        Date expiryDate = new Date(System.currentTimeMillis() - expirationMinutes * MILLISECOND_PER_MINUTE);
        productRepository.deleteByShopIdAndLastUpdateBefore(selectedShop.getId(), expiryDate);
    }
}
