package com.denawar.itrum.TestREST.service;

import com.denawar.itrum.TestREST.persistence.Wallet;
import com.denawar.itrum.TestREST.persistence.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    public Wallet getWallet(UUID uuid) {
        return walletRepository.findById(uuid).orElse(null);
    }

    public void updateWallet(ChangeWalletObject changeWalletObject) {
        Wallet existingWallet = walletRepository.findById(UUID.fromString(changeWalletObject.getWalletid())).orElse(null);
        if (existingWallet != null) {
            switch (changeWalletObject.getOperationType()) {
                case DEPOSIT -> existingWallet.setAmount(existingWallet.getAmount().add(changeWalletObject.getAmount()));
                case WITHDRAW ->
                        existingWallet.setAmount(existingWallet.getAmount().subtract(changeWalletObject.getAmount()));
                default ->
                        throw new IllegalStateException("Unexpected value: " + changeWalletObject.getOperationType());
            }
            walletRepository.save(existingWallet);
        } else {
            throw new EntityNotFoundException("Wallet with UUID = " + changeWalletObject.getWalletid() + " not found");
        }

    }
}
