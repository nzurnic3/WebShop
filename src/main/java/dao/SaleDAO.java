package dao;

import model.Sale;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleDAO {

    public boolean createSale(Sale sale) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(sale);
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

    public boolean updateSale(Sale sale) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(sale);
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

    public boolean deleteSale(int id) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Sale sale = session.load(Sale.class, id);
            session.delete(sale);
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

    public List<Sale> getAllSales() {

        List<Sale> sales = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            sales = session.createQuery("SELECT a FROM model.Sale a", Sale.class).getResultList();
            tx.commit();

            return sales;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return sales;
        } finally {
            HibernateUtil.close();
        }
    }


    public List<Sale> getByDate(Date sale_date) {

        List<Sale> sales = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            sales = session.createQuery("SELECT a FROM model.Sale a WHERE sale_date = :sale_date", Sale.class)
                    .setParameter("sale_date", sale_date)
                    .getResultList();
            tx.commit();

            return sales;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return sales;

        } finally {
            HibernateUtil.close();
        }
    }

    public Sale getByID(int id) {

        Sale sale = new Sale();
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            sale = session.get(Sale.class, id);
            tx.commit();

            return sale;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return sale;

        } finally {
            HibernateUtil.close();
        }

    }

    public List<Sale> getByBuyer(int buyer_id) {

        List<Sale> sales = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            sales = session.createQuery("SELECT a FROM model.Sale a WHERE buyer_id = :buyer_id", Sale.class)
                    .setParameter("buyer_id", buyer_id)
                    .getResultList();
            tx.commit();

            return sales;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return sales;

        } finally {
            HibernateUtil.close();
        }
    }

    public List<Sale> getByProduct(int product_id) {

        List<Sale> sales = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            sales = session.createQuery("SELECT a FROM model.Sale a WHERE product_id = :product_id", Sale.class)
                    .setParameter("product_id", product_id)
                    .getResultList();
            tx.commit();

            return sales;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return sales;

        } finally {
            HibernateUtil.close();
        }
    }
}