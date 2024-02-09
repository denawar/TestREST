package com.denawar.itrum.TestREST.service;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class  ChangeWalletObject {

    public enum Operations {DEPOSIT, WITHDRAW}

    private String walletid;
    private Operations operationType;
    private BigDecimal amount;
}
