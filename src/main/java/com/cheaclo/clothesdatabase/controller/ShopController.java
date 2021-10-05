package com.cheaclo.clothesdatabase.controller;

import com.cheaclo.clothesdatabase.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @CrossOrigin
    @GetMapping("/all")
    public List<String> getAllShopsName() {
        return shopRepository.findAllOnlyName();
    }
}
