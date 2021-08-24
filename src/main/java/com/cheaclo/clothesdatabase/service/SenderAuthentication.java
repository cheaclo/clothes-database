package com.cheaclo.clothesdatabase.service;

import org.springframework.stereotype.Service;

@Service
public class SenderAuthentication {
    public boolean authenticateSender(String sender, String code) {
        return true;
    }
}
