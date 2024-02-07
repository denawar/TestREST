package com.denawar.itrum.TestREST.service;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ChangeWalletObject {

    public enum Operations {DEPOSIT, WITHDRAW}

    private UUID walletUUID;
    private Operations walletOperation;
    private BigDecimal ammount;
}
