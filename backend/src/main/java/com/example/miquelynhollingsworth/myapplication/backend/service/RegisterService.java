package com.example.miquelynhollingsworth.myapplication.backend.service;

//import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.miquelynhollingsworth.myapplication.backend.hibernate.util.HibernateUtil;
import com.example.miquelynhollingsworth.myapplication.backend.model.Users;

public class RegisterService {

   /* public boolean register(Users user){
        Session session = HibernateUtil.openSession();
        if(isUserExists(user)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public boolean isUserExists(Users user){
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Users where username='"+user.getUsername()+"'");
            Users u = (Users) query.uniqueResult();
            tx.commit();
            if(u!=null) result = true;
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }*/
}