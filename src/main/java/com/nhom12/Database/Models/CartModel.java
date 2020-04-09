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
public class CartModel {
    private String productId;
    private String productName;
    private int quantity;
    private String urlImg;
    private Double price;
    
    public String getProductId(){
        return productId;
    }
    public void setProductId(String id){
        productId = id;
    }
    
    public String getProductName(){
        return productName;
    }
    public void setProductName(String name){
        productName = name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quant){
        quantity = quant;
    }
    
    public String getUrlImg(){
        return urlImg;
    }
    public void setUrlImg(String url){
        urlImg = url;
    }
    
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    
}
