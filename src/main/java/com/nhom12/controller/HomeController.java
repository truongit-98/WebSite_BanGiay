/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller;

/**
 *
 * @author Truong98
 */
import com.nhom12.Database.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.nhom12.Database.Models.Product;
import org.hibernate.query.Query;
import org.springframework.ui.Model;
import com.nhom12.Database.dao.ProductDao;

import java.sql.Statement;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(Model model) {

        ModelAndView mav = new ModelAndView("index");
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return mav;
    }

}
