/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="donhang")
public class Order {
    @Id
    private int MaDH;
    private Date NgayDat;
    private Date NgayGiao;
    private String DCGiao;
    private double TongTien;
    private String ThanhToan;
    private String TinhTrang;
    private String HoTen;
    private String Email;
    private String SDT;
    
    public int getMaDH(){
        return MaDH;
    }
    public void setMaDH(int id){
        MaDH = id;
    }
    public Date getNgayDat(){
        return NgayDat;
    }
    public void setNgayDat(Date date){
        NgayDat = date;
    }
    public Date getNgayGiao(){
        return NgayGiao;
    }
    public void setNgayGiao(Date date){
        NgayGiao = date;
    }
    public String getDCGiao(){
        return DCGiao;
    }
    public void setDCGiao(String address){
        DCGiao = address;
    }
    public double getTongTien(){
        return TongTien;
    }
    public void setTongTien(double total){
        TongTien = total;
    }        
    public String getThanhToan(){
        return ThanhToan;
    }
    public void setThanhToan(String thanhToan){
        ThanhToan = thanhToan;
    }
    public String getTinhTrang(){
        return TinhTrang;
    }
    public void setTinhTrang(String tinhTrang){
        TinhTrang = tinhTrang;
    }
    public String getHoTen(){
        return HoTen;
    }
    public void setHoTen(String fullName){
        HoTen = fullName;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String email){
        Email = email;
    }
    public String getSDT(){
        return SDT;
    }    
    public void setSDT(String sdt){
        SDT = sdt;
    }
    
    @OneToMany(mappedBy = "order")
    Set<OrderDetail> listOrderDetail;
    
    @ManyToOne
    @JoinColumn(name = "MaKH")
    private Customer customer;

    public Customer getCustomer() {
            return customer;
    }

    public void setCustomer(Customer customer) {
            this.customer = customer;
    }
    
    @ManyToOne
    @JoinColumn(name = "MaNV")
    private Staff staff;

    public Staff getStaff() {
            return staff;
    }

    public void setStaff(Staff staff) {
            this.staff = staff;
    }
}
