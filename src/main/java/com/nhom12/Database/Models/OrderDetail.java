/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="chitiethd")
public class OrderDetail implements Serializable {

    @EmbeddedId
    OrderProductKey id;
    private int soluong;
    private double gia;
    
    public OrderProductKey getId(){
        return id;
    }
    public void setOrderProductKey(OrderProductKey key){
        id = key;
    }
    
    public int getSoluong(){
        return soluong;
    }
    public void setSoluong(int soLuong){
        this.soluong = soLuong;
    }
    
    public double getGia(){
        return gia;
    }
    public void setGia(double price){
        gia = price;
    }
    
    
    @ManyToOne
    @MapsId("MaDH")
    @JoinColumn(name = "MaDH")
    Order order;
    public Order getOrder(){
        return order;
    }
    
    @ManyToOne
    @MapsId("MaSP")
    @JoinColumn(name = "MaSP")
    Product product;   
    public Product getProduct(){
        return product;
    }
    @ManyToOne
    @MapsId("MaSize")
    @JoinColumn(name = "MaSize")
    Size size;   
    public Size getSize(){
        return size;
    }
}
