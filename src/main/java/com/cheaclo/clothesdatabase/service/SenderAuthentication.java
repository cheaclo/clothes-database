package com.cheaclo.clothesdatabase.service;

import com.cheaclo.clothesdatabase.entity.Sender;
import com.cheaclo.clothesdatabase.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderAuthentication {
    @Autowired
    private SenderRepository senderRepository;

    public boolean authenticateSender(String name, String code) {
        Sender sender = senderRepository.findFirstByNameIgnoreCase(name);
        if (sender == null)
            return false;
        return sender.getAuthenticationCode().equals(code);
    }
}
