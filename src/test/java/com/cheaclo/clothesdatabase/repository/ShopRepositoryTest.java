package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ShopRepositoryTest {
    @Autowired
    private ShopRepository shopRepository;

    private final String firstShop = "Mango";
    private final String notExistingShop = "Not existing shop";

    @Test
    public void findFirstByNameIgnoreCaseTest() {
        Shop shop = shopRepository.findFirstByNameIgnoreCase(firstShop);
        assert(shop != null);

        shop = shopRepository.findFirstByNameIgnoreCase(firstShop.toLowerCase());
        assert(shop != null);

        Shop notExisitingShop = shopRepository.findFirstByNameIgnoreCase(notExistingShop);
        assert(notExisitingShop == null);
    }
}