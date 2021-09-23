package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Sender;
import com.cheaclo.clothesdatabase.repository.SenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SenderAuthentication {
    private final SenderRepository senderRepository;

    public boolean authenticateSender(String name, String code) {
        Sender sender = senderRepository.findFirstByNameIgnoreCase(name);
        if (sender == null)
            return false;
        return sender.getAuthenticationCode().equals(code);
    }
}
