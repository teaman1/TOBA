package com.toba.data;

import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;
import com.toba.entities.User;
import com.toba.password.PasswordUtil.PasswordEncoder;
import static com.toba.password.PasswordUtil.PasswordEncoder.getEncryptedPassword;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDB {

    public static User insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
        return user;
    }
    
    public UserDB(){
        seterrorMessage("Fuck");
    }
    private static String errorMessage;

    public static String geterrorMessage() {
        return errorMessage;
    }

    public static void seterrorMessage(String error) {
        errorMessage = error;
    }

    public static User update(User user) {
        EntityManagerFactory emfactory = DBUtil.getEmFactory();
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        try {

            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }

    public static User GetUser(String username) throws Exception {
        boolean isLogin = false;
        EntityManagerFactory emfactory = DBUtil.getEmFactory();

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Query q = entitymanager.createQuery("SELECT u FROM User u WHERE u.userName = :userName");
        q.setParameter("userName", username);
        User a = new User();
        try {
            User user = (User) q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            entitymanager.close();
        }
    }

    public static Boolean UserExists(String email)
    {   User u = null;
        EntityManagerFactory emfactory = DBUtil.getEmFactory();
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Query q = entitymanager.createQuery("SELECT u FROM User u WHERE u.email = :email");
        q.setParameter("email", email);
        try {
            u = (User) q.getSingleResult();
        } catch (NoResultException e) {
            return false;
        } finally {
            entitymanager.close();
        }
        if(u != null)
        {
            seterrorMessage("User already exists");
            return true;
        }
        return false;
    }
}
