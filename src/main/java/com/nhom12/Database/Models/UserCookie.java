/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;

/**
 *
 * @author Truong98
 */
public class UserCookie {
    private int id;
    private String fullName;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String name){
        fullName = name;
    }
}
