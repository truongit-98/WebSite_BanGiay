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
import org.hibernate.query.Query;
import org.hibernate.Session;

/**
 *
 * @author Truong98
 */
public class ProductDao {

    private SessionFactory factory;
    private Session session;
    public ProductDao() {
          factory = HibernateUtil.getSessionFactory();
          session = factory.getCurrentSession();
    }

    public List<Product> getAllProducts() {
        //SessionFactory factory;
        //Session session;
        List<Product> products = new ArrayList<Product>();
        try {

            ///factory = HibernateUtil.getSessionFactory();
            //session = factory.getCurrentSession();
            session.getTransaction().begin();

            String sql = "FROM " + Product.class.getName();
            Query<Product> query = session.createQuery(sql);
            products = (List<Product>)query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } 
        return products;
    }
}
