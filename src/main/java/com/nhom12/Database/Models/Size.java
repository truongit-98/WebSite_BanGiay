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
@Table(name="size")
public class Size {
    @Id
    private int masize;
    @Column(name = "Size")
    private int size;
    
    public int getMasp(){
        return masize;
    }
    public void setMasp(int masize){
        masize = masize;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        size = size;
    }
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "size")
//    private Set<BillImportDetail> listBillImportDetail = new HashSet<>();
//    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "size")
//    private Set<OrderDetail> listOrderDetail = new HashSet<>();
//    
//    @OneToMany(mappedBy = "size")
//    Set<ProductDetail> listProductDetail;
    
}
