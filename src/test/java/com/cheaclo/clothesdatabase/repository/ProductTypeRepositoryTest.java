package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.ProductType;
import com.cheaclo.clothesdatabase.entity.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductTypeRepositoryTest {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    private final String typeName = "unisex";
    private final String notExistingTypeName = "Not existing type";

    @Test
    public void findFirstByNameIgnoreCaseTest() {
        ProductType type = productTypeRepository.findFirstByNameIgnoreCase(typeName);
        assert(type != null);

        type = productTypeRepository.findFirstByNameIgnoreCase(typeName.toUpperCase());
        assert(type != null);

        ProductType nonExistingType = productTypeRepository.findFirstByNameIgnoreCase(notExistingTypeName);
        assert(nonExistingType == null);
    }
}