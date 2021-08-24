package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.*;
import com.cheaclo.clothesdatabase.model.ModelProduct;
import com.cheaclo.clothesdatabase.repository.ProductCategoryRepository;
import com.cheaclo.clothesdatabase.repository.ProductTypeRepository;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductParser {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<Product> modelToEntity(List<ModelProduct> modelProducts, String shopName) throws ModelParseException{
        List<Product> entityProducts = new ArrayList<>();
        for (ModelProduct model : modelProducts) {
            ProductDetails productDetails = new ProductDetails(model.getTitle(),
                    extractDouble(model.getPrice()),
                    extractDouble(model.getRegularPrice()),
                    model.getProductUrl(),
                    model.getImageUrl());

            Set<ProductCategory> categories = new HashSet<>();
            for (String modelCategory : model.getCategories()) {
                ProductCategory category = productCategoryRepository.findFirstByNameIgnoreCase(modelCategory);
                if (category == null)
                    throw new ModelParseException("Cannot find category '" + modelCategory + "' in database");
                categories.add(category);
            }

            Shop shop = shopRepository.findFirstByNameIgnoreCase(shopName);
            if (shop == null)
                throw new ModelParseException("Cannot find shop '" + shopName + "' in database");

            ProductType type = productTypeRepository.findFirstByNameIgnoreCase(model.getType());
            if (type == null)
                throw new ModelParseException("Cannot find type '" + model.getType() + "' in database");

            Product product = new Product(productDetails, categories, shop, type, new Date());
            product.setHash(product.hashCode());
            entityProducts.add(product);
        }
        return entityProducts;
    }

    private double extractDouble(String arg) throws ModelParseException{
        try {
            return Double.parseDouble(arg);
        } catch(Exception e) {
            throw new ModelParseException("Cannot parse value '" + arg + "' to double");
        }
    }
}
