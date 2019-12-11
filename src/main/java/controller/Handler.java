package controller;

import data.Point;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Handler {

    public static void addInDb(Point point){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Transaction tx = session.beginTransaction();
            session.save(point);
            session.getTransaction().commit();
            //tx.commit();
            session.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

   // public static ArrayList<Point> getTable(int id){
     //   return;
   // }










}
