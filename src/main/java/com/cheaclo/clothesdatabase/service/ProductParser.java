package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.*;
import com.cheaclo.clothesdatabase.model.request.ProductRequestBody;
import com.cheaclo.clothesdatabase.repository.ProductCategoryRepository;
import com.cheaclo.clothesdatabase.repository.ProductTypeRepository;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductParser {
    private final ShopRepository shopRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public List<Product> modelToEntity(List<ProductRequestBody> modelProducts, com.cheaclo.clothesdatabase.model.Shop shop) throws ModelParseException{
        List<Product> entityProducts = new ArrayList<>();
        for (ProductRequestBody model : modelProducts) {
            ProductDetails productDetails = new ProductDetails(model.getTitle(),
                    model.getPrice(),
                    model.getRegularPrice(),
                    model.getProductUrl(),
                    model.getImageUrl());

            Set<ProductCategory> categories = new HashSet<>();
            for (com.cheaclo.clothesdatabase.model.ProductCategory requestCategory : model.getCategories()) {
                ProductCategory category = productCategoryRepository.findFirstByNameIgnoreCase(requestCategory.toString());
                if (category == null)
                    throw new ModelParseException("Cannot find category '" + requestCategory + "' in database");
                categories.add(category);
            }

            Shop selectedShop = shopRepository.findFirstByNameIgnoreCase(shop.toString());
            if (selectedShop == null)
                throw new ModelParseException("Cannot find shop '" + shop + "' in database");

            ProductType type = productTypeRepository.findFirstByNameIgnoreCase(model.getType().toString());
            if (type == null)
                throw new ModelParseException("Cannot find type '" + model.getType() + "' in database");

            Product product = new Product(productDetails, categories, selectedShop, type, new Date());
            product.setHash(product.hashCode());
            entityProducts.add(product);
        }
        return entityProducts;
    }
}
