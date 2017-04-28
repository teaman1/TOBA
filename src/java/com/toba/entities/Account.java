/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.entities;

import com.toba.data.TransactionDB;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Will Crowe
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId")
    , @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance")
    , @NamedQuery(name = "Account.findByTransactionType", query = "SELECT a FROM Account a WHERE a.accountType = :accountType")})
public class Account implements Serializable {

    public enum AccountType {
        CHECKING, SAVINGS
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long accountId;
    @Basic(optional = false)
    private double balance;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Transaction> transactionCollection;

    public Account() {
    }

    public Account(Long accountId) {
        this.accountId = accountId;
    }

    public Account(Long accountId, double balance, AccountType accountType, User userId) {
        this.accountId = accountId;
        this.balance = balance;
        this.accountType = accountType;
        this.userId = userId;
    }

    public void Credit(double money) {
        balance += money;
        Date now = new Date();
        Transaction credit = new Transaction(0L, money, now, Transaction.TransactionTypes.CREDIT, this);
        TransactionDB.insert(credit);
    }

    public void Debit(double money) {
        balance -= money;
        Date now = new Date();
        Transaction debit = new Transaction(0L, money, now, Transaction.TransactionTypes.DEBIT, this);
        TransactionDB.insert(debit);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType transactionType) {
        this.accountType = accountType;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.toba.entities.Account[ accountId=" + accountId + " ]";
    }

}
