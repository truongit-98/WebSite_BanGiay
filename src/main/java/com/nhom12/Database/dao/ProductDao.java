/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.Models.*;
import org.hibernate.SessionFactory;
import com.nhom12.Database.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author Truong98
 */
public class ProductDao {

    private SessionFactory factory;
    private Session session;

    public ProductDao() {
        factory = HibernateUtil.getSessionFactory();
    }

    public List<Product> getAllProducts(int page) {
        List<Product> products = new ArrayList<>();
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();

            String hql = "from Product";
            Query query = session.createQuery(hql);
            query.setFirstResult(10 * page);
            query.setMaxResults(10);
            products = (List<Product>) query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return products;
    }

    public long getAmountProducts(String key) {
        long amount;
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();

            String hql = "select count(e) from Product e where tensp like '%" + key + "%'";
//            String hql = "select count(e) from Product e ";
            Query query = session.createQuery(hql);
            amount = (long) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return amount;
    }
        return products;
    }


    public Product getProduct(int id) {
        Product product = null;
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();

            String hql = "select p from Product p where p.masp=:uid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", id);
            product = (Product) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        session.close();
        return product;
    }

    public List<Product> getProductsByKey(String key, int page) {
        List<Product> products = new ArrayList<>();
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            String hql = "select p from Product p where tensp like '%" + key + "%'";
//            String hql = "select p from Product p where tensp like '%:ukey%'";
            Query query = session.createQuery(hql);
            query.setFirstResult(10 * page);
            query.setMaxResults(10);
//            query.setParameter("ukey", key);
            products = (List<Product>) query.list();

//            session.getTransaction().commit();
        } catch (Exception ex) {

            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return products;
    }
}
