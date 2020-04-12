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
@Table(name = "nhanvien")
public class Staff {

    @Id
    private int manv;
    @Column(name = "TenNV")
    private String tennv;
    @Column(name = "DiaChi")
    private String diachi;
    @Column(name = "Email")
    private String email;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "GioiTinh")
    private String gioitinh;
    @Column(name = "NgaySinh")
    private Date ngaysinh;
    @Column(name = "CMND")
    private String cmnd;
    @Column(name = "MatKhau")
    private String matkhau;
    @Column(name = "QuyenNV")
    private char quyennv;

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        tennv = tennv;
    }

    public String getDiaChi() {
        return diachi;
    }

    public void setDiaChi(String diachi) {
        diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        sdt = sdt;
    }

    public String getGioiTinh() {
        return gioitinh;
    }

    public void setGioiTinh(String gioitinh) {
        gioitinh = gioitinh;
    }

    public Date getNgaySinh() {
        return ngaysinh;
    }

    public void setNgaySinh(Date ngaysinh) {
        ngaysinh = ngaysinh;
    }

    public String getCMND() {
        return cmnd;
    }

    public void setCMND(String cmnd) {
        cmnd = cmnd;
    }

    public String getMatKhau() {
        return matkhau;
    }

    public void setMatKhau(String matkhau) {
        matkhau = matkhau;
    }
    
    public char getQuyenNV() {
        return quyennv;
    }

    public void setQuyenNV(char quyennv) {
        quyennv = quyennv;
    }
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
//    private Set<BillImport> listBillImport = new HashSet<>();
//    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
//    private Set<Order> listOrder = new HashSet<>();
}
