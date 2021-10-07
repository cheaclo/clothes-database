package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.entity.Shop;
import com.cheaclo.clothesdatabase.repository.ProductRepository;
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
}
