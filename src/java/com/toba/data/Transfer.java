package com.toba.data;

import com.toba.entities.Account;
import com.toba.entities.Transaction;

public class Transfer extends Transaction{
    private  Account from;
    private  Account to;
    
    
    public Transfer(Account src, Account dest, double amt, TransactionTypes type) {
        this.from = src;
        this.to = dest;
    }
}
