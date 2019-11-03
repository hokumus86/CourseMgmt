package com.hokumus.course.model.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.model.GenderEnums;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{

    private Long id;
    private String ad;
    private String soyad;
    private String adres;
    private String tel;
    private String mail;
    private Date kayitTarihi;
    private GenderEnums cinsiyet;

    @Id
    @SequenceGenerator(name = "seq_student", allocationSize = 1, sequenceName = "seq_student")
    @GeneratedValue(generator = "seq_student", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Column(name = "surname", length = 50)
    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Column(name = "address", length = 500)
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Column(name = "phone", length = 13)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "email", length = 100)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "reg_date")
    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    @Column(name = "gender")
    @Enumerated
    public GenderEnums getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(GenderEnums cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    
    

    @Override
    public String toString() {
        return  "adi = "+ad+ " soyadý = "+soyad+ " id = "+id;
    }
    

}