package com.toba.account;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction implements Serializable {
    
    public enum transactionTypes{
        CREDIT,
        DEBIT,
        TRANSFER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name="id")
    private Account account;
    private double amount;
    private transactionTypes type;

    public Transaction() {
        
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Transaction(Account account, double amt, transactionTypes type) {
        this.account = account;
        this.amount = amt;
        this.type = type;
    }
    
}
