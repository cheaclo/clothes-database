package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.model.ModelProduct;
import com.cheaclo.clothesdatabase.service.DatabaseUpdater;
import com.cheaclo.clothesdatabase.service.ModelParseException;
import com.cheaclo.clothesdatabase.service.ProductParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    private ProductsResponse productsResponse;
    @Autowired
    private ProductParser productParser;
    @Autowired
    private DatabaseUpdater databaseUpdater;

    @PostMapping("/save")
    public ProductsResponse saveProducts(@RequestBody List<ModelProduct> productModels) {
        try {
            List<Product> productEntities = productParser.modelToEntity(productModels);
            databaseUpdater.insertAndUpdateProducts(productEntities);
            return productsResponse.success();
        } catch (ModelParseException exception) {
            return productsResponse.fail(exception.getMessage());
        }
    }
}
