/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="nhanvien")
public class Staff {
    @Id
    private int MaNV;
    private String TenNV;
    private String DiaChi;
    private String Email;
    private String Sdt;
    private String GioiTinh;
    private Date NgaySinh;
    private String CMND;
    private String MatKhau;
    private char QuyenNV;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    private Set<BillImport> listBillImport = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    private Set<Order> listOrder = new HashSet<>();
}
