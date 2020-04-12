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
public class ProductDetailKey implements Serializable{
    @Column(name = "MaSP")
    int masp;
 
    @Column(name = "MaSize")
    int masize;
    
    @Column(name = "MaMau")
    int mamau;
    
    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        masp = masp;
    }
    
    public int getMasize() {
        return masize;
    }

    public void setMasize(int masize) {
        masize = masize;
    }
    
    public int getMamau() {
        return mamau;
    }

    public void setMamau(int mamau) {
        mamau = mamau;
    }
}
