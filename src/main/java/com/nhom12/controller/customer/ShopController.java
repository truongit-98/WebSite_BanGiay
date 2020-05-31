/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller.customer;

import com.nhom12.Database.Models.Producer;
import com.nhom12.Database.Models.Product;
import com.nhom12.Database.Models.Size;
import com.nhom12.Database.dao.ProducerDao;
import com.nhom12.Database.dao.ProductDao;
import com.nhom12.Database.dao.SizeDao;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import static javax.swing.JOptionPane.showMessageDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ThongPVT
 */
@Controller
public class ShopController {

    private @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/shop/{sex}", method = RequestMethod.GET)
    public ModelAndView shopPage(@PathVariable String sex, @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
        if (page < 0) {
            page = 1;
        }
        String typeSex = "women";
        if (sex.equals(typeSex)) {
            typeSex = "nu";

        } else {
            typeSex = "nam";
        }
        ModelAndView mav = new ModelAndView("shop");
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getShopProducts(page - 1, typeSex, "");

        String filter = " where e.gioitinh= '" + typeSex + "'";
        int total = productDao.getAmountProductsSearch(filter);
        int pageMax = total / 8;
        if (total % 8 != 0) {
            pageMax += 1;
        }
        ProducerDao producerDao = new ProducerDao();
        List<Producer> producers = producerDao.getProducers();

        SizeDao sizeDao = new SizeDao();
        List<Size> sizes = sizeDao.getAllSizes();

        model.addAttribute("products", products);
        model.addAttribute("valSearch", "");
        model.addAttribute("isSearch", 0);
        model.addAttribute("page", page);
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("producers", producers);
        model.addAttribute("mansx", 0);
        model.addAttribute("sizes", sizes);
        model.addAttribute("masize", 0);
        return mav;
    }

    @RequestMapping(value = "/shop/men", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModelAndView getProductsSearchMen(HttpServletRequest request, Model model) {
        int mansx = 0;
        int gia = 0;
        int size = 0;
        int page = 1;
        String urlPost = "http://localhost:8080/WebSite_BanGiay/shop/men";
        if (request.getParameter("mansx") != null && request.getParameter("mansx") != "") {
            mansx = Integer.parseInt(request.getParameter("mansx"));
        }
        if (request.getParameter("gia") != null && request.getParameter("gia") != "") {
            gia = Integer.parseInt(request.getParameter("gia"));
        }

        if (request.getParameter("size") != null && request.getParameter("size") != "") {
            size = Integer.parseInt(request.getParameter("size"));
        }

        if (request.getParameter("page") != null && request.getParameter("page") != "") {
            page = Integer.parseInt(request.getParameter("page"));
        }
//        int page = Integer.parseInt(request.getParameter("page"));
        if (page < 0) {
            page = 1;
        }
        String filter = " e.gioitinh= 'nam'";
        String hql = "";
        //hãng sản xuất
        if (mansx > 0) {
            if (filter != "") {
                filter += " and ";
            }
            filter += " e.mansx = " + mansx;
        }
        //giá
        if (gia > 0) {
            if (filter != "") {
                filter += " and ";
            }
            if (gia != 10) {
                filter += " e.dongia > " + (gia - 2) * 1000000 + " and e.dongia < " + gia * 1000000;
            } else {
                filter += " e.dongia e.dongia > 10000000";
            }

        }

        if (size > 0) {
            hql = "select e from Product e JOIN SanphamSize sps " + " on e.masp=sps.id.maSP and " + filter + " and sps.id.masize='" + size + "'";
        } else {
            hql = "select e from Product e where " + filter;
        }
        filter = " where " + filter;
        ModelAndView mav = new ModelAndView("shop");
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getShopProductsSearch(page - 1, hql);
        long total = productDao.getAmountProductsSearch(filter);
        long pageMax = total / 8;
        if (total % 8 != 0) {
            pageMax += 1;
        }
        ProducerDao producerDao = new ProducerDao();
        List<Producer> producers = producerDao.getProducers();

        SizeDao sizeDao = new SizeDao();
        List<Size> sizes = sizeDao.getAllSizes();

        model.addAttribute("products", products);
        model.addAttribute("page", page);
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("producers", producers);
        model.addAttribute("mansx", mansx);
        model.addAttribute("gia", gia);
        model.addAttribute("sizes", sizes);
        model.addAttribute("masize", size);
        model.addAttribute("urlPost", urlPost);
        return mav;
    }

    @RequestMapping(value = "/shop/women", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModelAndView getProductsSearchWomen(HttpServletRequest request, Model model) {
        int mansx = 0;
        int gia = 0;
        int size = 0;
        int page = 1;
        String urlPost = "http://localhost:8080/WebSite_BanGiay/shop/women";
        if (request.getParameter("mansx") != null && request.getParameter("mansx") != "") {
            mansx = Integer.parseInt(request.getParameter("mansx"));
        }
        if (request.getParameter("gia") != null && request.getParameter("gia") != "") {
            gia = Integer.parseInt(request.getParameter("gia"));
        }

        if (request.getParameter("size") != null && request.getParameter("size") != "") {
            size = Integer.parseInt(request.getParameter("size"));
        }

        if (request.getParameter("page") != null && request.getParameter("page") != "") {
            page = Integer.parseInt(request.getParameter("page"));
        }
//        int page = Integer.parseInt(request.getParameter("page"));
        if (page < 0) {
            page = 1;
        }
        String filter = " e.gioitinh= 'nu'";
        String hql = "";
        //hãng sản xuất
        if (mansx > 0) {
            if (filter != "") {
                filter += " and ";
            }
            filter += " e.mansx = " + mansx;
        }
        //giá
        if (gia > 0) {
            if (filter != "") {
                filter += " and ";
            }
            if (gia != 10) {
                filter += " e.dongia > " + (gia - 2) * 1000000 + " and e.dongia < " + gia * 1000000;
            } else {
                filter += " e.dongia e.dongia > 10000000";
            }

        }

        if (size > 0) {
            hql = "select e from Product e JOIN SanphamSize sps " + " on e.masp=sps.id.maSP and " + filter + " and sps.id.masize='" + size + "'";
        } else {
            hql = "select e from Product e where " + filter;
        }
        filter = " where " + filter;
        ModelAndView mav = new ModelAndView("shop");
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getShopProductsSearch(page - 1, hql);
        long total = productDao.getAmountProductsSearch(filter);
        long pageMax = total / 8;
        if (total % 8 != 0) {
            pageMax += 1;
        }
        ProducerDao producerDao = new ProducerDao();
        List<Producer> producers = producerDao.getProducers();

        SizeDao sizeDao = new SizeDao();
        List<Size> sizes = sizeDao.getAllSizes();

        model.addAttribute("products", products);
        model.addAttribute("page", page);
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("producers", producers);
        model.addAttribute("mansx", mansx);
        model.addAttribute("gia", gia);
        model.addAttribute("sizes", sizes);
        model.addAttribute("masize", size);
        model.addAttribute("urlPost", urlPost);
        return mav;
    }
}
