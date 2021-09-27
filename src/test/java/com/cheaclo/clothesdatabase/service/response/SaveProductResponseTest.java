package com.cheaclo.clothesdatabase.service.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaveProductResponseTest {
    @Value("${products.response.success}")
    private String successMessage;

    @Value("${sender.authentication.fail}")
    private String senderAuthenticationFailedMessage;

    @Autowired
    private SaveProductResponse saveProductResponse;

    private final String failMessage = "Error message";

    @Test
    void success() {
        assertEquals(successMessage, saveProductResponse.success().message);
    }

    @Test
    void authenticationFailed() {
        assertEquals(senderAuthenticationFailedMessage, saveProductResponse.authenticationFailed().message);
    }

    @Test
    void fail() {
        assertEquals(failMessage, saveProductResponse.fail(failMessage).message);
    }
}