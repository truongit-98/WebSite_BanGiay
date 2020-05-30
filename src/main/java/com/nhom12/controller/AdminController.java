/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller;

import com.nhom12.Database.Models.Product;
import com.nhom12.Database.Models.Staff;
import com.nhom12.Database.dao.*;
import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.http.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;

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
        if (session.getAttribute("username") != null) {
            return new ModelAndView("redirect:/admin/home");
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
            session.setAttribute("isLogin", true);
            session.setAttribute("username", userName);
            return new ModelAndView("redirect:/admin");
        }
    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession session) {
        session.removeAttribute("isLogin");
        session.removeAttribute("username");
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView Home(Model model) {
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts(0);
        model.addAttribute("products", products);
        return new ModelAndView("home_admin");
    }
}
