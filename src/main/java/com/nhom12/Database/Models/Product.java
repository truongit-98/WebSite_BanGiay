/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Truong98
 */
@Entity
@Table(name="sanpham")
public class Product {
    
    private Integer masp;
    private String tensp;
    private int soluongtong;
    private double dongia;
    private String mota;
    private Date ngaycapnhat;
    private String anh;
    private String anh2;
    private String anh3;
    private Integer mansx;
    
    @Id
    @Column(name="MaSP")
    public Integer getMasp(){
        return masp;
    }
    public void setMasp(Integer id){
        masp = id;
    }
    
    @Column(name="TenSP")
    public String getTensp(){
        return tensp;
    }
    public void setTensp(String name){
        tensp = name;
    }
    
    @Column(name="SoLuongTong")
    public int getSoluongtong(){
        return soluongtong;
    }
    public void setSoluongtong(int soluong){
        soluongtong = soluong;
    }
    
    @Column(name="DonGia")
    public Double getDongia(){
        return dongia;
    }
    public void setDongia(Double gia){
        dongia = gia;
    }
    
    @Column(name="MoTa")
     public String getMota(){
        return mota;
    }
    public void setMota(String str){
        mota = str;
    }
    
    @Column(name="NgayCapNhat")
     public Date getNgaycapnhat(){
        return ngaycapnhat;
    }
    public void setNgaycapnhat(Date date){
        ngaycapnhat = date;
    }
    
    @Column(name="Anh")
     public String getAnh(){
        return anh;
    }
    public void setAnh(String url){
        anh = url;
    }
    
   @Column(name="Anh2")
     public String getAnh2(){
        return anh2;
    }
    public void setAnh2(String url){
        anh2 = url;
    }

    @Column(name="Anh3")
     public String getAnh3(){
        return anh3;
    }
    public void setAnh3(String url){
        anh3 = url;
    }
    
    @Column(name="MaNSX")
     public Integer getMansx(){
        return mansx;
    }
    public void setMansx(Integer maNSX){
        this.mansx = maNSX;
    }
}
