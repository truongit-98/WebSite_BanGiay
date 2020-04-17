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
    private int masize;
    @Column(name = "Size")
    private int size;
    
    public int getMasize(){
        return masize;
    }
    public void setMasize(int masize){
        this.masize = masize;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    
}
