package com.example.bankapplication.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION", schema = "HR", catalog = "")
public class TransactionEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_SEQ")
    @SequenceGenerator(name = "TRANSACTION_SEQ", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private BigInteger id;
    @Basic
    @Column(name = "CARDNUMBER", nullable = true, precision = 0)
    private BigInteger cardnumber;
    @Basic
    @Column(name = "TIMESTAMP", nullable = true)
    private Date timestamp;
    @Basic
    @Column(name = "TYPE", nullable = true, length = 20)
    private String type;
    @Basic
    @Column(name = "AMOUNT", nullable = true, precision = 0)
    private BigInteger amount;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(BigInteger cardnumber) {
        this.cardnumber = cardnumber;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(cardnumber, that.cardnumber) && Objects.equals(timestamp, that.timestamp) && Objects.equals(type, that.type) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardnumber, timestamp, type, amount);
    }
}
