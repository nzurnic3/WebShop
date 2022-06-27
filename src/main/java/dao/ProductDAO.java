package dao;

import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean createProduct(Product product) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(product);
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
    public boolean updateProduct(Product product) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(product);
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

    public boolean deleteProduct(int id) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Product product = session.load(Product.class, id);
            session.delete(product);
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

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            products = session.createQuery("SELECT a FROM model.Product a", Product.class).getResultList();
            tx.commit();

            return products;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return products;
        } finally {
            HibernateUtil.close();
        }
    }



    public List<Product> getByName(String product_name) {

        List<Product> products = new ArrayList<>();

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            products = session.createQuery("SELECT a FROM model.Product a WHERE product_name = :product_name", Product.class)
                    .setParameter("product_name", product_name)
                    .getResultList();
            tx.commit();

            return products;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return products;

        } finally {
            HibernateUtil.close();
        }
    }

    public Product getById(int id) {

        Product product = new Product();
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            product = session.get(Product.class, id);
            tx.commit();

            return product;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            return product;

        } finally {
            HibernateUtil.close();
        }
    }
}
