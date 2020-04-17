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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(Model model) {

        ModelAndView mav = new ModelAndView("index");
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return mav;
    }

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @RequestMapping("/home/{productID}")
    public ModelAndView productDetail(@PathVariable("productID") int productID, Model model) {
        ModelAndView mav = new ModelAndView("productDetail");
        ProductDao productDao = new ProductDao();
        Product product = productDao.getProduct(productID);
        SizeDao sizeDao = new SizeDao();
        List<Size> sizes = sizeDao.getAllSizes();
        model.addAttribute("product", product);
        model.addAttribute("sizes", sizes);
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
}
