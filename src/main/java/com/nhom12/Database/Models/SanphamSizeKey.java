/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Truong98
 */
@Embeddable
public class SanphamSizeKey implements Serializable {
    
    @Column(name="MaSize")
    private int masize;
    
    @Column(name="MaSP")
    private int maSP;
            
    public int getMasize(){
        return masize;
    } 
    public void setMasize(int id){
        masize = id;
    }
    public int getMaSP(){
        return maSP;
    }
    public void setMaSP(int id){
        maSP = id;
    }
    
}
