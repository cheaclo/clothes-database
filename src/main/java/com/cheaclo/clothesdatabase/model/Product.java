package com.cheaclo.clothesdatabase.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String title;
    private String price;
    private String regularPrice;
    private String shopUrl;
    private String imageUrl;
    private List<String> categories;
    private String type;
    private String shop;
}
