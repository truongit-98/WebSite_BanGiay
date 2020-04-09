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
import java.util.List;
/**
 *
 * @author Truong98
 */
@Controller
@EnableWebMvc
public class CartController {
    
    @RequestMapping(value = "/cart", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> addProduct(HttpServletRequest request){
        String id = request.getParameter("productId");
        ProductDao dao = new ProductDao();
        List<Product> lstProduct = dao.getAllProducts();
        return lstProduct;
    }
//    @RequestMapping(value = "/json", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map add2(){
//        return Collections.singletonMap("status", "true");
//    }
}
