package controller;

import data.Point;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Point> getTableContext(String username) {
        List<Point> Points = null;
        try {
            Session ses = session.openSession();
            Query query = ses.createQuery("FROM Point WHERE user = :username");
            query.setParameter("username", username);
            Points = query.list();
            ses.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Points;

    }


}
