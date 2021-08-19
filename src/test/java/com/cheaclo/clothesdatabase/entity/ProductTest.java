package com.cheaclo.clothesdatabase.entity;

import com.cheaclo.clothesdatabase.repository.*;
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
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Test
    public void getCategories() {
//        ProductDetails productDetails1 = new ProductDetails("Title 1", 12.5, 89.2, "Url 1", "Image url 1");
//        ProductDetails productDetails2 = new ProductDetails("Title 2", 9.5, 19.2, "Url 2", "Image url 2");

//
//        List<ProductCategory> categories = productCategoryRepository.findAll();
//        System.out.println(categories);

//        Product product1 = new Product(-1L, productDetails1, Set.of(category1, category2), hm, unisex);
//        Product product2 = new Product(-1L, productDetails1, Set.of(category1, category2, category3), hm, man);
//        Product product3 = new Product(-1L, productDetails2, Set.of(category2), reserved, kid);
//
//        productRepository.save(product1);
//        productRepository.save(product2);
//        productRepository.save(product3);
//
//        List<Product> products = productRepository.findAll();
        System.out.println("Stop");
    }
}