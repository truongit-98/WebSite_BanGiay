/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller.customer;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nhom12.Database.Models.CartModel;
import com.nhom12.Database.Models.Customer;
import com.nhom12.Database.Models.Order;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.nhom12.Database.Models.UserCookie;
import com.nhom12.Database.dao.CustomerDao;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.nhom12.Database.dao.OrderDao;
import com.nhom12.services.HandleAddress;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Truong98
 */
@Controller
public class CustomerController {

    private static final String COOKIEUSER = "cookieUser";
    private String referer = "";
    private @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        referer = request.getHeader("referer");
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(COOKIEUSER)) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    try {
                        UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                        CustomerDao dao = new CustomerDao();
                        if (cookie != null && dao.FindById(cookie.getId())) {
                            return new ModelAndView("redirect:/home");
                        }

                    } catch (JsonSyntaxException | UnsupportedEncodingException ex) {
                        ex.printStackTrace();
                        Cookie cok = new Cookie(COOKIEUSER, null);
                        cok.setPath("/");
                        cok.setMaxAge(0);
                        cok.setDomain("localhost");
                        cok.setHttpOnly(true);
                        response.addCookie(cok);
                        return new ModelAndView("customer/login");
                    }

                }
            }
        }
        return new ModelAndView("customer/login");
    }

    @RequestMapping(value = "/customer/login", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Login(HttpServletRequest request, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        String userName = request.getParameter("email");
        String pass = request.getParameter("password");
        CustomerDao dao = new CustomerDao();

        if (userName.isEmpty() || pass.isEmpty()) {
            model.addAttribute("errorMessage", "Tên đăng nhập và mật khẩu không thể để trống!");
            return new ModelAndView("customer/login");
        } else {
            Customer cust = dao.Login(userName, pass);
            if (cust == null) {
                model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng! Vui lòng nhập lại!");
                return new ModelAndView("customer/login");
            }
            UserCookie user = new UserCookie();
            user.setId(cust.getMaKH());
            user.setFullName(cust.getTenKH());
            String json = new Gson().toJson(user);
            Cookie cookie = new Cookie(COOKIEUSER, URLEncoder.encode(json, "UTF-8"));
            cookie.setMaxAge(24 * 60 * 60);
            cookie.setPath("/");
            cookie.setDomain("localhost");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            if (referer != null) {
                if (referer.matches("login") || referer.matches("register")) {
                    return new ModelAndView("redirect:/home");
                }
                return new ModelAndView("redirect:" + referer);
            }
            return new ModelAndView("redirect:/home");
        }
    }

    @RequestMapping(value = "/customer/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(COOKIEUSER, null);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/customer/register", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Register(Model model) {
        ModelAndView mav = new ModelAndView("customer/register");
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
            return new ModelAndView("customer/register");
        }
        if (dao.getCustomerByEmail(c.getEmail()) != null) {
            model.addAttribute("errorMessage", "Email đã được dùng! Vui lòng sử dụng email khác!");
            return new ModelAndView("customer/register");
        }
        Customer cust = new Customer();
        cust.setTenKH(c.getTenKH());
        cust.setEmail(c.getEmail());
        cust.setMatKhau(c.getMatKhau());
        cust.setGioiTinh(c.getGioiTinh());
        cust.setSdt(c.getSdt());
        String address = detailAddress + ", ";
        address += HandleAddress.handleAddress(servletContext, cityId, districtId, wardId);
        cust.setDiaChi(address);
        boolean result = dao.Save(cust);
        if (result) {
            return new ModelAndView("customer/login");
        }
        return new ModelAndView("customer/register");
    }

    @RequestMapping(value = "/customer/checkout", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Checkout(HttpSession session, Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "false") String edit, @RequestParam(required = false, defaultValue = "true") String isDefault) throws UnsupportedEncodingException {
        List<CartModel> cartModels = (List<CartModel>) session.getAttribute("cartSession");
        if (cartModels == null || cartModels.size() == 0) {
            return new ModelAndView("redirect:/home");
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(COOKIEUSER)) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                    CustomerDao dao = new CustomerDao();
                    String address= "";
                    if (cookie != null && dao.FindById(cookie.getId())) {
                        model.addAttribute("isEdit", edit);
                        model.addAttribute("customer", dao.getCustomerById(cookie.getId()));
                        if(session.getAttribute("shippingAddress") != null && isDefault.equals("false")){
                             model.addAttribute("shippingAddress", session.getAttribute("shippingAddress").toString());
                        } else {
                             model.addAttribute("shippingAddress", "");
                        }
                        long total = 0;
                        for (CartModel c1 : cartModels) {
                            total += c1.getPrice() * c1.getQuantity();
                        }
                        model.addAttribute("total", total);
                        return new ModelAndView("customer/checkout");
                    }
                }
            }
            return new ModelAndView("redirect:/customer");
        }
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/customer/checkout", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView OrderComplete(HttpSession session, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        List<CartModel> cartModels = (List<CartModel>) session.getAttribute("cartSession");
        String thanhtoan = request.getParameter("payment");
        if (cartModels == null || cartModels.size() == 0) {
            return new ModelAndView("redirect:/home");
        }
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return new ModelAndView("redirect:/customer");
        } else {
            for (Cookie c : cookies) {
                if (c.getName().equals(COOKIEUSER)) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                    CustomerDao custDao = new CustomerDao();
                    if (cookie != null && custDao.FindById(cookie.getId())) {
                        double total = 0;
                        for (CartModel ca : cartModels) {
                            total = ca.getPrice() * ca.getQuantity();
                        }
                        OrderDao orderDao = new OrderDao();
                        Customer cust = custDao.getCustomerById(cookie.getId());
                        Order order = new Order();
                        order.setCustomer(cust);
                        order.setNgayDat(new Date());
                        if(session.getAttribute("shippingAddress") != null && !session.getAttribute("shippingAddress").toString().isEmpty()){
                            order.setDcGiao(session.getAttribute("shippingAddress").toString());
                        } else {
                            order.setDcGiao(cust.getDiaChi());
                        }
                        order.setEmail(cust.getEmail());
                        order.setHoTen(cust.getTenKH());
                        order.setSdt(cust.getSdt());
                        order.setTongTien(total);
                        order.setTinhTrang("Đang được xử lý");
                        order.setThanhToan(thanhtoan);
                        boolean result = orderDao.Save(cartModels, order);
                        if (result) {
                            session.removeAttribute("cartSession");
                            session.removeAttribute("shippingAddress");
                            return new ModelAndView("orderComplete");
                        }
                    }
                    return new ModelAndView("redirect:/cart");
                }
            }
            return new ModelAndView("redirect:/customer");
        }
    }

    @RequestMapping(value = "/customer/edit", method = RequestMethod.GET)
    public ModelAndView editAccount(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(COOKIEUSER)) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                    CustomerDao custDao = new CustomerDao();
                    if (cookie != null) {
                        Customer cust = custDao.getCustomerById(cookie.getId());
                        if (cust != null) {
                            model.addAttribute("customer", cust);
                            return new ModelAndView("customer/accountInfo");
                        }
                    }
                }
            }
        }
        return new ModelAndView("redirect:/customer");
    }

    @RequestMapping(value = "/customer/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModelAndView editAccountPost(HttpServletRequest request, Model model) {
        String email = request.getParameter("Email");
        String fullName = request.getParameter("FullName");
        String passWord = request.getParameter("PassWord");
        String newPass = request.getParameter("NewPassWord");
        String confirmPass = request.getParameter("ConfirmPass");
        CustomerDao dao = new CustomerDao();
        String errorMessage = "";
        int lenght = fullName.length();
        model.addAttribute("customer", dao.getCustomerByEmail(email));
        if (fullName.length() < 10) {
            model.addAttribute("errorMessage", "Họ tên phải có ít nhất 10 ký tự!!!");
        } else if (!passWord.isEmpty() || !newPass.isEmpty() || !confirmPass.isEmpty()) {
            if (passWord.length() < 8 || passWord.length() > 16 || newPass.length() < 8 || newPass.length() > 16 || confirmPass.length() < 8 || confirmPass.length() > 16) {
                model.addAttribute("errorMessage", "Mật khẩu phải có ít nhất 8-16 ký tự!!!");
            } else if (dao.Login(email, passWord) == null) {
                model.addAttribute("errorMessage", "Mật khẩu không chính xác!!!");
            } else if (newPass.equals(passWord)) {
                model.addAttribute("errorMessage", "Mật khẩu mới không thể trùng mật khẩu cũ !!!");
            } else if (!newPass.equals(confirmPass)) {
                model.addAttribute("errorMessage", "Xác nhận mật khẩu không chính xác !!!");
            } else {
                Customer cust = dao.getCustomerByEmail(email);
                cust.setTenKH(fullName);
                cust.setMatKhau(newPass);
                boolean result = dao.Update(cust);
                if (!result) {
                    model.addAttribute("errorMessage", "Không thể cập nhật thông tin tài khoản !!!");
                    return new ModelAndView("customer/accountInfo");
                } else {
                    model.addAttribute("success", "Cập nhật thông tin tài khoản thành công");
                    return new ModelAndView("customer/accountInfo");
                }
            }
            return new ModelAndView("customer/accountInfo");
        }
        Customer cust = dao.getCustomerByEmail(email);
        cust.setTenKH(fullName);
        boolean result = true;
        if (!result) {
            model.addAttribute("errorMessage", "Không thể cập nhật thông tin tài khoản !!!");
            return new ModelAndView("customer/accountInfo");
        } else {
            model.addAttribute("success", "Cập nhật thông tin tài khoản thành công");
            return new ModelAndView("customer/accountInfo");
        }

    }

    @RequestMapping(value = "/customer/address", method = RequestMethod.GET)
    public ModelAndView accountAddress(HttpServletRequest request, Model model, @RequestParam(required = false, defaultValue = "false") String edit) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(COOKIEUSER)) {
                    Type type = new TypeToken<UserCookie>() {
                    }.getType();
                    UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                    if (cookie != null && (edit.equals("false") || edit.equals("true"))) {
                        model.addAttribute("isEdit", edit);
                        model.addAttribute("customer", new CustomerDao().getCustomerById(cookie.getId()));
                        return new ModelAndView("customer/addressInfo");
                    }
                }
            }
        }
        return new ModelAndView("redirect:/customer");
    }

    @RequestMapping(value = "/customer/address", method = RequestMethod.POST)
    public ModelAndView editAddress(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException, IOException {

        Customer cust = new Customer();
        CustomerDao dao = new CustomerDao();
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(COOKIEUSER)) {
                Type type = new TypeToken<UserCookie>() {
                }.getType();
                UserCookie cookie = new Gson().fromJson(URLDecoder.decode(c.getValue(), "UTF-8"), type);
                cust = dao.getCustomerById(cookie.getId());
            }
        }
        String cityId = request.getParameter("city");
        String districtId = request.getParameter("district");
        String wardId = request.getParameter("ward");
        String detailAddress = request.getParameter("detailAddress");

        String address = detailAddress + ", ";

        try {
            address += HandleAddress.handleAddress(servletContext, cityId, districtId, wardId);
            cust.setDiaChi(address);
            boolean result = dao.Update(cust);
            if (result) {
                redirectAttributes.addFlashAttribute("successMessage", "Cập nhật thành công!!!");
                return new ModelAndView("redirect:/customer/address");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        redirectAttributes.addFlashAttribute("errorMessage", "Cập nhật không thành công!");
        return new ModelAndView("redirect:/customer/address?edit=true");
    }
}
