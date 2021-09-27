package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SenderRepositoryTest {
    @Autowired
    private SenderRepository senderRepository;

    private final String senderName = "first.sender.name";
    private final String authenticationCode = "codecodecode";
    private final String notExistingSenderName = "not.existing.user";

    @Test
    public void findFirstByNameIgnoreCaseTest() {
        Sender sender = senderRepository.findFirstByNameIgnoreCase(senderName);
        assert(sender != null);
        assertEquals(authenticationCode, sender.getAuthenticationCode());

        sender = senderRepository.findFirstByNameIgnoreCase(senderName.toUpperCase());
        assert(sender != null);
        assertEquals(authenticationCode, sender.getAuthenticationCode());

        Sender notExistingSender = senderRepository.findFirstByNameIgnoreCase(notExistingSenderName);
        assert(notExistingSender == null);
    }
}