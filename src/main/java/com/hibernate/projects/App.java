package com.hibernate.projects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee1 = new Employee("soma", 10000, "soma@eg.com");

        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.save(employee1);  // create

//        Employee emp = session.get(Employee.class, 2);  // read
//        System.out.println(emp.getName());

//        Employee emp = session.get(Employee.class, 2);  // update
//        System.out.println(emp.getName());
//        emp.setName("ali");
//        emp.setSalary(9500);
//        session.update(emp);

//        Employee emp = session.get(Employee.class, 1);  // delete
//        session.delete(emp);

        transaction.commit();
//        System.out.println( "Hello World!" );
    }
}
