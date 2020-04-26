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
import org.hibernate.HibernateException;
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
       
    }

    public List<Size> getAllSizes() {
        
        List<Size> sizes = new ArrayList<>();
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();

            String hql = "from Size";
            Query query = session.createQuery(hql);
            sizes = (List<Size>) query.list();
            session.getTransaction().commit();

        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return sizes;
    }
    
    public Size getSizeById(int id){
        Size size = new Size();
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();

            String hql = "from Size s where s.maSize=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            size = (Size) query.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return size;
    }
}
