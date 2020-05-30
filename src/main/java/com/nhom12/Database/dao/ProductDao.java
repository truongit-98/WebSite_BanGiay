/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.dao;

import com.nhom12.Database.Models.*;
import org.hibernate.SessionFactory;
import com.nhom12.Database.HibernateUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
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
    }

    //Lấy tất cả sản phẩm
    public List<Product> getAllProducts(int page) {
        List<Product> products = new ArrayList<>();
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();

            String hql = "from Product";
            Query query = session.createQuery(hql);
            query.setFirstResult(8 * page);
            query.setMaxResults(8);
            products = (List<Product>) query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return products;
    }

    //Lấy số lượng sản phẩm theo từ khóa
    public int getAmountProducts(String key) {
        int amount;
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            String hql = "select count(e) from Product e where tensp like '%" + key + "%'";
            Query query = session.createQuery(hql);
            amount = ((Long) query.uniqueResult()).intValue();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return amount;
    }

    //Lấy thông tin chi tiết sản phầm
    public Product getProduct(int id) {
        Product product = null;
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();

            String hql = "select p from Product p where p.masp=:uid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", id);
            product = (Product) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        session.close();
        return product;
    }

    //Lấy sản phẩm theo từ khóa
    public List<Product> getProductsByKey(String key, int page) {
        List<Product> products = new ArrayList<>();
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            String hql = "select p from Product p where tensp like '%" + key + "%'";
//            String hql = "select p from Product p where tensp like '%:ukey%'";
            Query query = session.createQuery(hql);
            query.setFirstResult(8 * page);
            query.setMaxResults(8);
//            query.setParameter("ukey", key);
            products = (List<Product>) query.list();

//            session.getTransaction().commit();
        } catch (Exception ex) {

            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return products;
    }

    public List<Product> getSellingProducts(int quantity) {

        LocalDate currentDate = LocalDate.now();
        List<Product> lstProducts = new ArrayList();
        session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            StoredProcedureQuery query = session.createStoredProcedureQuery("USP_GetSellingProducts")
                    .registerStoredProcedureParameter("quantity", int.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("currentTime", LocalDate.class, ParameterMode.IN)
                    .setParameter("quantity", quantity)
                    .setParameter("currentTime", currentDate);
            List<Object[]> rawList = query.getResultList();
            Iterator it = rawList.iterator();
            while (it.hasNext()) {
                Object[] line = (Object[]) it.next();
                Product product = new Product();
                product.setMasp((int) line[0]);
                product.setTensp((String) line[1]);
                product.setAnh((String) line[2]);
                product.setDongia((double) line[3]);
                lstProducts.add(product);
            }
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        session.close();
        return lstProducts;

    }

    ///Lây danh sách sản phẩm nam nữ 
    public List<Product> getShopProducts(int page, String sex, String key) {
        List<Product> products = new ArrayList<>();
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            String hql = "select e from Product e where (e.gioitinh=:sex) and tensp like '%" + key + "%'";
            Query query = session.createQuery(hql);
            query.setParameter("sex", sex);
            query.setFirstResult(8 * page);
            query.setMaxResults(8);
            products = (List<Product>) query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return products;
    }

    //Lấy danh sách sản phẩm nam nữa theo dkien tim kiem
    public List<Product> getShopProductsSearch(int page, String filter) {
        List<Product> products = new ArrayList<>();
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            String hql = filter;
            Query query = session.createQuery(hql);
//            query.setParameter("gia2", gia*1000000);
            query.setFirstResult(8 * page);
            query.setMaxResults(8);
            products = (List<Product>) query.list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return products;
    }
    
    public int getAmountProductsSearch(String filter) {
        int amount;
        session = factory.getCurrentSession();
        try {

            session.getTransaction().begin();
            String hql = "select count(e) from Product e "+filter;
            Query query = session.createQuery(hql);
            amount = ((Long) query.uniqueResult()).intValue();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;

        }
        session.close();
        return amount;
    }
    
}
