package com.hibernate.utils;

import com.hibernate.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    // singelton design pattern => to make sure that there is one object of sessionFactory in my app
    // because session factory is heavy weight
    // if anyone call the getSessionFactory() method there is one session factory instance every time
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory() {

        try {
            if(sessionFactory == null) {
                // create configuration file
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Employee.class);

                // create session factory
                sessionFactory = configuration.buildSessionFactory();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("there is some issues when creating a session factory...");
        }
        return sessionFactory;
    }
}
