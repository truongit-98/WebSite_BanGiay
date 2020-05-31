/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller.customer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nhom12.Database.Models.Order;
import com.nhom12.Database.Models.UserCookie;
import com.nhom12.Database.dao.CustomerDao;
import com.nhom12.Database.dao.OrderDao;
import com.nhom12.services.HandleAddress;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Truong98
 */
@Controller
public class OrderController {

    private @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/order/history", method = RequestMethod.GET)
    public ModelAndView orderHistory(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("cookieUser")) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                    OrderDao orderDao = new OrderDao();
                    if (cookie != null) {
                        List<Order> orders = orderDao.getOrdersByCustomerId(cookie.getId());
                        if (orders != null) {
                            model.addAttribute("orders", orders);
                            model.addAttribute("customer", new CustomerDao().getCustomerById(cookie.getId()));
                            return new ModelAndView("order_history");
                        }
                    }
                }
            }
        }
        return new ModelAndView("redirect:/customer");
    }

    @RequestMapping(value = "/order/address", method = RequestMethod.POST)
    public ModelAndView changeAddress(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttribute) throws IOException {
        String cityId = request.getParameter("city");
        String districtId = request.getParameter("district");
        String wardId = request.getParameter("ward");
        String detailAddress = request.getParameter("detailAddress");
        String address = detailAddress + ", ";
        if (!cityId.isEmpty() && !districtId.isEmpty() && !wardId.isEmpty()) {
            try {
                address += HandleAddress.handleAddress(servletContext, cityId, districtId, wardId);
                session.setAttribute("shippingAddress", address);
                return new ModelAndView("redirect:/customer/checkout?isDefault=false");
            } catch (IOException ex) {
                ex.printStackTrace();
                redirectAttribute.addFlashAttribute("errorMessage", "Đã gặp lỗi trong quá trình xử lý !!!");
            }
        }
        redirectAttribute.addFlashAttribute("errorMessage", "Cần điển đầy đủ thông tin !!!");
        return new ModelAndView("redirect:/customer/checkout?edit=true");
    }
}
