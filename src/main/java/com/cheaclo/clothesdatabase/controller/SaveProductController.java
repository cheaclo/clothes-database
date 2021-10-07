package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.model.Shop;
import com.cheaclo.clothesdatabase.model.request.ProductRequestBody;
import com.cheaclo.clothesdatabase.model.request.SaveProductsRequestBody;
import com.cheaclo.clothesdatabase.service.*;
import com.cheaclo.clothesdatabase.service.response.SaveProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clothes/product")
public class SaveProductController {
    private final SaveProductResponse saveProductResponse;
    private final ProductParser productParser;
    private final DatabaseRUD databaseRUD;
    private final SenderAuthentication senderAuthentication;

    @PostMapping("/save")
    public ResponseEntity<SaveProductResponse> saveProducts(@RequestBody SaveProductsRequestBody request) {
        if (!senderAuthentication.authenticateSender(request.getSenderName(), request.getAuthenticationCode()))
            return ResponseEntity.badRequest().body(saveProductResponse.authenticationFailed());

        List<ProductRequestBody> productModels = request.getProducts();
        Shop shop = request.getShop();

        try {
            List<Product> productEntities = productParser.modelToEntity(productModels, shop);
            databaseRUD.insertAndUpdateProducts(productEntities);
            databaseRUD.deleteExpiredProducts(shop);
            return ResponseEntity.ok(saveProductResponse.success());
        } catch (ModelParseException exception) {
            return ResponseEntity.badRequest().body(saveProductResponse.fail(exception.getMessage()));
        }
    }
}
