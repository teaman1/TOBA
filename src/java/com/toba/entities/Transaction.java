package com.toba.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
    , @NamedQuery(name = "Transaction.findByTransactionId", query = "SELECT t FROM Transaction t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "Transaction.findByTransactionAmt", query = "SELECT t FROM Transaction t WHERE t.transactionAmt = :transactionAmt")
    , @NamedQuery(name = "Transaction.findByTransactionDate", query = "SELECT t FROM Transaction t WHERE t.transactionDate = :transactionDate")
    , @NamedQuery(name = "Transaction.findByTransactionType", query = "SELECT t FROM Transaction t WHERE t.transactionType = :transactionType")})
public class Transaction implements Serializable {

    public enum TransactionTypes {
        CREDIT,
        DEBIT,
        TRANSFERCS,
        TRANSFERSC
    }
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long transactionId;
    @Basic(optional = false)
    private double transactionAmt;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Enumerated(EnumType.STRING)
    private TransactionTypes transactionType;
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    @ManyToOne(optional = false)
    private Account accountId;

    public Transaction() {
    }

    public Transaction(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Transaction(Long transactionId, double transactionAmt, Date transactionDate, TransactionTypes transactionType, Account accountid) {
        this.transactionId = transactionId;
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType; 
        this.accountId = accountid;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(double transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypes transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }
    
    
    public Transaction(double amt, TransactionTypes type) {
        this.transactionAmt = amt;
        this.transactionType = type;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.toba.entities.Transaction[ transactionId=" + transactionId + " ]";
    }
    
}
