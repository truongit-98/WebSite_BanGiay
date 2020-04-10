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
@Table(name="chitietsp")
public class ProductDetail {
//    @Id
//    private int MaSP;
//    private int MaSize;
//    private int MaMau;
    @EmbeddedId
    OrderProductKey id;
    private int SoLuong;
    
    @ManyToOne
    @MapsId("MaSP")
    @JoinColumn(name = "MaSP")
    Product product;
 
    @ManyToOne
    @MapsId("MaSize")
    @JoinColumn(name = "MaSize")
    Size size;
    
    @ManyToOne
    @MapsId("MaMau")
    @JoinColumn(name = "MaMau")
    Color color;

}
