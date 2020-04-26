/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.HibernateUtil;
import com.nhom12.Database.Models.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Truong98
 */
public class CustomerDao {

    private SessionFactory factory;
    private Session session;

    public CustomerDao() {
        factory = HibernateUtil.getSessionFactory();
    }

    public boolean FindById(int id) {
        session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            String hql = "select count(c) from Customer c where c.maKH=:uid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", id);
            Long result = (Long) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            if (result.intValue() > 0) {
                return true;
            }
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }

    public Customer Login(String userName, String pass) {
        Customer result = null;
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            String hql = "select c from Customer c where (c.email=:userName) and (c.matKhau=:pass)";
            Query query = session.createQuery(hql);
            query.setParameter("userName", userName);
            query.setParameter("pass", pass);
            result = (Customer) query.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    public Customer getCustomerById(int id) {
        Customer result = null;
        session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();
            String hql = "select c from Customer c where c.maKH=:uid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", id);
            result = (Customer) query.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    public Customer getCustomerByEmail(String email) {
        Customer result = null;
        session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();
            String hql = "select c from Customer c where c.email=:email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            result = (Customer) query.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    public boolean Save(Customer c) {
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            session.persist(c);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    public boolean Update(Customer cust) {
        try {
            session = factory.getCurrentSession();

            session.getTransaction().begin();
            session.update(cust);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}
