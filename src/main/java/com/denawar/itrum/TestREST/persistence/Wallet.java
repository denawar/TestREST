package com.denawar.itrum.TestREST.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID uuid;
}
