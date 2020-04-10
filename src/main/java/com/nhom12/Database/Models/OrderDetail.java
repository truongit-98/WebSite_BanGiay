/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import javax.persistence.*;
/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="chitiethoadon")
public class OrderDetail {
//    @Id
//    private int MaDH;
//    @Id
//    private int MaSP;
    @EmbeddedId
    OrderProductKey id;
    private int SoLuong;
    private Double DonGia;
    private int MaSize;
    private int MaMau;
    
    @ManyToOne
    @MapsId("MaDH")
    @JoinColumn(name = "MaDH")
    Order order;
 
    @ManyToOne
    @MapsId("MaSP")
    @JoinColumn(name = "MaSP")
    Product product;
    
    @ManyToOne
    @JoinColumn(name = "MaMau")
    private Color color;

    public Color getColor() {
            return color;
    }

    public void setColor(Color color) {
            this.color = color;
    }
    
    @ManyToOne
    @JoinColumn(name = "MaSize")
    private Size size;

    public Size getSize() {
            return size;
    }

    public void setSize(Size size) {
            this.size = size;
    }
}
