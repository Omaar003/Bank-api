package com.example.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AccountResponse {

    private BigInteger cardnumber;
    private String username;
    private BigInteger balance= BigInteger.valueOf(0);

}
