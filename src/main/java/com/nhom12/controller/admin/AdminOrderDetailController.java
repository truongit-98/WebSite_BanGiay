/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller.admin;

import com.nhom12.Database.Models.Order;
import com.nhom12.Database.Models.OrderDetail;
import com.nhom12.Database.Models.OrderProductKey;
import com.nhom12.Database.dao.OrderDao;
import com.nhom12.Database.dao.OrderDetailDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Truong98
 */
@Controller
public class AdminOrderDetailController {

    @RequestMapping(value = "/admin/orderDetails")
    public ModelAndView Index(Model model) {
        ModelAndView mav = new ModelAndView("admin/listOrderDetail");
        OrderDetailDao dao = new OrderDetailDao();
        List<OrderDetail> orderDetails = dao.getOrderDetails();
        model.addAttribute("orderDetails", orderDetails);
        return mav;
    }

    @RequestMapping(value = "/admin/orderDetails/order/{oID}/product/{uID}/size/{sID}")
    public ModelAndView getOrderDetailByID(@PathVariable int oID, @PathVariable int uID, @PathVariable int sID, Model model) {
        ModelAndView mav = new ModelAndView("admin/editOrderDetail");
        OrderDetailDao dao = new OrderDetailDao();
        OrderDetail order = dao.getOrderDetailById(oID, uID, sID);
        model.addAttribute("item", order);
        return mav;
    }

    @RequestMapping(value = "/admin/orderDetail/update", method = RequestMethod.POST)
    public ModelAndView updateOrderDetail(OrderDetail detail, HttpServletRequest request) {
        String maDH = request.getParameter("maDH");
        String maSP = request.getParameter("maSP");
        String maSize = request.getParameter("maSize");
        if (!maDH.isEmpty() && !maSP.isEmpty() && !maSize.isEmpty()) {
            try {
                int idDH = Integer.parseInt(maDH);
                int idSP = Integer.parseInt(maSP);
                int idSize = Integer.parseInt(maSize);
                OrderDetail order = new OrderDetail();
                OrderProductKey key = new OrderProductKey();
                OrderDetailDao dao = new OrderDetailDao();
                key.setMadh(idDH);
                key.setMasp(idSP);
                key.setMaSize(idSize);
                order.setOrderProductKey(key);
                order.setSoluong(detail.getSoluong());
                order.setGia(detail.getGia());
                boolean result = dao.Update(order);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new ModelAndView("redirect:/admin/orderDetails");
    }

    @RequestMapping(value = "/admin/orderDetail/delete/{oID}/product/{uID}/size/{sID}")
    public ModelAndView deleteOrderDetailByID(@PathVariable int oID, @PathVariable int uID, @PathVariable int sID, Model model) {
        OrderDetailDao dao = new OrderDetailDao();
        OrderDetail order = dao.getOrderDetailById(oID, uID, sID);
        boolean result = dao.Delete(order);
        return new ModelAndView("redirect:/admin/orderDetails");

    }

}
