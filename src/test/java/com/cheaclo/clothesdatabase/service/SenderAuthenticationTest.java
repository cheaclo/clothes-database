package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Sender;
import com.cheaclo.clothesdatabase.repository.SenderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SenderAuthenticationTest {
    @Autowired
    private SenderRepository senderRepository;

    @Autowired
    private SenderAuthentication senderAuthentication;

    private final String senderName = "first.sender.name";

    @Test
    void authenticateSender() {
        Sender sender = senderRepository.findFirstByNameIgnoreCase(senderName);
        assertTrue(senderAuthentication.authenticateSender(sender.getName(), sender.getAuthenticationCode()));
    }
}