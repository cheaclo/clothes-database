package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.ProductCategory;
import com.cheaclo.clothesdatabase.entity.ProductType;
import com.cheaclo.clothesdatabase.entity.Shop;
import com.cheaclo.clothesdatabase.repository.ProductCategoryRepository;
import com.cheaclo.clothesdatabase.repository.ProductTypeRepository;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import com.cheaclo.clothesdatabase.service.response.CategoryByShopResponse;
import com.cheaclo.clothesdatabase.service.response.CategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clothes/category")
public class CategoryController {
    private ProductCategoryRepository productCategoryRepository;
    private ProductTypeRepository productTypeRepository;
    private ShopRepository shopRepository;

    @GetMapping("/by-type")
    public List<CategoryResponse> getCategoriesByType(@RequestParam String type) {
        ProductType productType = productTypeRepository.findFirstByNameIgnoreCase(type);
        if (productType == null)
            return List.of();

        List<ProductCategory> allCategories = productCategoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new LinkedList<>();
        for (ProductCategory category : allCategories) {
            Long count = productCategoryRepository.countByCategoryIdAndTypeId(category.getId(), productType.getId());
            categoryResponses.add(new CategoryResponse(category.getName(), count > 0));
        }

        return categoryResponses;
    }

    @GetMapping("/by-shop")
    public List<CategoryByShopResponse> getCategoriesByShop(@RequestParam String shopName) {
        Shop shop = shopRepository.findFirstByNameIgnoreCase(shopName);
        if (shop == null)
            return List.of();

        List<CategoryByShopResponse> categoryByShopResponses = new LinkedList<>();
        List<ProductType> allTypes = productTypeRepository.findAll();
        for (ProductType type : allTypes) {

            List<ProductCategory> allCategories = productCategoryRepository.findAll();
            List<CategoryResponse> categoryResponses = new LinkedList<>();
            for (ProductCategory category : allCategories) {
                Long count = productCategoryRepository.countByCategoryIdAndTypeIdAndShopId(category.getId(), type.getId(), shop.getId());
                categoryResponses.add(new CategoryResponse(category.getName(), count > 0));
            }

            categoryByShopResponses.add(new CategoryByShopResponse(type, categoryResponses));
        }

        return categoryByShopResponses;
    }
}
