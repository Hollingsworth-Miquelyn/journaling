package com.example.miquelynhollingsworth.myapplication.backend.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.miquelynhollingsworth.myapplication.backend.hibernate.util.HibernateUtil;
import com.example.miquelynhollingsworth.myapplication.backend.model.Users;

public class LoginService {

    public boolean authenticateUser(String username, String password) {
        Users user = getUserByUsername(username);
        if(user!=null && user.getUsername().equals(username) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public Users getUserByUsername(String username) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Users user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Users where username='"+username+"'");
            user = (Users) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public List<Users> getListOfUsers(){
        List<Users> list = new ArrayList<Users>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Users").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}