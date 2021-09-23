package com.cheaclo.clothesdatabase;

import com.cheaclo.clothesdatabase.entity.ProductCategory;
import com.cheaclo.clothesdatabase.entity.ProductType;
import com.cheaclo.clothesdatabase.entity.Shop;
import com.cheaclo.clothesdatabase.repository.ProductCategoryRepository;
import com.cheaclo.clothesdatabase.repository.ProductTypeRepository;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDatabase {
    @Value("${database.init}")
    private boolean initDatabase;

    private final ProductCategoryRepository productCategoryRepository;
    private final ShopRepository shopRepository;
    private final ProductTypeRepository productTypeRepository;

    @PostConstruct
    public void postConstruct() {
        if (initDatabase)
            populateDatabase();
    }

    private void populateDatabase() {
        productTypeRepository.save(new ProductType(-1L, "Woman"));
        productTypeRepository.save(new ProductType(-1L, "Man"));
        productTypeRepository.save(new ProductType(-1L, "Kid"));
        productTypeRepository.save(new ProductType(4L, "Unisex"));

        shopRepository.save(new Shop(-1L, "HM"));
        shopRepository.save(new Shop(-1L, "CA"));
        shopRepository.save(new Shop(-1L, "Reserved"));

        productCategoryRepository.save(new ProductCategory(-1L, "Accessories"));
        productCategoryRepository.save(new ProductCategory(-1L, "Babies"));
        productCategoryRepository.save(new ProductCategory(-1L, "Blazers"));
        productCategoryRepository.save(new ProductCategory(-1L, "Cardigans_and_jumpers"));
        productCategoryRepository.save(new ProductCategory(-1L, "Dresses_and_jumpsuits"));
        productCategoryRepository.save(new ProductCategory(-1L, "Extra_discounts"));
        productCategoryRepository.save(new ProductCategory(-1L, "Jackets_and_coats"));
        productCategoryRepository.save(new ProductCategory(-1L, "Jeans"));
        productCategoryRepository.save(new ProductCategory(-1L, "Knitwear"));
        productCategoryRepository.save(new ProductCategory(-1L, "Lingerie"));
        productCategoryRepository.save(new ProductCategory(-1L, "Others"));
        productCategoryRepository.save(new ProductCategory(-1L, "Polo_shirts"));
        productCategoryRepository.save(new ProductCategory(-1L, "Shoes"));
        productCategoryRepository.save(new ProductCategory(-1L, "Shirts_and_blouses"));
        productCategoryRepository.save(new ProductCategory(-1L, "Skirts_and_shorts"));
        productCategoryRepository.save(new ProductCategory(-1L, "Sports"));
        productCategoryRepository.save(new ProductCategory(-1L, "Socks"));
        productCategoryRepository.save(new ProductCategory(-1L, "Suits"));
        productCategoryRepository.save(new ProductCategory(-1L, "Sweatshirts_hoodies_and_sweaters"));
        productCategoryRepository.save(new ProductCategory(-1L, "Swimwear"));
        productCategoryRepository.save(new ProductCategory(-1L, "Trends"));
        productCategoryRepository.save(new ProductCategory(-1L, "Tshirts_and_tops"));
        productCategoryRepository.save(new ProductCategory(-1L, "Trousers_and_leggings"));
        productCategoryRepository.save(new ProductCategory(-1L, "Underwear_and_nightwear"));
    }
}
