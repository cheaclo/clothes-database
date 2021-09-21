package com.cheaclo.clothesdatabase.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SaveProductControllerResponse {
    @Value("${products.response.success}")
    private String successMessage;

    public boolean success;
    public String message;

    public SaveProductControllerResponse fail(String errorMessage) {
        success = false;
        message = errorMessage;
        return this;
    }

    public SaveProductControllerResponse success() {
        success = true;
        message = successMessage;
        return this;
    }
}
