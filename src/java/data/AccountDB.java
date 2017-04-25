/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.toba.account.account;
import com.toba.transactionservlet.TransactionServlet;
import java.io.Serializable;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
/**
 *
 * @author Will Crowe
 */
public class AccountDB {
     public static void insert(account account){
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
    
        public static List<com.toba.transactionservlet.TransactionServlet> AllTransactions (account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<TransactionServlet> q = em.createQuery("SELECT t FROM Transaction t WHERE t.source = :account OR t.dest = :account". Transaction.class);
        q.setParameter("account", account);
        try {
            List<TransactionServlet> transList = q.getResultList();
            if(transList == null || transList.isEmpty()) {
                return null;
            } else {
                return transList;
            }
        } finally {
            em.close();
        }
    }
}
