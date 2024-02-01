package com.denawar.itrum.TestREST.controller;

import com.denawar.itrum.TestREST.persistence.Wallet;
import com.denawar.itrum.TestREST.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("${application.endpoint.root}")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("${application.endpoint.wallets}")
    public ResponseEntity<Wallet> getWallet(UUID uuid){
        return ResponseEntity.ok().body(walletService.getWallet(uuid));
    }
}
