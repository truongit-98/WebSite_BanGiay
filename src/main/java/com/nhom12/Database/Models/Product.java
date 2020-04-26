/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
/**
 * @author Truong98
 */
@Entity
@Table(name="sanpham")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int masp;
    @Column(name = "TenSP")
    private String tensp;
    @Column(name = "SoLuongTong")
    private int soluongtong;
    @Column(name = "DonGia")
    private double dongia;
    @Column(name = "MoTa")
    private String mota;
    @Column(name = "NgayCapNhat")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaycapnhat;
    @Column(name = "Anh")
    private String anh;
    @Column(name = "Anh2")
    private String anh2;
    @Column(name = "Anh3")
    private String anh3;
    @Column(name = "MaNSX")
    private int mansx;
    
    public Product(){
        
    }
   
    @OneToMany(mappedBy = "product")
    Set<OrderDetail> listOrderDetail;
    
    @ManyToOne
    @JoinColumn(name = "mansx")
    private Producer producer; 

    public Producer getProducer() {
            return producer;
    }

    public void setProducer(Producer producer) {
            this.producer = producer;
    }
    
    public int getMasp(){
        return masp;
    }
    public void setMasp(Integer id){
        masp = id;
    }
    
    public String getTensp(){
        return tensp;
    }
    public void setTensp(String name){
        tensp = name;
    }
    
    public int getSoluongtong(){
        return soluongtong;
    }
    public void setSoluongtong(int soluong){
        soluongtong = soluong;
    }
    
    public double getDongia(){
        return dongia;
    }
    public void setDongia(double gia){
        dongia = gia;
    }
    
     public String getMota(){
        return mota;
    }
    public void setMota(String str){
        mota = str;
    }
    
     public Date getNgaycapnhat(){
        return ngaycapnhat;
    }
    public void setNgaycapnhat(Date date){
        ngaycapnhat = date;
    }
    
     public String getAnh(){
        return anh;
    }
    public void setAnh(String url){
        anh = url;
    }
    
     public String getAnh2(){
        return anh2;
    }
    public void setAnh2(String url){
        anh2 = url;
    }

     public String getAnh3(){
        return anh3;
    }
    public void setAnh3(String url){
        anh3 = url;
    }
    
     public int getMansx(){
        return mansx;
    }
    public void setMansx(Integer maNSX){
        this.mansx = maNSX;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @OrderBy("masize asc")
    Set<SanphamSize> listSanPhamSize = new HashSet<SanphamSize>();
    public Set<SanphamSize> getListSanPhamSize(){
        return listSanPhamSize;
    }
    public void setListSanPhamSize(Set<SanphamSize> sets){
        listSanPhamSize = sets;
    }
}
