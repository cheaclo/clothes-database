package com.cheaclo.clothesdatabase.service.response;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SaveProductResponse {
    @Value("${products.response.success}")
    private String successMessage;

    @Value("${sender.authentication.fail}")
    private String senderAuthenticationFailed;

    public boolean success;
    public String message;

    public SaveProductResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public SaveProductResponse authenticationFailed() {
        success = false;
        message = senderAuthenticationFailed;
        return this;
    }

    public SaveProductResponse fail(String errorMessage) {
        success = false;
        message = errorMessage;
        return this;
    }
}
