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
    private int MaKH;
    private int MaNV;
    private Date NgayDat;
    private Date NgayGiao;
    private String DCGiao;
    private double TongTien;
    private String ThanhToan;
    private String TinhTrang;
    private String HoTen;
    private String Email;
    private String SDT;
    
//    @OneToMany(mappedBy = "order")
//    Set<OrderDetail> listOrderDetail;
    
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
