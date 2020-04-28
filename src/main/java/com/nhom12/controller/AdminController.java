/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller;

import com.nhom12.Database.Models.Product;
import com.nhom12.Database.Models.Staff;
import com.nhom12.Database.dao.*;
import java.util.List;
import javax.servlet.http.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Quang Vinh
 */
@Controller
//@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Index(HttpServletRequest request, Model model, HttpSession session) {
        ModelAndView mav = new ModelAndView("login-admin");
        
//        Staff admin = (Staff) session.getAttribute("username");
        if (session.getAttribute("username") != null) {
            ModelAndView admin = new ModelAndView("admin");
            ProductDao productDao = new ProductDao();
            List<Product> products = productDao.getAllProducts(0);
//            admin.setViewName("admin");
            model.addAttribute("products", products);
            return admin;
        }
        return mav;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Login(HttpServletRequest request, Model model, HttpSession session) {
        String userName = request.getParameter("email");
        String pass = request.getParameter("password");
        StaffDao dao = new StaffDao();
        if (userName.isEmpty() || pass.isEmpty()) {
            model.addAttribute("errorMessage", "Tên đăng nhập và mật khẩu không thể để trống!");
            return new ModelAndView("login-admin");
        } else {
            Staff admin = dao.Login(userName, pass);
            if (admin == null) {
                model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng! Vui lòng nhập lại!");
                return new ModelAndView("login-admin");
            }
//            session = request.getSession(); 
            session.setAttribute("isLogin", true);
            session.setAttribute("username", userName);
            return new ModelAndView("admin");
        }
    }
}
