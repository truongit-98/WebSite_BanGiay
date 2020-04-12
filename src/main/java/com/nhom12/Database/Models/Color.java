/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="mausac")
public class Color {
    @Id
    private int MaMau;
    private String Color;
    
    public int getMaMau(){
        return MaMau;
    }
    public void setMaMau(int ma){
        MaMau = ma;
    }
    
    public String getColor(){
        return Color;
    }
    public void setColor(String color){
        Color = color;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
    private Set<BillImportDetail> listBillImportDetail = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
    private Set<OrderDetail> listOrderDetail = new HashSet<>();
    
    @OneToMany(mappedBy = "color")
    Set<ProductDetail> listProductDetail;

}
