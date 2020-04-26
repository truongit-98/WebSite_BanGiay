/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Truong98
 */
@Entity
@Table(name="sanpham_size")
public class SanphamSize implements Serializable {
    @EmbeddedId
    SanphamSizeKey id;
    private int soluong;
    
    public SanphamSizeKey getId(){
        return id;
    }
    
    
    public int getSoluong(){
        return soluong;
    }
    public void setSoluong(int quantity){
        soluong = quantity;
    }
    
    @ManyToOne
    @MapsId("MaSP")
    @JoinColumn(name = "MaSP")
    private Product product;   
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product pro){
        product = pro;
    }
    @ManyToOne
    @MapsId("MaSize")
    @JoinColumn(name = "MaSize")
    private Size size;   
    public Size getSize(){
        return size;
    }
    public void setSize(Size size){
        this.size = size;
    }
}
