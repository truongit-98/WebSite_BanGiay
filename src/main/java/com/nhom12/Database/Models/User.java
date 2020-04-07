/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;
import javax.persistence.*;
/**
 *
 * @author Truong98
 */
@Entity
@Table(name="User")
public class User {
    @Id
    private int userId;
    private String name;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
