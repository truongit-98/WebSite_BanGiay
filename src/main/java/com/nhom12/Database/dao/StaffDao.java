/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.HibernateUtil;
import com.nhom12.Database.Models.Customer;
import com.nhom12.Database.Models.Staff;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Quang Vinh
 */
public class StaffDao {

    private SessionFactory factory;
    private Session session;

    public StaffDao() {
        factory = HibernateUtil.getSessionFactory();
    }

    public Staff Login(String userName, String pass) {
        Staff result = null;
        try {
            session = factory.getCurrentSession();

            session.getTransaction().begin();
            String hql = "select c from Staff c where (c.email=:userName) and (c.matkhau=:pass)";
            Query query = session.createQuery(hql);
            query.setParameter("userName", userName);
            query.setParameter("pass", pass);
            result = (Staff) query.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }
}
