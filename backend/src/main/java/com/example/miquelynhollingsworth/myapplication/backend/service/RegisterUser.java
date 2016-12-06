package com.example.miquelynhollingsworth.myapplication.backend.service;


import com.example.miquelynhollingsworth.myapplication.backend.hibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RegisterUser {

    @SuppressWarnings("unchecked")
    public static void main(String user) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();

    }
}
