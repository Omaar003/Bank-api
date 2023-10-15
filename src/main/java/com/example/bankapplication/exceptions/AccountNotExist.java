package com.example.bankapplication.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class AccountNotExist extends RuntimeException{
    public AccountNotExist(String message){
        super(message);
    }
}
