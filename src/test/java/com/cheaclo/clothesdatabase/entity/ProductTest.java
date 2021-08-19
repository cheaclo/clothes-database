package com.cheaclo.clothesdatabase.entity;

import com.cheaclo.clothesdatabase.repository.ProductCategoryRepository;
import com.cheaclo.clothesdatabase.repository.ProductRepository;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class ProductTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void getCategories() {
        Shop hm = new Shop(1L, "HM");
        Shop ca = new Shop(2L, "CA");
        Shop reserved = new Shop(2L, "Reserved");

        shopRepository.save(hm);
        shopRepository.save(ca);
        shopRepository.save(reserved);

        ProductCategory category1 = new ProductCategory(1L, "Accessories");
        ProductCategory category2 = new ProductCategory(2L, "Babies");
        ProductCategory category3 = new ProductCategory(3L, "Blazers");

        productCategoryRepository.save(category1);
        productCategoryRepository.save(category2);
        productCategoryRepository.save(category3);

        List<ProductCategory> categories = productCategoryRepository.findAll();
        System.out.println(categories);

        Product product1 = new Product(-1L, "Title 1", Set.of(category1, category2), hm);
        Product product2 = new Product(-1L, "Title 2", Set.of(category1, category2, category3), hm);
        Product product3 = new Product(-1L, "Title 3", Set.of(category2), reserved);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> products = productRepository.findAll();
        System.out.println(products);
    }
}