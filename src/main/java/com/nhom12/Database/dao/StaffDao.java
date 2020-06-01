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
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
    
    public Staff getStaffById(int id) {
        Staff result = null;
        session = factory.getCurrentSession();

        try {

            session.getTransaction().begin();
            String hql = "select c from Staff c where c.manv=:uid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", id);
            result = (Staff) query.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }
    
    //Lấy danh sách nhân viên
    public List<Staff> getStaffs() {
        List<Staff> staffs = new ArrayList<>();
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            String hql = "from Staff";
            Query query = session.createQuery(hql);
            
            staffs = (List<Staff>) query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return staffs;
    }
    
    public boolean Save(Staff s) {
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            session.persist(s);
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
    
    public boolean Update(Staff s) {
        try {
            session = factory.getCurrentSession();

            session.getTransaction().begin();
            session.update(s);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean Delete(Staff s) {
        try {
            session = factory.getCurrentSession();

            session.getTransaction().begin();
            session.delete(s);
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
