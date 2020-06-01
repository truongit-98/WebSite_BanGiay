/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller.admin;

import com.nhom12.Database.Models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nhom12.Database.dao.OrderDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Truong98
 */
@Controller
public class AdminOrderController {

    @RequestMapping(value = "/admin/orders")
    public ModelAndView Index(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, @RequestParam(value = "search", required = false, defaultValue = "") String key,
            @RequestParam(value = "startDate", required = false, defaultValue = "") String startDate, @RequestParam(value = "toDate", required = false, defaultValue = "") String toDate, Model model) throws ParseException {
        ModelAndView mav = new ModelAndView("admin/listOrders");
        OrderDao dao = new OrderDao();
        int maDH = 0;
        String filter = "";
        String regex = "\\d+";
        if (!key.isEmpty()) {
            if (key.matches(regex)) {
                maDH = Integer.parseInt(key);
                filter += " o.maDH like '%" + maDH + "%'";
            } else {
                filter += " o.hoTen like '%" + key + "%'";
            }
        }
        Date startDateSearch = null;
        if (!startDate.isEmpty()) {
            startDateSearch = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            filter += !filter.isEmpty() ? " and o.ngayDat >= :startDate" : " o.ngayDat >= :startDate";
        }
        Date toDateSearch = null;
        if (!toDate.isEmpty()) {
            toDateSearch = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
            filter += !filter.isEmpty() ? " and o.ngayDat <= :toDate" : " o.ngayDat <= toDate )";
        }
        List<Order> listOrders = dao.getOrdersByParam(filter, startDateSearch, toDateSearch, page);
        int amount = dao.getAmountOrdersByParam(filter, startDateSearch, toDateSearch);
        int pageMax = amount / 10;
        if (amount % 10 != 0) {
            pageMax += 1;
        }
        model.addAttribute("keySearch", key);
        model.addAttribute("startDate", startDate);
        model.addAttribute("toDate", toDate);
        model.addAttribute("orders", listOrders);
        model.addAttribute("page", page);
        model.addAttribute("pageMax", pageMax);
        return mav;
    }

    @RequestMapping(value = "/admin/orders/user/{userID}")
    public ModelAndView getOrdersByUserID(@PathVariable int userID, Model model) {
        ModelAndView mav = new ModelAndView("admin/ordersOfUser");
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.getOrdersByCustomerId(userID);
        model.addAttribute("orders", orders);
        return mav;
    }

    @RequestMapping(value = "/admin/orders/{id}")
    public ModelAndView getOrderByID(@PathVariable int id, Model model) {
        ModelAndView mav = new ModelAndView("admin/editOrder");
        OrderDao dao = new OrderDao();
        Order order = dao.getOrderById(id);
        if (order != null) {
            model.addAttribute("order", order);
            return mav;
        }
        return new ModelAndView("redirect:/admin/orders");
    }
    @RequestMapping(value = "/admin/orders/{id}", method=RequestMethod.POST)
    public ModelAndView updateOrder(@PathVariable int id, Order order, HttpServletRequest request) throws ParseException{
        if(order.getMaDH() != id){
            return new ModelAndView("redirect:/admin/orders/" + String.valueOf(order.getMaDH()));
        }
        String ngayDat = request.getParameter("NgayDatt");
        String ngayGiao = request.getParameter("NgayGiaoo");
        if(!ngayDat.isEmpty()){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayDat);
            order.setNgayDat(date);
        }
        if(!ngayGiao.isEmpty()){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayGiao);
            order.setNgayGiao(date);
        }
        OrderDao dao = new OrderDao();
        boolean result = dao.Update(order);
        if(result){
            return new ModelAndView("redirect:/admin/orders");
        }
        return new ModelAndView("redirect:/admin/orders/" + String.valueOf(order.getMaDH()));
    }
    @RequestMapping(value="/admin/orders/delete/{id}")
    public ModelAndView deleteOrderById(@PathVariable int id){
        OrderDao dao = new OrderDao();
        Order order = dao.getOrderById(id);
        boolean result = dao.Delete(order);
        return new ModelAndView("redirect:/admin/orders");
    }
    
}