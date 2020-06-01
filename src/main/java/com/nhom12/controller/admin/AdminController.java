/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.controller.admin;

import com.nhom12.Database.Models.Product;
import com.nhom12.Database.Models.Staff;
import com.nhom12.Database.Models.Customer;
import com.nhom12.Database.dao.*;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Quang Vinh
 */
@Controller
//@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Index(HttpServletRequest request, Model model, HttpSession session) {
        ModelAndView mav = new ModelAndView("admin/login-admin");
        if (session.getAttribute("username") != null) {
            return new ModelAndView("redirect:/admin/home");
        }
        return mav;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView Login(HttpServletRequest request, Model model, HttpSession session) {
        String userName = request.getParameter("email");
        String pass = request.getParameter("password");
        StaffDao dao = new StaffDao();
        if (userName.isEmpty() || pass.isEmpty()) {
            model.addAttribute("errorMessage", "Tên đăng nhập và mật khẩu không thể để trống!");
            return new ModelAndView("login-admin");
        } else {
            Staff admin = dao.Login(userName, pass);
            if (admin == null) {
                model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng! Vui lòng nhập lại!");
                return new ModelAndView("admin/login-admin");
            }
            session.setAttribute("isLogin", true);
            session.setAttribute("username", userName);
            return new ModelAndView("redirect:/admin");
        }
    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession session) {
        session.removeAttribute("isLogin");
        session.removeAttribute("username");
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView Home(Model model) {
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts(0);
        model.addAttribute("products", products);
        return new ModelAndView("admin/home_admin");
    }

    //Danh sách nhân viên
    @RequestMapping(value = "/admin/staff", method = RequestMethod.GET)
    public ModelAndView AdminStaff(Model model) {
        StaffDao staffDao = new StaffDao();
        List<Staff> staffs = staffDao.getStaffs();
        model.addAttribute("staffs", staffs);
        return new ModelAndView("admin/staff_admin");
    }

    @RequestMapping("/admin/editStaff/{manv}")
    public ModelAndView AdminEditStaff(@PathVariable int manv, Model model) {
        ModelAndView mav = new ModelAndView("admin/staff_admin/edit_staff");
        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaffById(manv);
        model.addAttribute("staff", staff);
        return mav;
    }

    @RequestMapping(value = "/admin/editStaff", method = RequestMethod.POST)
    public ModelAndView AdminEditStaffPost(Staff s, HttpServletRequest request, Model model) {
        SimpleDateFormat formatNS = new SimpleDateFormat("yyyy-MMM-dd");
        Date dateNS = null;
        try {
            dateNS = formatNS.parse(request.getParameter("ngaysinh"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Staff staff = new Staff();
        staff.setManv(s.getManv());
        staff.setTennv(s.getTennv());
        staff.setEmail(s.getEmail());
        staff.setNgaySinh(dateNS);
        staff.setCmnd(s.getCmnd());
        staff.setMatkhau(s.getMatkhau());
        staff.setGioiTinh(s.getGioiTinh());
        staff.setDiaChi(s.getDiaChi());
        staff.setSdt(s.getSdt());

        StaffDao staffDao = new StaffDao();
        boolean result = staffDao.Update(staff);
        if (result) {
            return new ModelAndView("redirect:/admin/staff");
        }
        return new ModelAndView("redirect:admin/staff");
    }

    @RequestMapping(value = "/admin/addStaff", method = RequestMethod.GET)
    public ModelAndView AdminAddStaff(Model model) {
        return new ModelAndView("admin/staff_admin/add_staff");
    }

    @RequestMapping(value = "/admin/addStaff", method = RequestMethod.POST)
    public ModelAndView AdminAddStaffPost(Staff s, HttpServletRequest request, Model model) {
        Staff staff = new Staff();
        staff.setTennv(s.getTennv());
        staff.setDiaChi(s.getDiaChi());
        staff.setEmail(s.getEmail());
        staff.setGioiTinh(s.getGioiTinh());
        staff.setNgaySinh(s.getNgaySinh());
        staff.setCmnd(s.getCmnd());
        staff.setMatkhau(s.getMatkhau());

        StaffDao dao = new StaffDao();
        boolean result = dao.Save(staff);
        if (result) {
            return new ModelAndView("admin/staff_admin");
        }
        return new ModelAndView("admin/staff_admin/add_staff");
    }
    
    @RequestMapping("/admin/deleteStaff/{manv}")
    public ModelAndView AdminDeleteStaff(@PathVariable int manv, Model model) {
        ModelAndView mav = new ModelAndView("admin/customer_admin");
        StaffDao dao = new StaffDao();
        Staff staff = dao.getStaffById(manv);
        dao.Delete(staff);
        return mav;
    }

    //Danh sách khách hàng
    @RequestMapping(value = "/admin/customer", method = RequestMethod.GET)
    public ModelAndView AdminCustomer(Model model) {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getCustomers();
        model.addAttribute("customers", customers);
        return new ModelAndView("admin/customer_admin");
    }

    @RequestMapping("/admin/editCustomer/{maKH}")
    public ModelAndView AdminEditCustomer(@PathVariable int maKH, Model model) {
        ModelAndView mav = new ModelAndView("admin/customer_admin/edit_customer");
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(maKH);
        model.addAttribute("customer", customer);
        return mav;
    }

    @RequestMapping(value = "/admin/editCustomer", method = RequestMethod.POST)
    public ModelAndView AdminEditCustomerPost(Customer c, HttpServletRequest request, Model model) {
        Customer cust = new Customer();
        cust.setMaKH(c.getMaKH());
        cust.setTenKH(c.getTenKH());
        cust.setEmail(c.getEmail());
        cust.setMatKhau(c.getMatKhau());
        cust.setGioiTinh(c.getGioiTinh());
        cust.setDiaChi(c.getDiaChi());
        cust.setSdt(c.getSdt());

        CustomerDao dao = new CustomerDao();
        boolean result = dao.Update(cust);
        if (result) {
            return new ModelAndView("redirect:/admin/customer");
        }
        return new ModelAndView("redirect:/admin/customer");
    }

    @RequestMapping(value = "/admin/addCustomer", method = RequestMethod.GET)
    public ModelAndView AdminAddCustomer(Model model) {
        return new ModelAndView("admin/customer_admin/add_customer");
    }

    @RequestMapping(value = "/admin/addCustomer", method = RequestMethod.POST)
    public ModelAndView AdminAddCustomerPost(Customer c, HttpServletRequest request, Model model) {
        Customer cust = new Customer();
        cust.setTenKH(c.getTenKH());
        cust.setEmail(c.getEmail());
        cust.setMatKhau(c.getMatKhau());
        cust.setGioiTinh(c.getGioiTinh());
        cust.setDiaChi(c.getDiaChi());
        cust.setSdt(c.getSdt());

        CustomerDao dao = new CustomerDao();
        boolean result = dao.Save(cust);
        if (result) {
            return new ModelAndView("redirect:/admin/customer_admin");
        }
        return new ModelAndView("redirect:/admin/customer_admin/add_customer");
    }
    
    
    @RequestMapping("/admin/deleteCustomer/{maKH}")
    public ModelAndView AdminDeleteCustomer(@PathVariable int maKH, Model model) {
        ModelAndView mav = new ModelAndView("admin/customer_admin");
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(maKH);
        customerDao.Delete(customer);
        return mav;
    }
}
