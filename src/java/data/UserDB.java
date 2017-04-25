package data;
import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;
import com.toba.userbean.UserBean;
 

public class UserDB {

        public static void insert(UserBean  user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(user);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public static void update(UserBean user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.merge(user);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }

}
