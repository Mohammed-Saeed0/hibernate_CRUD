package com.hibernate.projects;

import com.hibernate.entity.Employee;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class ReadeApp
{
    public static void main( String[] args )
    {

        // create session factory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        // inittialize the session objectt
        Session session = sessionFactory.openSession();


        try {
            session.beginTransaction();
            // read the object from db
            // we can use load method instead of get method
            // notes : here transaction(begin and commit) is optional
            Employee employee = session.get(Employee.class, 2);
            session.getTransaction().commit();
            System.out.println(" the employee1 object from db db is " + employee);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("there is an issue..");
        }

        session.close();




    }
}
