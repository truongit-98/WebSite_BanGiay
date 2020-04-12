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
public class BillImportProductKey implements Serializable {
    @Column(name = "MaPN")
    int mapn;
    
    public int getMapn(){
        return mapn;
    }
    public void setMapn(int id){
        mapn = id;
    }
        
    @Column(name = "MaSP")
    int masp;
    
    public int getMasp(){
        return masp;
    }
    public void setMasp(int id){
        masp = id;
    }
            
    
}
