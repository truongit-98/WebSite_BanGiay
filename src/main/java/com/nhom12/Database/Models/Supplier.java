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
@Table(name="ncc")
public class Supplier {
    @Id
    private int mancc;
    @Column(name = "TenNCC")
    private String tenncc;
    @Column(name = "DiaChi")
    private String diachi;
    @Column(name = "Email")
    private String email;
    @Column(name = "Sdt")
    private String sdt;
    
    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        tenncc = tenncc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }
    
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        sdt = sdt;
    }
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
//    private Set<BillImport> listBillImport = new HashSet<>();
}
