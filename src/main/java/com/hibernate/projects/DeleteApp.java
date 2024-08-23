package com.hibernate.projects;

import com.hibernate.entity.Employee;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class DeleteApp
{
    public static void main( String[] args )
    {

        // create session factory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        // inittialize the session objectt
        Session session = sessionFactory.openSession();


        try {
            session.beginTransaction();

            // load the object that you wanna to delete
            Employee employee = session.get(Employee.class, 2);

            // delete the object
            session.delete(employee);
            session.getTransaction().commit();
            System.out.println( employee + " the employee object is deleted from db : ");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("there is an issue..");
        }

        session.close();

    }
}
