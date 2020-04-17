/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import javax.persistence.*;
import java.io.Serializable;
/**
 *
 * @author ThongPVT
 */
@Embeddable
public class OrderProductKey implements Serializable{
    @Column(name = "maDH")
    int madh;
 
    @Column(name = "maSP")
    int masp;
    
    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }
    
    public int getMadh() {
        return madh;
    }

    public void setMadh(int madh) {
        this.madh = madh;
    }
}
