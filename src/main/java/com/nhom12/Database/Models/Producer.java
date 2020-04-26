/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="nsx")
public class Producer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mansx;
    @Column(name = "TenNSX")
    private String tennsx;
    @Column(name = "DiaChi")
    private String diachi;
    @Column(name = "Email")
    private String email;
    @Column(name = "Sdt")
    private String sdt;
   
    public int getMansx(){
        return mansx;
    }
    public void setMansx(int id){
        mansx = id;
    }
    
    public String getTennsx(){
        return tennsx;
    }
    public void setTennsx(String name){
       tennsx = name;
    }
    public String getDiachi(){
        return diachi;
    }
    public void setDiachi(String str){
        diachi = str;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String str){
        email = str;
    }
    public String getSdt(){
        return sdt;
    }
    public void setSdt(String sdt){
        this.sdt = sdt;
    }
   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producer")
    private Set<Product> listProduct = new HashSet<>();
    public Set<Product> getListProduct(){ 
        return listProduct;
    }
    public void setListProduct(Set<Product> sets){
        listProduct=sets;
    }
    
}
