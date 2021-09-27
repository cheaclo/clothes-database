package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.model.ProductCategory;
import com.cheaclo.clothesdatabase.model.ProductType;
import com.cheaclo.clothesdatabase.model.Shop;
import com.cheaclo.clothesdatabase.model.request.ProductRequestBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductParserTest {
    @Autowired
    private ProductParser productParser;

    private final String imageUrl = "https://img.com";
    private final Double price = 21.2;
    private final Double regularPrice = 24.2;
    private final String productUrl = "https://url.com";
    private final String titleOne = "Product one";
    private final String titleTwo = "Product two";

    @Test
    public void modelToEntityTest() throws ModelParseException {
        List<ProductRequestBody> models = getModelProducts();
        List<Product> products = productParser.modelToEntity(models, Shop.CA);
        assert(products != null);
        assertTrue(products.size() == 2);

        for (Product product : products) {
            assertEquals(imageUrl, product.getDetails().getImageUrl());
            assertEquals(productUrl, product.getDetails().getProductUrl());
            assertEquals(price, product.getDetails().getPrice());
            assertEquals(regularPrice, product.getDetails().getRegularPrice());
        }

        assertEquals(titleOne, products.get(0).getDetails().getTitle());
        assertEquals(titleTwo, products.get(1).getDetails().getTitle());
    }

    private List<ProductRequestBody> getModelProducts() {
        ProductRequestBody productRequestBodyOne = new ProductRequestBody();
        productRequestBodyOne.setTitle(titleOne);
        productRequestBodyOne.setPrice(price);
        productRequestBodyOne.setRegularPrice(regularPrice);
        productRequestBodyOne.setProductUrl(productUrl);
        productRequestBodyOne.setImageUrl(imageUrl);
        productRequestBodyOne.setCategories(List.of(ProductCategory.LINGERIE, ProductCategory.OTHERS));
        productRequestBodyOne.setType(ProductType.UNISEX);

        ProductRequestBody productRequestBodyTwo = new ProductRequestBody();
        productRequestBodyTwo.setTitle(titleTwo);
        productRequestBodyTwo.setPrice(price);
        productRequestBodyTwo.setRegularPrice(regularPrice);
        productRequestBodyTwo.setProductUrl(productUrl);
        productRequestBodyTwo.setImageUrl(imageUrl);
        productRequestBodyTwo.setCategories(List.of(ProductCategory.LINGERIE, ProductCategory.OTHERS));
        productRequestBodyTwo.setType(ProductType.UNISEX);

        return List.of(productRequestBodyOne, productRequestBodyTwo);
    }
}