/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.HibernateUtil;
import com.nhom12.Database.Models.OrderDetail;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    
//    public List<OrderDetail> getOrderDetailsByOrderID(int id){
//        
//    }

}
