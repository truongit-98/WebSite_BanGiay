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
@Table(name="size")
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSize;
    @Column(name = "Size")
    private int size;
    
    public int getMaSize(){
        return maSize;
    }
    public void setMaSize(int masize){
        this.maSize = masize;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "size")
    Set<SanphamSize> listSanPhamSize = new HashSet<SanphamSize>();
    public Set<SanphamSize> getListSanPhamSize(){
        return listSanPhamSize;
    }
    public void setListSanPhamSize(Set<SanphamSize> sets){
        listSanPhamSize = sets;
    }
}
