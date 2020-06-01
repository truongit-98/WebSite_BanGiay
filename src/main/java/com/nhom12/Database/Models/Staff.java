/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;

import java.io.Serializable;
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
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manv;
    @Column(name = "TenNV")
    private String tennv;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Email")
    private String email;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "CMND")
    private String cmnd;
    @Column(name = "MatKhau")
    private String matkhau;

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diachi) {
        this.diaChi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioitinh) {
        this.gioiTinh = gioitinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaysinh) {
        this.ngaySinh = ngaysinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    private Set<Order> listOrder = new HashSet<>();
}
