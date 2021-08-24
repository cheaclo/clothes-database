package com.cheaclo.clothesdatabase.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductsSaveRequest {
    private String senderName;
    private String authenticationCode;
    List<ModelProduct> products;
}
