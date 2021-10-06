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
@RequestMapping("/products")
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
        return getProductsByNameAndShops(value, shops).subList(0, 5);
    }
}
