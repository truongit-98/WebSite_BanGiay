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
import java.util.Date;
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

    
    public List<Order> getOrdersByParam(String filter, Date startDate, Date toDate, Integer offset){
        List<Order> orders = null;
        try {
            
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            String hql = "";
            if(filter.isEmpty()){
                hql = "from Order o ";
            } 
            else {
                hql = "from Order o where " + filter;
            }
            Query query = session.createQuery(hql);
            if(startDate != null){
                query.setParameter("startDate", startDate);
            } 
            if(toDate != null){
                query.setParameter("toDate", toDate);
            } 
            query.setFirstResult(offset != null ? (offset - 1) * 10 : 0);
            query.setMaxResults(10);
            orders = (List<Order>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return orders;
    }

    public int getAmountOrdersByParam(String filter, Date startDate, Date toDate) {
        int amount = 0;
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            String hql = "";
            if(filter.isEmpty()){
                hql = "select count(o) from Order o";
            } 
            else {
                hql = "select count(o) from Order o where " + filter;
            }
            Query query = session.createQuery(hql);
             if(startDate != null){
                query.setParameter("startDate", startDate);
            } 
            if(toDate != null){
                query.setParameter("toDate", toDate);
            } 
            amount = ((Long)query.uniqueResult()).intValue();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return amount;
    }

    public List<Order> getOrdersByCustomerId(int id) {
        List<Order> orders = null;
        try {
            session = factory.getCurrentSession();
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
    
    public Order getOrderById(int id){
        Order order = null;
        try {
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            String hql = "select o from Order o where o.maDH=:uid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", id);
            order = (Order) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return order;
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
    public boolean Update(Order order){
        try{
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            session.update(order);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException ex){
            session.getTransaction().rollback();
            return false;
        } finally{
            session.close();
        }
    }
    
    public boolean Delete(Order order){
        try{
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            session.delete(order);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException ex){
            session.getTransaction().rollback();
            return false;
        } finally{
            session.close();
        }
    }
}
