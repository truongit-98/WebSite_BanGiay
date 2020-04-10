/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.Database.Models;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author ThongPVT
 */
@Entity
@Table(name="phieunhap")
public class BillImport {
    @Id
    private int MaPN;
    private Date NgayNhap;
    private int MaNV;
    private int MaNCC;
    private double TongTien;
    private String TinhTrang;
    
    @OneToMany(mappedBy = "billImport")
    Set<BillImportDetail> listBillImportDetail;
    
    @ManyToOne
    @JoinColumn(name = "MaNCC")
    private Supplier supplier;

    public Supplier getSupplier() {
            return supplier;
    }

    public void setSupplier(Supplier supplier) {
            this.supplier = supplier;
    }
    
    @ManyToOne
    @JoinColumn(name = "MaNV")
    private Staff staff;

    public Staff getStaff() {
            return staff;
    }

    public void setStaff(Staff staff) {
            this.staff = staff;
    }
}
