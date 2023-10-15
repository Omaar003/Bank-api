package com.example.bankapplication.repo;

import com.example.bankapplication.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface AccountRepositry extends JpaRepository<AccountEntity, BigInteger> {

   public AccountEntity findByUsernameAndPassword(String username, String password);

}
