package com.example.miquelynhollingsworth.myapplication.backend.service;


import com.example.miquelynhollingsworth.myapplication.backend.hibernate.util.HibernateUtil;
import com.example.miquelynhollingsworth.myapplication.backend.model.User;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RegisterUser {

    private String registerUser;

    public RegisterUser() {
        super();
        //TODO Auto-generated constructor stub
    }

    public void set(String jsonUser){
        registerUser = jsonUser;
    }

    public void regUser() {

        System.out.println(registerUser);

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        User user1 = new User ("Miquelyn", "Hollingsworth", "miquelyn", "miquelyn@email.com", "password", "1234567890");

        System.out.println(" =======READ =======");

        /*String u = args[0];
        RegisterUser user = new RegisterUser();
        user.set(u);*/

        create(user1);
        System.out.println(" =======READ =======");
        List<User> users1 = read();
        for(User u: users1) {
            System.out.println(u.toString());
        }
        System.out.println(" =======UPDATE =======");
        user1.setFirstName("Jan");
        user1.setLastName("Jones");
        user1.setEmail("jan@email.com");
        user1.setUsername("jan");
        update(user1);
        System.out.println(" =======READ =======");
        List<User> users2 = read();
        for(User u: users1) {
            System.out.println(u.toString());
        }
        System.out.println(" =======DELETE ALL ======= ");
        deleteAll();
        System.out.println(" =======READ =======");
        List<User> users3 = read();
        for(User u: users3) {
            System.out.println(u.toString());
        }
        System.exit(0);
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }


    public static Integer create(User u) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + u.toString());
        return u.getUserID();
    }

    public static List<User> read() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<User> users = session.createQuery("FROM User").list();
        session.close();
        System.out.println("Found " + users.size() + " Users");
        return users;
    }

    public static void update(User u) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User us = (User) session.load(User.class, u.getUserID());
        us.setFirstName(u.getFirstName());
        us.setLastName(u.getLastName());
        us.setEmail(u.getEmail());
        us.setUsername(u.getUsername());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + u.toString());
    }

    public static void delete(Integer userId) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User u = findByID(userId);
        session.delete(u);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + u.toString());
    }


    public static User findByID(Integer userId) {
        Session session = getSessionFactory().openSession();
        User u = (User) session.load(User.class, userId);
        session.close();
        return u;
    }

    public static void deleteAll() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all users.");
    }


    }


