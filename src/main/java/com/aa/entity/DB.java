package com.aa.entity;

 
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DB {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to createa sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
     DB ME = new DB();
 
      /* List down all the employees */
      ME.listTheatre();

     
  
   }
   /* Method to CREATE an employee in the database */
   public Integer addTheatre(String name, String address, int screen){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
         Theatre employee = new Theatre(name, screen, address);
         employeeID = (Integer) session.save(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employeeID;
   }
   
   /* Method to  READ all the employees */
   public void listTheatre( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List employees = session.createQuery(" FROM Theatre").list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
            Theatre employee = (Theatre) iterator.next(); 
            System.out.print("  Name: " + employee.getName()); 
            System.out.print(" Screens: " + employee.getScreens()); 
            System.out.println("  Address: " + employee.getAddress()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE salary for an employee */
   
   /* Method to DELETE an employee from the records */
 
   
}