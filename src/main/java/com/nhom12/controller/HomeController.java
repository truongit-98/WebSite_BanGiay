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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.nhom12.Database.Models.*;
import org.springframework.ui.Model;
import com.nhom12.Database.dao.ProductDao;
import com.nhom12.Database.dao.SizeDao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private @Autowired
    ServletContext servletContext;
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
        if (page < 0) {
            page = 1;
        }
        ModelAndView mav = new ModelAndView("index");
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts(page - 1);
        int total = productDao.getAmountProducts("");
        int pageMax = total / 8;
        if (total % 8 != 0) {
            pageMax += 1;
        }
        model.addAttribute("products", products);
        model.addAttribute("valSearch", "");
        model.addAttribute("isSearch", 0);
        model.addAttribute("page", page);
        model.addAttribute("pageMax", pageMax);
        return mav;
    }

    @RequestMapping("/shop/product/{productID}")
    public ModelAndView productDetail(@PathVariable int productID, Model model) {
        ModelAndView mav = new ModelAndView("productDetail");
        ProductDao productDao = new ProductDao();
        Product product = productDao.getProduct(productID);
        model.addAttribute("product", product);
        return mav;
    }


    @RequestMapping(value = "/home/search", method = RequestMethod.GET, params = "txtSearch")
    @ResponseBody
    public ModelAndView getProductsSearch(@RequestParam String txtSearch, @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
        if (page < 0) {
            page = 1;
        }
        if (txtSearch.trim() == "") {
            return new ModelAndView("redirect:http://localhost:8080/WebSite_BanGiay/home?page=" + page);
        }
        ModelAndView mav = new ModelAndView("index");
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getProductsByKey(txtSearch, page - 1);
        long total = productDao.getAmountProducts(txtSearch);
        long pageMax = total / 8;
        if (total % 8 != 0) {
            pageMax += 1;
        }
        model.addAttribute("products", products);
        model.addAttribute("valSearch", txtSearch);
        model.addAttribute("isSearch", 1);
        model.addAttribute("page", page);
        model.addAttribute("pageMax", pageMax);
        return mav;
}
    @RequestMapping(value = "/home/loadDataDistrict", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map LoadDistrict(HttpServletRequest request) throws FileNotFoundException, IOException {
        String cityId = request.getParameter("city_ID");
        if (!cityId.isEmpty()) {
            InputStream inputStream = null;
            String fileName = "quan-huyen/" + cityId + ".json";
            String content = "";
            StringBuffer buf = new StringBuffer(); 
            Map map = new HashMap();
            try {
                inputStream = servletContext.getResourceAsStream("/resources/json/"+fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while((content = bufferedReader.readLine()) != null){
                    buf.append(content + "\n");
                }
                map.put("data", buf.toString());
                map.put("status", true);
                return map;

            } catch (Exception ex) {
                ex.printStackTrace();
                return Collections.singletonMap("status", false);
            } finally {
                if(inputStream != null){
                    inputStream.close();
                }
            }
        }
        return Collections.singletonMap("status", false);
    }
    
    @RequestMapping(value = "/home/loadDataWard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map LoadWard(HttpServletRequest request) throws FileNotFoundException, IOException {
        String wardId = request.getParameter("ward_ID");
        if (!wardId.isEmpty()) {
            InputStream inputStream = null;
            String fileName = "xa-phuong/" + wardId + ".json";
            String content = "";
            StringBuffer buf = new StringBuffer(); 
            Map map = new HashMap();
            try {
                inputStream = servletContext.getResourceAsStream("/resources/json/"+fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while((content = bufferedReader.readLine()) != null){
                    buf.append(content + "\n");
                }
                map.put("data", buf.toString());
                map.put("status", true);
                return map;

            } catch (Exception ex) {
                ex.printStackTrace();
                return Collections.singletonMap("status", false);
            } finally {
                if(inputStream != null){
                    inputStream.close();
                }
            }
        }
        return Collections.singletonMap("status", false);
    }
    
    @RequestMapping(value="/about", method=RequestMethod.GET)
    public ModelAndView aboutPage(){
        ModelAndView mav = new ModelAndView("about");
        return mav;
    }
    @RequestMapping(value="/contact", method=RequestMethod.GET)
    public ModelAndView contactPage(){
        ModelAndView mav = new ModelAndView("contact");
        return mav;
    }
    
    
}
