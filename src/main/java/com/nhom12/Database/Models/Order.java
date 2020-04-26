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
    private Date ngayDat;
    private Date ngayGiao;
    private String dcGiao;
    private double tongTien;
    private String thanhToan;
    private String tinhTrang;
    private String hoTen;
    private String email;
    private String sdt;
    
    public int getMaDH(){
        return maDH;
    }
    public void setMaDH(int id){
        maDH = id;
    }
    @Column(name="NgayDat")
    public Date getNgayDat(){
        return ngayDat;
    }
    public void setNgayDat(Date date){
        ngayDat = date;
    }
    @Column(name="NgayGiao")
    public Date getNgayGiao(){
        return ngayGiao;
    }
    public void setNgayGiao(Date date){
        ngayGiao = date;
    }
    @Column(name="DCGiao")
    public String getDcGiao(){
        return dcGiao;
    }
    public void setDcGiao(String address){
        dcGiao = address;
    }
    @Column(name="TongTien")
    public double getTongTien(){
        return tongTien;
    }
    public void setTongTien(double total){
        tongTien = total;
    }
    @Column(name="ThanhToan")
    public String getThanhToan(){
        return thanhToan;
    }
    public void setThanhToan(String thanhToan){
        this.thanhToan = thanhToan;
    }
    @Column(name="TinhTrang")
    public String getTinhTrang(){
        return tinhTrang;
    }
    public void setTinhTrang(String tinhTrang){
        this.tinhTrang = tinhTrang;
    }
    
    @Column(name="HoTen")
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String fullName){
        hoTen = fullName;
    }
    
    @Column(name="Email")
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    @Column(name="SDT")
    public String getSdt(){
        return sdt;
    }    
    public void setSdt(String sdt){
        this.sdt = sdt;
    }
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
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
