/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="khachhang")
public class Customer {
    @Id
    private int MaKH;
    private String TenKH;
    private String GioiTinh;
    private String DiaChi;
    private String Email;
    private String SDT;
    private String MatKhau;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> listOrder = new HashSet<>();
}
