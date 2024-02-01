package com.denawar.itrum.TestREST.service;

import com.denawar.itrum.TestREST.persistence.Wallet;
import com.denawar.itrum.TestREST.persistence.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    public Wallet getWallet(UUID uuid){
        return new Wallet();
    }
}
