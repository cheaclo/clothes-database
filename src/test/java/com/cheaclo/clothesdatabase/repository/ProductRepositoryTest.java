package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    private final int hash = 124124;
    private final int notExistingHash = 000000;
    private final int year = 2000;
    private final int month = 12;
    private final int day = 17;
    private final Date dateAfter = new GregorianCalendar(year, month, day).getTime();
    private final Long shopId = 1L;

    @Test
    void findFirstByHash() {
        Product product = productRepository.findFirstByHash(hash);
        assert(product != null);

        Product notExistingProduct = productRepository.findFirstByHash(notExistingHash);
        assert(notExistingProduct == null);
    }

    @Test
    void deleteByShopIdAndLastUpdateBefore() {
        productRepository.deleteByShopIdAndLastUpdateBefore(shopId, dateAfter);
        Optional<Product> product = productRepository.findById(shopId);
        assert(!product.isEmpty());

        productRepository.deleteByShopIdAndLastUpdateBefore(shopId, new Date());
        product = productRepository.findById(shopId);
        assert(product.isEmpty());
    }
}