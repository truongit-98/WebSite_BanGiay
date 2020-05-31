/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller.customer;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
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
import com.nhom12.Database.dao.SizeDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Truong98
 */
@Controller
@EnableWebMvc
public class CartController {

    private static final String cartSession = "cartSession";

    @RequestMapping(value = "/cart", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView index(Model model, HttpSession session) {
        ModelAndView mav = new ModelAndView("cart");
        List<CartModel> cartModels = (List<CartModel>) session.getAttribute(cartSession);
        if (cartModels == null || cartModels.size() == 0) {
            return new ModelAndView("redirect:/home");
        }
        model.addAttribute("cartModels", cartModels);
        model.addAttribute("sellingProducts", new ProductDao().getSellingProducts(4));
        return mav;
    }

    @RequestMapping(value = "/cart/addItemByAjax", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map addProduct(HttpServletRequest request, HttpSession session) {

        Type type = new TypeToken<CartModel>() {
        }.getType();
        CartModel cartModelJson = new Gson().fromJson(request.getParameter("cartModel"), type);
        ProductDao dao = new ProductDao();
        SizeDao sizeDao = new SizeDao();
        Map map = new HashMap();
        try {
            Product product = dao.getProduct(cartModelJson.getProductId());
            Size size = sizeDao.getSizeById(cartModelJson.getSizeId());
            if (product != null && size != null  ) {
                List<CartModel> carts = (List<CartModel>) session.getAttribute(cartSession);
                if (carts != null) {
                    int index = CartModel.findIndex(carts, product.getMasp(), size.getMaSize());
                    if (index > -1) {
                        carts.get(index).setQuantity(carts.get(index).getQuantity() + cartModelJson.getQuantity());
                        map.put("quantity", cartModelJson.getQuantity());
                    } else {
                        CartModel cartModel = new CartModel();

                        cartModel.setProductId(product.getMasp());
                        cartModel.setProductName(product.getTensp());
                        cartModel.setPrice(product.getDongia());
                        cartModel.setUrlImg(product.getAnh());
                        cartModel.setQuantity(cartModelJson.getQuantity());
                        cartModel.setSizeId(cartModelJson.getSizeId());
                        cartModel.setSizeName(size.getSize());
                        carts.add(cartModel);
                        map.put("quantity", cartModelJson.getQuantity());
                    }

                } else {
                    carts = new ArrayList<>();
                    CartModel cartModel = new CartModel();

                    cartModel.setProductId(product.getMasp());
                    cartModel.setProductName(product.getTensp());
                    cartModel.setPrice(product.getDongia());
                    cartModel.setUrlImg(product.getAnh());
                    cartModel.setQuantity(cartModelJson.getQuantity());
                    cartModel.setSizeId(cartModelJson.getSizeId());
                    cartModel.setSizeName(size.getSize());
                    carts.add(cartModel);
                    map.put("quantity", cartModelJson.getQuantity());

                }
                session.setAttribute(cartSession, carts);
                map.put("status", true);
                return map;
            }
            return Collections.singletonMap("status", false);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.singletonMap("status", false);

        }
    }

    @RequestMapping(value = "/cart/updateCartItem", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map updateCart(HttpServletRequest request, HttpSession session) {
        try {
            Type type = new TypeToken<CartModel>() {
            }.getType();
            CartModel cartModelJson = new Gson().fromJson(request.getParameter("cartModel"), type);
            List<CartModel> cartModels = (List<CartModel>) session.getAttribute(cartSession);
            if (cartModels != null) {
                for (CartModel m : cartModels) {
                    if (m.getProductId() == cartModelJson.getProductId() && m.getSizeId() == cartModelJson.getSizeId()) {
                        m.setQuantity(cartModelJson.getQuantity());
                        session.setAttribute(cartSession, cartModels);
                        return Collections.singletonMap("status", true);
                    }
                }
            }
            return Collections.singletonMap("status", false);
        } catch (JsonSyntaxException ex) {
            ex.printStackTrace();
            return Collections.singletonMap("status", false);
        }
    }

    @RequestMapping(value = "/cart/deleteCartItem", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map deleteCart(HttpServletRequest request, HttpSession session) {
        try {
            Map map = new HashMap();
            Type type = new TypeToken<CartModel>() {
            }.getType();
            CartModel cartModelJson = new Gson().fromJson(request.getParameter("cartModel"), type);
            List<CartModel> cartModels = (List<CartModel>) session.getAttribute(cartSession);
            if (cartModels != null && cartModelJson != null) {
                for (CartModel c : cartModels) {
                    if (c.getProductId() == cartModelJson.getProductId() && c.getSizeId() == cartModelJson.getSizeId()) {
                        cartModels.remove(c);
                        map.put("quantity", c.getQuantity());
                        break;
                    }
                }
                if(cartModels.size() == 0){
                    map.put("redirect", true);
                }
                session.setAttribute(cartSession, cartModels);
                map.put("status", true);
                return map;
            }
            return Collections.singletonMap("status", false);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return Collections.singletonMap("status", false);
        }
    }
}
