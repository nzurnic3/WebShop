package dao;

import model.Buyer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class BuyerDAO {

    public boolean createBuyer(Buyer buyer) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(buyer);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return false;
        } finally {
            HibernateUtil.close();
        }
    }
    public boolean updateBuyer(Buyer buyer) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(buyer);
            tx.commit();
            return true;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return false;

        } finally {
            HibernateUtil.close();
        }
    }

    public boolean deleteBuyer(int id) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Buyer buyer= session.load(Buyer.class, id);
            session.delete(buyer);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return false;
        } finally {
            HibernateUtil.close();
        }
    }

    public List<Buyer> getAllBuyers() {

        List<Buyer> buyers = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            buyers = session.createQuery("SELECT a FROM model.Buyer a", Buyer.class).getResultList();
            tx.commit();

            return buyers;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return buyers;
        } finally {
            HibernateUtil.close();
        }
    }



    public List<Buyer> getByName(String buyer_name) {

        List<Buyer> buyers = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            buyers = session.createQuery("SELECT a FROM model.Buyer a WHERE buyer_name = :buyer_name", Buyer.class)
                    .setParameter("buyer_name", buyer_name)
                    .getResultList();
            tx.commit();

            return buyers;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return buyers;

        } finally {
            HibernateUtil.close();
        }
    }

    public Buyer getById(int id) {

        Buyer buyer = new Buyer();
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            buyer = session.get(Buyer.class, id);
            tx.commit();

            return buyer;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return buyer;

        } finally {
            HibernateUtil.close();
        }
    }
}
