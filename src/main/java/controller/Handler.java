package controller;

import data.Point;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class Handler {
    private SessionFactory session = null;
    //private Transaction tx = null;

    public Handler() {
        try {
            this.session = HibernateSessionFactoryUtil.getSessionFactory();
            //this.tx = session.beginTransaction();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addInDb(Point point) {
        try {
            Session ses = session.openSession();
            ses.save(point);
            Transaction tx = ses.beginTransaction();
            tx.commit();
            ses.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Point> getTableContext() {
        ArrayList<Point> Points = null;

        try {
            Points = (ArrayList<Point>) session.openSession().createQuery("FROM Point").list();
            Session ses = session.openSession();
            Transaction tx = ses.beginTransaction();
            tx.commit();
            ses.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Points;

    }


}
