/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    , @NamedQuery(name = "Account.findByTransactionType", query = "SELECT a FROM Account a WHERE a.transactionType = :transactionType")})
public class Account implements Serializable {

      public enum transactionType {
        CHECKING, 
        SAVINGS
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long accountId;
    @Basic(optional = false)
    private double balance;
    @Basic(optional = false)
    private String transactionType;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId", fetch = FetchType.LAZY)
    private Collection<Transaction> trransactionCollection;

    public Account() {
    }

    public Account(Long accountId) {
        this.accountId = accountId;
    }

    public Account(Long accountId, double balance, String transactionType) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactionType = transactionType;
    }
    
    public Account(double balance, String transactionType) {
        this.balance = balance;
        this.transactionType = transactionType;
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Transaction> getTrransactionCollection() {
        return trransactionCollection;
    }

    public void setTrransactionCollection(Collection<Transaction> trransactionCollection) {
        this.trransactionCollection = trransactionCollection;
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
