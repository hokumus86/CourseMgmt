package com.hokumus.course.model.ogrenci;

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

import com.hokumus.course.model.management.Groups;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "student_group")
public class StudentGroups extends BaseEntity {

	private Long id;
    private Student ogrenci;
    private Groups Groups;
    private BigDecimal ucret;
    private Date kayitTarihi;

    @Id
    @SequenceGenerator(name = "seq_student_group", allocationSize = 1, sequenceName = "seq_student_group")
    @GeneratedValue(generator = "seq_student_group", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Student ogrenci) {
        this.ogrenci = ogrenci;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Groups getGroups() {
        return Groups;
    }

    public void setGroups(Groups Groups) {
        this.Groups = Groups;
    }

    @Column(name = "name", scale = 2, precision = 14)
    public BigDecimal getUcret() {
        return ucret;
    }

    public void setUcret(BigDecimal ucret) {
        this.ucret = ucret;
    }

    @Column(name = "reg_date")
    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

}