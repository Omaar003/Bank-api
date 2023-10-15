package com.example.bankapplication.service;

import com.example.bankapplication.dto.AccountResponse;
import com.example.bankapplication.entity.AccountEntity;
import com.example.bankapplication.entity.TransactionEntity;
import com.example.bankapplication.exceptions.AccountNotExist;
import com.example.bankapplication.exceptions.NoEnoughAmount;
import com.example.bankapplication.mapper.AccountMapper;
import com.example.bankapplication.repo.AccountRepositry;

import com.example.bankapplication.repo.TransactionRepositry;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class BankServiceImpl implements BankService {


    @Autowired
    private  AccountMapper accountMapper;
private final AccountRepositry accountRepositry;

    @Autowired
    private TransactionRepositry transactionRepository;



   /* public String getName() {
        return "Omaaaaaaaaar";
    }*/
    //List

    public List<AccountEntity> getAllAccounts()
    {
        return accountRepositry.findAll();
    }

    //Add
    public void addUser(AccountEntity accountEntity){
        accountRepositry.save(accountEntity);
    }

 public Optional<AccountEntity> getUserByCardNumber(BigInteger cardNumber)
 {
     return accountRepositry.findById(cardNumber);
 }

    // View Balance
    public BigInteger getBalance(BigInteger cardNumber)
    {
        return accountRepositry.findById(cardNumber).get().getBalance();
    }

    //Login
    public AccountResponse isExist(String userName, String passWord) throws ObjectNotFoundException {

        AccountEntity account = accountRepositry.findByUsernameAndPassword(userName,passWord);

        if (account != null )
        {
          /*  AccountResponse response = new AccountResponse();
            response.setUsername(account.getUsername());
            response.setCardnumber(account.getCardnumber());
            response.setBalance(account.getBalance());
            return response;*/
            return this.accountMapper.toDto(account);
        }
        else{
            throw new ObjectNotFoundException("Account Not Exists ",userName);
        }
    }
//map struct
// vali.--@pattern--@springvalid--Exception handler
    public AccountResponse deposit(BigInteger cardNumber,BigInteger amount)
    {
        Optional<AccountEntity> accountEntity=accountRepositry.findById(cardNumber);
        if(accountEntity.isPresent())
        {
            AccountEntity account=accountEntity.get();
            BigInteger newbalance=account.getBalance().add(amount);
            account.setBalance(newbalance);
            saveTransaction(cardNumber, "DEPOSIT", amount);
            accountRepositry.save(account);
            return this.accountMapper.toDto(account);
        }
        else {
            throw new AccountNotExist("Account not found ");
        }
    }

    public AccountResponse withdraw(BigInteger cardNumber,BigInteger amount)
    {
        Optional<AccountEntity> accountEntity=accountRepositry.findById(cardNumber);
        if(accountEntity.isPresent())
        {
            AccountEntity account=accountEntity.get();
            BigInteger CurrentBalance=account.getBalance();

            if(CurrentBalance.compareTo(amount)<0)
            {
                //throw new IllegalArgumentException("Insufficient balance for withdrawal.");
                throw new NoEnoughAmount("No Enough Balance");
            }

            BigInteger newBalance=CurrentBalance.subtract(amount);
            account.setBalance(newBalance);
            saveTransaction(cardNumber, "WITHDRAW", amount);
            accountRepositry.save(account);
            return this.accountMapper.toDto(account);
        }
        else
        {
            throw new AccountNotExist("Account not found ");
        }
    }

    public AccountResponse tranfer(BigInteger cardNumber1, BigInteger cardNumber2, BigInteger amount)//1->sender,,2->receiver
    {
        Optional<AccountEntity> accountEntity=accountRepositry.findById(cardNumber1);
        Optional<AccountEntity> accountEntity2 =accountRepositry.findById(cardNumber2);
        if(accountEntity.isPresent()&&accountEntity2.isPresent()) {
            withdraw(cardNumber1, amount);
            System.out.println("Done amount of :"+amount+" has been tranfered to :"+cardNumber2);
            return deposit(cardNumber2, amount);
        }
        else
        {
            {
                throw new AccountNotExist("Account not found ");
            }
        }
    }
    /////////
    public List<TransactionEntity> getTransactions(BigInteger card) {
        return transactionRepository.findByCardnumber(card);

    }

    private void saveTransaction(BigInteger accountId, String type, BigInteger amount) {
        TransactionEntity transaction = new TransactionEntity();
       // transaction.setId(accountId);
        transaction.setCardnumber(accountId);
        transaction.setTimestamp( new Date());
        transaction.setType(type);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);
    }

}
