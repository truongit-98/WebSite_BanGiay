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
    private int MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String Email;
    private String Sdt;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private Set<BillImport> listBillImport = new HashSet<>();
}
