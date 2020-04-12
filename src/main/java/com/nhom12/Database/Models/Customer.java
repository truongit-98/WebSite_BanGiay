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
    
    public int getMaKH(){
        return MaKH;
    }
    public void setMaKH(int id){
        MaKH = id;
    }
    
    public String getTenKH(){
        return TenKH;
    }
    public void setTenKH(String name){
        TenKH = name;
    }
    public String getGioiTinh(){
        return GioiTinh;
    }
    public void setGioiTinh(String sex){
        GioiTinh = sex;
    }
    public String getDiaChi(){
        return DiaChi;
    }
    public void setDiaChi(String address){
        DiaChi = address;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String email){
        Email = email;
    }
    public String getMatKhau(){
        return MatKhau;
    }
    public void setMatKhau(String pass){
        MatKhau = pass;
    }
    public String getSDT(){
        return SDT;
    }
    public void setSDT(String SDT){
        this.SDT = SDT;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> listOrder = new HashSet<>();

}
