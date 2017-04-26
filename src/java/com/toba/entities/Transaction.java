/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author Will Crowe
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trransaction.findAll", query = "SELECT t FROM Trransaction t")
    , @NamedQuery(name = "Trransaction.findByTransactionId", query = "SELECT t FROM Trransaction t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "Trransaction.findByTransactionAmt", query = "SELECT t FROM Trransaction t WHERE t.transactionAmt = :transactionAmt")
    , @NamedQuery(name = "Trransaction.findByTransactionDate", query = "SELECT t FROM Trransaction t WHERE t.transactionDate = :transactionDate")
    , @NamedQuery(name = "Trransaction.findByTransactionType", query = "SELECT t FROM Trransaction t WHERE t.transactionType = :transactionType")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long transactionId;
    @Basic(optional = false)
    private long transactionAmt;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    private String transactionType;
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Account accountId;

    public Transaction() {
    }

    public Transaction(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Transaction(Long transactionId, long transactionAmt, Date transactionDate) {
        this.transactionId = transactionId;
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public long getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(long transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
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
        return "com.toba.entities.Trransaction[ transactionId=" + transactionId + " ]";
    }
    
}
