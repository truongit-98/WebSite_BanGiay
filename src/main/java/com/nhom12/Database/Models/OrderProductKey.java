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
public class OrderProductKey  implements Serializable{
    @Column(name = "MaDH")
    int madh;
 
    @Column(name = "MaSP")
    int masp;
}
