/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.account;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.toba.userbean.UserBean;

@Entity
public class Account implements Serializable {
    
    public enum Type {
        CHECKING, SAVINGS;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.ORDINAL)
    private Type type;
    private double balance;
    @ManyToOne
    @JoinColumn(name="id")
    private UserBean user;
  
    
    
    public Account() {
    
    }

    public Account(Type type, double balance, UserBean user) {
        this.balance = balance;

    }
    
    public void credit(double amount){
        balance += amount;
    }
    public void debit(double amount){
        balance -= amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
    
    
    
}