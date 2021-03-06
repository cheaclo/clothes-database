package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.Shop;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clothes/shop")
public class ShopController {
    private ShopRepository shopRepository;

    @GetMapping("/all")
    public List<String> getAllShopsName() {
        return shopRepository.findAllOnlyName();
    }

    @GetMapping("/match")
    public List<String> getShopsBySubstring(@RequestParam String value) {
        List<Shop> shops = shopRepository.findAllByNameStartsWithIgnoreCase(value);
        List<String> shopsNames = new LinkedList<>();
        for (Shop shop : shops)
            shopsNames.add(shop.getName());
        return shopsNames;
    }
}
