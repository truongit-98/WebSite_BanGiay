/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="khachhang")
public class Customer implements Serializable {
    @Id
    private int maKH;
    @NotNull
    @Size(min=16, message="Họ và tên phải có ít nhất 16 ký tự!")
    private String tenKH;
    @NotNull(message="Không thể để trống giới tính!")
    private String gioiTinh;
    private String diaChi;
    @NotNull(message="Không thể để trống email!")
    @Email(message="Định dạng email không hợp lệ!")
    private String email;
    @NotNull
    @Size(min=10, max=10, message="Số điện thoại phải có đúng 10 ký tự!")
    private String sdt;
    @NotNull
    @Size(min=12, max=16, message="Mật khẩu phải có ít nhất từ 12-16 ký tự!")
    private String matKhau;
    
    public int getMaKH(){
        return maKH;
    }
    public void setMaKH(int id){
        maKH = id;
    }
    
    public String getTenKH(){
        return tenKH;
    }
    public void setTenKH(String name){
        tenKH = name;
    }
    public String getGioiTinh(){
        return gioiTinh;
    }
    public void setGioiTinh(String sex){
        gioiTinh = sex;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public void setDiaChi(String address){
        diaChi = address;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getMatKhau(){
        return matKhau;
    }
    public void setMatKhau(String pass){
        matKhau = pass;
    }
    public String getSdt(){
        return sdt;
    }
    public void setSdt(String SDT){
        this.sdt = SDT;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> listOrder = new HashSet<>();

}
