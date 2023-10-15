package com.example.bankapplication.service;

import com.example.bankapplication.dto.AccountResponse;
import com.example.bankapplication.entity.AccountEntity;
import com.example.bankapplication.entity.TransactionEntity;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BankService {
    public List<AccountEntity> getAllAccounts();
    public void addUser(AccountEntity accountEntity);
    public Optional<AccountEntity> getUserByCardNumber(BigInteger cardNumber);
    public BigInteger getBalance(BigInteger cardNumber);
    public AccountResponse isExist(String userName, String passWord);//Login
    public AccountResponse deposit(BigInteger cardNumber,BigInteger amount);
    public AccountResponse withdraw(BigInteger cardNumber,BigInteger amount);
    public AccountResponse tranfer(BigInteger cardNumber1, BigInteger cardNumber2, BigInteger amount);

    public List<TransactionEntity> getTransactions(BigInteger accountId);

  //  private void saveTransaction(BigInteger accountId, String type, BigInteger amount);



}
