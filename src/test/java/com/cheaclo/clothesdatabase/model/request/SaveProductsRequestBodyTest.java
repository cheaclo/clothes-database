package com.cheaclo.clothesdatabase.model.request;

import com.cheaclo.clothesdatabase.model.Shop;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SaveProductsRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectSaveProductsRequestTest() {
        SaveProductsRequestBody saveProductsRequestBody = new SaveProductsRequestBody();

        Set<ConstraintViolation<SaveProductsRequestBody>> violations = validator.validate(saveProductsRequestBody);
        assertEquals(4, violations.size());

        saveProductsRequestBody.setSenderName("com.sender.name");
        saveProductsRequestBody.setAuthenticationCode("authcode@@@");

        violations = validator.validate(saveProductsRequestBody);
        assertEquals(2, violations.size());
    }

    @Test
    public void correctSaveProductsRequestTest() {
        SaveProductsRequestBody saveProductsRequestBody = new SaveProductsRequestBody();
        saveProductsRequestBody.setSenderName("com.sender.name");
        saveProductsRequestBody.setAuthenticationCode("authcode@@@");
        saveProductsRequestBody.setShop(Shop.CA);
        saveProductsRequestBody.setProducts(List.of(new ProductRequestBody()));

        Set<ConstraintViolation<SaveProductsRequestBody>> violations = validator.validate(saveProductsRequestBody);
        assertEquals(0, violations.size());
    }
}