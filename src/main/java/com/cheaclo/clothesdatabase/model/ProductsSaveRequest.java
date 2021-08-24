package com.cheaclo.clothesdatabase.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductsSaveRequest {
    private String senderName;
    private String authenticationCode;
    private String shopName;
    List<ModelProduct> products;
}
