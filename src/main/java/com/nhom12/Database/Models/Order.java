/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="donhang")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDH;
    @Column(name="NgayDat")
    private Date ngayDat;
    @Column(name="NgayGiao")
    private Date ngayGiao;
    @Column(name="DCGiao")
    private String dcGiao;
    @Column(name="TongTien")
    private double tongTien;
    @Column(name="ThanhToan")
    private String thanhToan;
    @Column(name="TinhTrang")
    private String tinhTrang;
    @Column(name="HoTen")
    private String hoTen;
    @Column(name="Email")
    private String email;
    @Column(name="SDT")
    private String sdt;
    public int getMaDH(){
        return maDH;
    }
    public void setMaDH(int id){
        maDH = id;
    }
    public Date getNgayDat(){
        return ngayDat;
    }
    public void setNgayDat(Date date){
        ngayDat = date;
    }
    public Date getNgayGiao(){
        return ngayGiao;
    }
    public void setNgayGiao(Date date){
        ngayGiao = date;
    }
    public String getDcGiao(){
        return dcGiao;
    }
    public void setDcGiao(String address){
        dcGiao = address;
    }
    public double getTongTien(){
        return tongTien;
    }
    public void setTongTien(double total){
        tongTien = total;
    }
    public String getThanhToan(){
        return thanhToan;
    }
    public void setThanhToan(String thanhToan){
        this.thanhToan = thanhToan;
    }
    public String getTinhTrang(){
        return tinhTrang;
    }
    public void setTinhTrang(String tinhTrang){
        this.tinhTrang = tinhTrang;
    }
    
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String fullName){
        hoTen = fullName;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSdt(){
        return sdt;
    }    
    public void setSdt(String sdt){
        this.sdt = sdt;
    }
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<OrderDetail> listOrderDetail = new HashSet<OrderDetail>();
    public Set<OrderDetail> getListOrderDetail(){
        return listOrderDetail;
    }
    public void setListOrderDetail(Set<OrderDetail> sets){
        listOrderDetail = sets;
    }
    
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
