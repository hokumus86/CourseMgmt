package com.hokumus.course.model.inventory;

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

import com.hokumus.course.model.humenresources.Employee;
import com.hokumus.course.model.humenresources.Teacher;

@Entity
@Table(name = "fixture")
public class IronHead {

    private Long id;
    private String aciklama;
    private Date tarih;
    private Inventory Iventory;
    private Employee Employee;
    private Teacher Teacher;

    @Id
    @SequenceGenerator(name = "seq_fixture", allocationSize = 1, sequenceName = "seq_fixture")
    @GeneratedValue(generator = "seq_fixture", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "description", length = 400)
    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Column(name = "date")
    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    public Inventory getIventory() {
        return Iventory;
    }

    public void setIventory(Inventory Iventory) {
        this.Iventory = Iventory;
    }

    @ManyToOne
    @JoinColumn(name = "emplooye_id")
    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee Employee) {
        this.Employee = Employee;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }

}
