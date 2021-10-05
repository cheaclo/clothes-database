package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.entity.Shop;
import com.cheaclo.clothesdatabase.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/shop")
public class ShopController {
    private ShopRepository shopRepository;

    @CrossOrigin
    @GetMapping("/all")
    public List<String> getAllShopsName() {
        return shopRepository.findAllOnlyName();
    }

    @GetMapping("/match")
    public List<String> getShopsBySubstring(@RequestParam(name = "value") String value) {
        List<Shop> shops = shopRepository.findAllByNameContainingIgnoreCase(value);
        List<String> shopsNames = new LinkedList<>();
        for (Shop shop : shops)
            shopsNames.add(shop.getName());
        return shopsNames;
    }
}
