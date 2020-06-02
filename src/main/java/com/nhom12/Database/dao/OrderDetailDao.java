/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.HibernateUtil;
import com.nhom12.Database.Models.Order;
import com.nhom12.Database.Models.OrderDetail;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Truong98
 */
public class OrderDetailDao {

    private SessionFactory factory;
    private Session session;

    public OrderDetailDao() {
        factory = HibernateUtil.getSessionFactory();
    }

    public List<OrderDetail> getOrderDetails() {
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            String hql = "from OrderDetail";
            Query query = session.createQuery(hql);
            List<OrderDetail> orderDetails = (List<OrderDetail>) query.list();
            session.getTransaction().commit();
            return orderDetails;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public OrderDetail getOrderDetailById(int oID, int uID, int sID) {
        OrderDetail order = null;
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            String hql = "select o from OrderDetail o where o.id.madh=:oid and o.id.masp=:uid and o.id.maSize=:sID";
            Query query = session.createQuery(hql);
            query.setParameter("oid", oID);
            query.setParameter("uid", uID);
            query.setParameter("sID", sID);
            order = (OrderDetail) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return order;
    }

    public boolean Update(OrderDetail detail) {
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            session.update(detail);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean Delete(OrderDetail order) {
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            session.delete(order);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

}
