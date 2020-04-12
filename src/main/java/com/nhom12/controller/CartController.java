/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller;

import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.nhom12.Database.dao.ProductDao;
import com.nhom12.Database.Models.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Truong98
 */
@Controller
@EnableWebMvc
public class CartController {

    private static String cartSession = "cartSession";

    @RequestMapping(value = "/cart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map addProduct(HttpServletRequest request, HttpSession session) {
        String idParam = request.getParameter("productId");

        ProductDao dao = new ProductDao();
        try {
           Product product = dao.getProduct(Integer.parseInt(idParam));
            if (product != null) {
                List<CartModel> carts = (List<CartModel>) session.getAttribute(cartSession);

                if (carts != null) {
                    int index = CartModel.findIndex(carts, product.getMasp());
                    if (index > -1) {
                        carts.get(index).setQuantity(carts.get(index).getQuantity() + 1);
                    } else {
                        CartModel cartModel = new CartModel();
                        cartModel.setProductId(product.getMasp());
                        cartModel.setProductName(product.getTensp());
                        cartModel.setPrice(product.getDongia());
                        cartModel.setUrlImg(product.getAnh());
                        cartModel.setQuantity(1);
                        carts.add(cartModel);
                    }

                } else {
                    carts = new ArrayList<>();
                    CartModel cartModel = new CartModel();
                    cartModel.setProductId(product.getMasp());
                    cartModel.setProductName(product.getTensp());
                    cartModel.setPrice(product.getDongia());
                    cartModel.setUrlImg(product.getAnh());
                    cartModel.setQuantity(1);
                    carts.add(cartModel);

                }
                session.setAttribute(cartSession, carts);
                return Collections.singletonMap("status", true);
            }
            return Collections.singletonMap("statue", false);
        } catch (NumberFormatException ex) {
             ex.printStackTrace();
            return Collections.singletonMap("statue", false);

        }
    }

}
