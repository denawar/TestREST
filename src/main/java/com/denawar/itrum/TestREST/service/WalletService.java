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

        //return new Wallet().setUuid(UUID.randowalletmUUID());
        return walletRepository.findById(uuid).orElse(null);
    }

    public void updateWallet(ChangeWalletObject changeWalletObject) {
        Wallet existingWalet = walletRepository.findById(changeWalletObject.getWalletUUID()).orElse(null);
        if (existingWalet != null) {
            switch (changeWalletObject.getWalletOperation()) {
                case DEPOSIT -> existingWalet.setAmount(existingWalet.getAmount().add(changeWalletObject.getAmmount()));
                case WITHDRAW ->
                        existingWalet.setAmount(existingWalet.getAmount().subtract(changeWalletObject.getAmmount()));
                default ->
                        throw new IllegalStateException("Unexpected value: " + changeWalletObject.getWalletOperation());
            }
        } else {
            throw new EntityNotFoundException("Wallet with UUID = " + changeWalletObject.getWalletUUID() + " not found");
        }

    }
}
