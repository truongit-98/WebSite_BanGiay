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
}
