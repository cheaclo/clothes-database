package com.cheaclo.clothesdatabase.model;

import lombok.Data;

import java.util.List;

@Data
public class ModelProduct {
    private String title;
    private String price;
    private String regularPrice;
    private String productUrl;
    private String imageUrl;
    private List<String> categories;
    private String type;
}
