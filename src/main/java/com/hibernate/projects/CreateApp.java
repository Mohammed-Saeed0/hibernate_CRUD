package com.hibernate.projects;

import com.hibernate.entity.Employee;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class CreateApp
{
    public static void main( String[] args )
    {

        // create session factory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        // inittialize session
        Session session = sessionFactory.openSession();

        // create object
        Employee employee1 = new Employee("soma", 10000, "soma@eg.com");

        try {
            session.beginTransaction();
            session.save(employee1);  // create
            session.getTransaction().commit();
            System.out.println("the employee1 object is inserted into db...");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("there is an issue..");
        }

        session.close();


    }
}
