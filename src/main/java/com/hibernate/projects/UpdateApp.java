package com.hibernate.projects;

import com.hibernate.entity.Employee;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class UpdateApp
{
    public static void main( String[] args )
    {

        // create session factory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        // inittialize the session objectt
        Session session = sessionFactory.openSession();


        try {
            session.beginTransaction();

            // load the object that you wanna to update
            Employee employee = session.get(Employee.class, 2);

            // update the object
            employee.setName("ali");
            employee.setSalary(9500);
            session.getTransaction().commit();
            System.out.println(" the employee1 object from db db is updated to : " + employee);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("there is an issue..");
        }

        session.close();


    }
}
