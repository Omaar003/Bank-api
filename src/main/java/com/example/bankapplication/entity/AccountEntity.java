package com.example.bankapplication.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CARDNUMBER", nullable = false, precision = 0)
    private BigInteger cardnumber;
    @Basic
    @Column(name = "USERNAME", nullable = false, length = 255)
    private String username;
    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "BALANCE", nullable = true, precision = 0)
    private BigInteger balance= BigInteger.valueOf(0);

    public BigInteger getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(BigInteger cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(cardnumber, that.cardnumber) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardnumber, username, password, balance);
    }


}
