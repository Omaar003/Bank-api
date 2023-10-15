package com.example.bankapplication.controller;

import com.example.bankapplication.dto.AccountResponse;
import com.example.bankapplication.entity.AccountEntity;
import com.example.bankapplication.entity.TransactionEntity;
import com.example.bankapplication.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Qualifier
@RestController
@RequestMapping("/home")
public class BankController {

    @Autowired
    BankService bankService;

  /*  @GetMapping("/name")
    public String getName(){
        return bankService.getName();
    }*/
//ListAllUsers
@GetMapping("/Accounts")
public List<AccountEntity> getAccounts()
{
    return bankService.getAllAccounts();
}
//AddNewUser
@PostMapping("/create/user")
public ResponseEntity addUser(@RequestBody AccountEntity accountEntity)
{
    bankService.addUser(accountEntity);
    return ResponseEntity.ok().build();
}

@GetMapping("/user/id/{card}")
    public Optional<AccountEntity> getUserByCardNumber(@PathVariable BigInteger card)
{
    return bankService.getUserByCardNumber(card);
}

    @GetMapping("/user/balance/{card}")
    public Optional<BigInteger> getBalance(@PathVariable BigInteger card)
    {
        return Optional.ofNullable(bankService.getBalance(card));
    }

/*    @GetMapping("/login/{username}/{password}")
    public boolean login (@PathVariable String username,@PathVariable String password)
    {
        return bankService.IsExist(username,password);
    }*/

@GetMapping("/isExist")
public AccountResponse isAccountExists(@RequestParam String userName,@RequestParam String passWord){
        AccountResponse accountResponse = bankService.isExist(userName, passWord);
        if (accountResponse != null) {
            return accountResponse;
        }else{

        }
    return null;
}

    @PostMapping("/{cardNumber}/deposit")
    public ResponseEntity<AccountResponse> deposit(@PathVariable BigInteger cardNumber, @RequestParam BigInteger amount) {
        AccountResponse response = bankService.deposit(cardNumber, amount);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/{cardNumber}/withdraw")
    public ResponseEntity<AccountResponse> withdraw(@PathVariable BigInteger cardNumber, @RequestParam BigInteger amount) {
        AccountResponse updatedAccount = bankService.withdraw(cardNumber, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    @PostMapping("/{cardNumber1}/{cardNumber2}/transfer")
    public ResponseEntity<AccountResponse> withdraw(@PathVariable BigInteger cardNumber1,@PathVariable BigInteger cardNumber2, @RequestParam BigInteger amount) {
       AccountResponse account = bankService.tranfer(cardNumber1,cardNumber2, amount);
       return ResponseEntity.ok(account);
    }

    @GetMapping("/{cardNumber}/transactions")
    public ResponseEntity<List<TransactionEntity>> getTransactions(@PathVariable BigInteger cardNumber) {
        List<TransactionEntity> transactions = bankService.getTransactions(cardNumber);
        return ResponseEntity.ok(transactions);
    }

}
