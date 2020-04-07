/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.WebSite_BanGiay.controller;

/**
 *
 * @author Truong98
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.SessionFactory;
import com.Nhom12.Database.Models.*;
import com.Nhom12.Database.HibernateUtil;
import java.util.List;


@Controller
public class HomeController {
  
   @RequestMapping(value = "/home", method = RequestMethod.GET)
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("index");
//      StudentDao studentDao = new StudentDao();
//      Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
//      studentDao.saveStudent(student);
//      List<Student>students = studentDao.getStudents();
      SessionFactory factory = HibernateUtil.getSessionFactory();
      return mav;
   }
  
}