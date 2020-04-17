/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nhom12.Database.Models.CartModel;
import com.nhom12.Database.Models.Customer;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.nhom12.Database.Models.UserCookie;
import com.nhom12.Database.dao.CustomerDao;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.nhom12.Database.Models.RootCity;
import com.nhom12.Database.Models.RootObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Truong98
 */
@Controller
public class CustomerController {

    private static final String cookieUser = "cookieUser";
    private @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            ModelAndView mav = new ModelAndView("login");
            return mav;
        } else {
            for (Cookie c : cookies) {
                if (c.getName().equals("cookieUser")) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                    CustomerDao dao = new CustomerDao();
                    if (cookie != null && dao.FindById(cookie.getId())) {
                        return new ModelAndView("redirect:/home");
                    }
                    c.setMaxAge(0);
                    response.addCookie(c);
                    return new ModelAndView("login");
                }
            }
            return new ModelAndView("login");
        }

    }

    @RequestMapping(value = "/customer/login", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Login(HttpServletRequest request, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        String userName = request.getParameter("email");
        String pass = request.getParameter("password");
        CustomerDao dao = new CustomerDao();

        if (userName.isEmpty() || pass.isEmpty()) {
            model.addAttribute("errorMessage", "Tên đăng nhập và mật khẩu không thể để trống!");
            return new ModelAndView("login");
        } else {
            Customer cust = dao.Login(userName, pass);
            if (cust == null) {
                model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng! Vui lòng nhập lại!");
                return new ModelAndView("login");
            }
            UserCookie user = new UserCookie();
            user.setId(cust.getMaKH());
            user.setFullName(cust.getTenKH());
            String json = new Gson().toJson(user);
            Cookie cookie = new Cookie(cookieUser, URLEncoder.encode(json, "UTF-8"));
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            String referer = request.getHeader("referer");
            return new ModelAndView("redirect:" + referer);
        }
    }

    @RequestMapping(value = "/customer/register", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Register(Model model) {
        ModelAndView mav = new ModelAndView("register");
        model.addAttribute("register", new Customer());
        return mav;
    }

    @RequestMapping(value = "/customer/register", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public ModelAndView Register(Customer c, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String cityId = request.getParameter("city");
        String districtId = request.getParameter("district");
        String wardId = request.getParameter("ward");
        String detailAddress = request.getParameter("detailAddress");
        CustomerDao dao = new CustomerDao();

        if (cityId.isEmpty() || districtId.isEmpty() || wardId.isEmpty() || detailAddress.isEmpty()) {
            model.addAttribute("errorMessage", "Cần điền đầy đủ thông tin địa chỉ!");
            return new ModelAndView("register");
        }
        if (dao.getCustomerByEmail(c.getEmail()) != null) {
            model.addAttribute("errorMessage", "Email đã được dùng! Vui lòng sử dụng email khác!");
            return new ModelAndView("register");
        }
        Customer cust = new Customer();
        cust.setTenKH(c.getTenKH());
        cust.setEmail(c.getEmail());
        cust.setMatKhau(c.getMatKhau());
        cust.setGioiTinh(c.getGioiTinh());
        cust.setSdt(c.getSdt());

        String address = detailAddress + ", ";
        InputStream inputStream = null;
        String fileName = "xa-phuong/" + districtId + ".json";
        String content = "";
        StringBuffer buf = new StringBuffer();
        try {
            inputStream = servletContext.getResourceAsStream("/resources/json/" + fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((content = bufferedReader.readLine()) != null) {
                buf.append(content + "\n");
            }
            Map<String, RootObject> map = new Gson().fromJson(buf.toString(), new TypeToken<HashMap<String, RootObject>>() {
            }.getType());
            address = map.get(wardId).getNameWithType();

            inputStream = servletContext.getResourceAsStream("/resources/json/quan-huyen/" + cityId + ".json");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            buf = new StringBuffer();
            content = "";
            while ((content = bufferedReader.readLine()) != null) {
                buf.append(content + "\n");
            }
            map = new Gson().fromJson(buf.toString(), new TypeToken<HashMap<String, RootObject>>() {
            }.getType());
            address += ", " + map.get(districtId).getNameWithType();

            inputStream = servletContext.getResourceAsStream("/resources/json/tinh_tp.json");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            buf = new StringBuffer();
            content = "";
            while ((content = bufferedReader.readLine()) != null) {
                buf.append(content + "\n");
            }
            map = new Gson().fromJson(buf.toString(), new TypeToken<HashMap<String, RootObject>>() {
            }.getType());
            address += ", " + map.get(cityId).getNameWithType();

            cust.setDiaChi(address);
            boolean result = dao.Save(cust);
            if (result) {
                return new ModelAndView("login");
            }
            model.addAttribute("errorMessage", "Đăng ký không thành công!");
            return new ModelAndView("register");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            inputStream.close();
        }
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/customer/checkout", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Checkout(HttpSession session, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView("cart");
        List<CartModel> cartModels = (List<CartModel>) session.getAttribute("cartSession");
        if (cartModels == null || cartModels.size() == 0) {
            return new ModelAndView("redirect:/home");
        }
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return new ModelAndView("redirect:/customer");
        } else {
            for (Cookie c : cookies) {
                if (c.getName().equals("cookieUser")) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                    CustomerDao dao = new CustomerDao();
                    if (cookie != null && dao.FindById(cookie.getId())) {
                        model.addAttribute("customer", dao.getCustomerById(cookie.getId()));
                        model.addAttribute("cartModels", cartModels);
                        long total = 0;
                        for (CartModel c1 : cartModels) {
                            total += c1.getPrice() * c1.getQuantity();
                        }
                        model.addAttribute("total", total);
                        return new ModelAndView("checkout");
                    }
                    return new ModelAndView("redirect:/cart");
                }
            }
            return new ModelAndView("redirect:/customer");
        }
    }

//    @RequestMapping(value = "/customer/checkout", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView OrderComplete(HttpSession session, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
//        ModelAndView mav = new ModelAndView("cart");
//        List<CartModel> cartModels = (List<CartModel>) session.getAttribute("cartSession");
//        if (cartModels == null || cartModels.size() == 0) {
//            return new ModelAndView("redirect:/home");
//        }
//        Cookie[] cookies = request.getCookies();
//        if (cookies == null) {
//            return new ModelAndView("redirect:/customer");
//        } else {
//            for (Cookie c : cookies) {
//                if (c.getName().equals("cookieUser")) {
//                    Type type = new TypeToken<UserCookie>() {
//                    }.getType();
//                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
//                    CustomerDao dao = new CustomerDao();
//                    if (cookie != null && dao.FindById(cookie.getId())) {
//                        Customer cust = dao.getCustomerById(cookie.getId());
//
//                    }
//                    return new ModelAndView("redirect:/cart");
//                }
//            }
//            return new ModelAndView("redirect:/customer");
//        }
//    }
}
