package com.hokumus.course.model.teacher;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.model.UserPermission;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity{

    private Long id;
    private String ad;
    private String soyad;
    private String adres;
    private String tel;
    private String mail;
    private BigDecimal ucret;
    private Date kayitTarihi;
  


	@Id
    @SequenceGenerator(name = "seq_teacher", allocationSize = 1, sequenceName = "seq_teacher")
    @GeneratedValue(generator = "seq_teacher", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name",length = 50)
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Column(name = "surname",length = 50)
    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Column(name = "address",length = 500)
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Column(name = "phone",length = 13)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "email",length = 100)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "exspense",precision = 14,scale = 2)
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

    @Override
    public String toString() {
        return ad +" " + soyad;
    }

   

    
    

}
