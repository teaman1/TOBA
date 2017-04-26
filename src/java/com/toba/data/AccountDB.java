/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.data;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.toba.entities.Account;
import com.toba.entities.Transaction;
import java.util.List;
import javax.persistence.TypedQuery;
/**
 *
 * @author Will Crowe
 */
public class AccountDB {
     public static void insert(Account account){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(account);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
        public static List<com.toba.entities.Transaction> AllTransactions (Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Transaction> q = em.createQuery("SELECT t FROM Transaction t WHERE t.source = :account OR t.dest = :account", Transaction.class);
        q.setParameter("account", account);
        try {
            List<Transaction> transactions = q.getResultList();
            if(transactions == null || transactions.isEmpty()) {
                return null;
            } else {
                return transactions;
            }
        } finally {
            em.close();
        }
    }
}
