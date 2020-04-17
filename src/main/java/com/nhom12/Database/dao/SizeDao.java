/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.HibernateUtil;
import com.nhom12.Database.Models.Size;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Truong98
 */
public class SizeDao {

    private SessionFactory factory;
    private Session session;

    public SizeDao() {
        factory = HibernateUtil.getSessionFactory();
        session = factory.getCurrentSession();
    }

    public List<Size> getAllSizes() {
        List<Size> sizes = new ArrayList<>();
        try {
            session.getTransaction().begin();

            String hql = "from Size";
            Query query = session.createQuery(hql);
            sizes = (List<Size>) query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return sizes;
    }
}
