package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    private final String categoryName = "Underwear";
    private final String nonExistingCategoryName = "Non existing category";

    @Test
    public void findFirstByNameIgnoreCaseTest() {
        ProductCategory productCategory = productCategoryRepository.findFirstByNameIgnoreCase(categoryName);
        assert(productCategory != null);

        productCategory = productCategoryRepository.findFirstByNameIgnoreCase(categoryName.toUpperCase());
        assert(productCategory != null);

        ProductCategory nonExistingProductCategory = productCategoryRepository.findFirstByNameIgnoreCase(nonExistingCategoryName);
        assert(nonExistingProductCategory == null);
    }
}