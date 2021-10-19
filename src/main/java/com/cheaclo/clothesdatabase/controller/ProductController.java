package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.entity.ProductCategory;
import com.cheaclo.clothesdatabase.entity.ProductType;
import com.cheaclo.clothesdatabase.entity.Shop;
import com.cheaclo.clothesdatabase.repository.ProductCategoryRepository;
import com.cheaclo.clothesdatabase.repository.ProductRepository;
import com.cheaclo.clothesdatabase.repository.ProductTypeRepository;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clothes/product")
public class ProductController {
    private ProductRepository productRepository;
    private ProductTypeRepository productTypeRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ShopRepository shopRepository;

    @GetMapping("/ids")
    public List<Product> getProductByIds(@RequestParam List<Long> ids) {
        return productRepository.findAllByIds(ids);
    }

    @GetMapping("/match")
    public List<Product> getProductsByNameAndShops(@RequestParam String value,
                                                    @RequestParam String shops) {
        List<String> splitShops = List.of(shops.split(","));
        return productRepository.findAllByNameAndShop(value, splitShops);
    }

    @GetMapping("/match/five")
    public List<Product> getFirstFiveProductsByNameAndShops(@RequestParam String value,
                                                            @RequestParam String shops) {
        List<Product> products = getProductsByNameAndShops(value, shops);
        if (products.size() >= 5)
            return products.subList(0, 5);
        return products;
    }

    @GetMapping("/by-type")
    public List<Product> getAllProductsByType(@RequestParam String type) {
        ProductType productType = productTypeRepository.findFirstByNameIgnoreCase(type);
        if (productType == null)
            return List.of();

        List<Product> products = productRepository.findAllByType(productType.getId());
        return products;
    }


    @GetMapping("/by-type-and-category")
    public List<Product> getAllProductsByTypeAndCategory(@RequestParam String type,
                                                         @RequestParam String category) {
        ProductType productType = productTypeRepository.findFirstByNameIgnoreCase(type);
        if (productType == null)
            return List.of();

        ProductCategory productCategory = productCategoryRepository.findFirstByNameIgnoreCase(category);
        if (productCategory == null)
            return List.of();

        List<Product> products = productRepository.findAllByTypeAndCategories(productType.getId(), productCategory.getId());
        return products;
    }

    @GetMapping("/by-shop")
    public List<Product> getAllProductsByShop(@RequestParam String shopName) {
        Shop shop = shopRepository.findFirstByNameIgnoreCase(shopName);
        if (shop == null)
            List.of();

        return productRepository.findAllByShopId(shop.getId());
    }

    @GetMapping("/by-shop-type-and-category")
    public List<Product> getAllProductsByShopAndTypeAndCategory(@RequestParam String shopName,
                                                                 @RequestParam String type,
                                                                 @RequestParam String category) {
        ProductType productType = productTypeRepository.findFirstByNameIgnoreCase(type);
        if (productType == null)
            return List.of();

        ProductCategory productCategory = productCategoryRepository.findFirstByNameIgnoreCase(category);
        if (productCategory == null)
            return List.of();

        Shop shop = shopRepository.findFirstByNameIgnoreCase(shopName);
        if (shop == null)
            List.of();

        List<Product> products = productRepository.findAllByShopAndTypeAndCategories(shop.getId(), productType.getId(), productCategory.getId());
        return products;
    }
}
