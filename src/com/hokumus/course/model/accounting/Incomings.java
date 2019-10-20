package com.hokumus.course.model.accounting;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.model.inventory.Inventory;
import com.hokumus.course.model.ogrenci.StudentPayments;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "income")
public class Incomings extends BaseEntity{

    private Long id;
    private String konu;
    private BigDecimal miktar;
    private Date tarih;
    private StudentPayments StudentPayments;
    private Inventory Inventory;

    @Id
    @SequenceGenerator(name = "seq_income", allocationSize = 1, sequenceName = "seq_income")
    @GeneratedValue(generator = "seq_income", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "subject",length = 100)
    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    @Column(name = "quantity",precision = 14,scale = 2)
    public BigDecimal getMiktar() {
        return miktar;
    }

    public void setMiktar(BigDecimal miktar) {
        this.miktar = miktar;
    }

    @Column(name = "date")
    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @ManyToOne
    @JoinColumn(name = "student_payment_id")
    public StudentPayments getStudentPayments() {
        return StudentPayments;
    }

    public void setStudentPayments(StudentPayments StudentPayments) {
        this.StudentPayments = StudentPayments;
    }

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    public Inventory getInventory() {
        return Inventory;
    }

    public void setInventory(Inventory Inventory) {
        this.Inventory = Inventory;
    }

    @Override
    public String toString() {
        return  "Gelir id = "+id;
    }
    

    
       
}

