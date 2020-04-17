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
public class RootCity {
    private String name, slug, type, name_with_type, code;
    
    public String getNameWithType(){
        return name_with_type;
    }
}
