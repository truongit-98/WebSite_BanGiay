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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();

            String hql = "from Product";
            Query query = session.createQuery(hql);
            products = (List<Product>) query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

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

        return product;
    }
}
