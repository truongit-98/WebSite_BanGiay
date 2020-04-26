/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.HibernateUtil;
import com.nhom12.Database.Models.CartModel;
import com.nhom12.Database.Models.Order;
import com.nhom12.Database.Models.OrderDetail;
import com.nhom12.Database.Models.OrderProductKey;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Truong98
 */
public class OrderDao {

    private SessionFactory factory;
    private Session session;

    public OrderDao() {
        factory = HibernateUtil.getSessionFactory();
    }

    public List<Order> getOrdersByCustomerId(int id) {
        List<Order> orders = null;
        session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            String hql = "select o from Order o where o.customer.maKH=:uid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", id);
            orders = (List<Order>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return orders;
    }

    public boolean Save(List<CartModel> cartModels, Order order) {
        session = factory.getCurrentSession();

        try {
            
            session.getTransaction().begin();

            session.save(order);
            for (CartModel c : cartModels) {
                OrderDetail detail = new OrderDetail();
                OrderProductKey key = new OrderProductKey();
                key.setMasp(c.getProductId());
                key.setMadh(order.getMaDH());
                key.setMaSize(c.getSizeId());
                detail.setOrderProductKey(key);
                detail.setGia(c.getPrice());
                detail.setSoluong(c.getQuantity());
                session.save(detail);
            }

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
}
