package com.cheaclo.clothesdatabase.model.request;

import com.cheaclo.clothesdatabase.model.ProductCategory;
import com.cheaclo.clothesdatabase.model.ProductType;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectProductRequestTest() {
        ProductRequestBody productRequestBody = new ProductRequestBody();
        productRequestBody.setPrice(23.2);
        productRequestBody.setRegularPrice(44.4);
        productRequestBody.setProductUrl("https://url.com");

        Set<ConstraintViolation<ProductRequestBody>> violations = validator.validate(productRequestBody);
        assertEquals(4, violations.size());

        productRequestBody.setTitle("1");
        violations = validator.validate(productRequestBody);
        assertEquals(4, violations.size());

    }

    @Test
    public void correctProductRequestTest() {
        ProductRequestBody productRequestBody = new ProductRequestBody();
        productRequestBody.setTitle("Valid title");
        productRequestBody.setPrice(23.2);
        productRequestBody.setRegularPrice(44.4);
        productRequestBody.setProductUrl("https://url.com");
        productRequestBody.setImageUrl("https://image.com");
        productRequestBody.setCategories(List.of(ProductCategory.LINGERIE, ProductCategory.OTHERS));
        productRequestBody.setType(ProductType.UNISEX);

        Set<ConstraintViolation<ProductRequestBody>> violations = validator.validate(productRequestBody);
        assertEquals(0, violations.size());
    }
}