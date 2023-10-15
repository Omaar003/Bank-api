package com.example.bankapplication.repo;

import com.example.bankapplication.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TransactionRepositry extends JpaRepository<TransactionEntity, BigInteger> {
    public List<TransactionEntity> findByCardnumber(BigInteger cardnumber);
}
