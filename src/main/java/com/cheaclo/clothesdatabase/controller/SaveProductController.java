package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.model.ModelProduct;
import com.cheaclo.clothesdatabase.model.ProductsSaveRequestBody;
import com.cheaclo.clothesdatabase.service.DatabaseRUD;
import com.cheaclo.clothesdatabase.service.ModelParseException;
import com.cheaclo.clothesdatabase.service.ProductParser;
import com.cheaclo.clothesdatabase.service.SenderAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaveProductController {
    @Autowired
    private ProductsResponse productsResponse;
    @Autowired
    private ProductParser productParser;
    @Autowired
    private DatabaseRUD databaseRUD;
    @Autowired
    private SenderAuthentication senderAuthentication;
    @Value("${sender.authentication.fail}")
    private String senderAuthenticationFailed;

    @PostMapping("/save")
    public ProductsResponse saveProducts(@RequestBody ProductsSaveRequestBody request) {
        if (!senderAuthentication.authenticateSender(request.getSenderName(), request.getAuthenticationCode()))
            return productsResponse.fail(senderAuthenticationFailed);

        List<ModelProduct> productModels = request.getProducts();
        String shopName = request.getShopName();

        try {
            List<Product> productEntities = productParser.modelToEntity(productModels, shopName);
            databaseRUD.insertAndUpdateProducts(productEntities);
            databaseRUD.deleteExpiredProducts(shopName);
            return productsResponse.success();
        } catch (ModelParseException exception) {
            return productsResponse.fail(exception.getMessage());
        }
    }
}
