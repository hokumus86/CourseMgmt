package com.hokumus.course.model.teacher;

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
import javax.persistence.Temporal;

import com.hokumus.course.model.management.Groups;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "attendance")
public class Attendance extends BaseEntity{

    private Long id;
    private String yoklamaAciklama;
    private String islenenKonu;
    private Groups Groups;
    private StudentAttendance StudentAttendance;
    private Boolean[] yoklamalar;
    private Date yoklamaTarihi;
    private Date dersTarihi;

    @Id
    @SequenceGenerator(name = "seq_attendance", allocationSize = 1, sequenceName = "seq_attendance")
    @GeneratedValue(generator = "seq_attendance", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }
    @Column(name = "inspection_state")
    public Boolean[] getYoklamalar() {
		return yoklamalar;
	}

	public void setYoklamalar(Boolean[] yoklamalar) {
		this.yoklamalar = yoklamalar;
	}

	public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Groups getGroups() {
        return Groups;
    }

    public void setGroups(Groups Groups) {
        this.Groups = Groups;
    }

    @Column(name = "inspection_description", length = 100)
    public String getYoklamaAciklama() {
        return yoklamaAciklama;
    }

    public void setYoklamaAciklama(String yoklamaAciklama) {
        this.yoklamaAciklama = yoklamaAciklama;
    }

    @Column(name = "lesson=subject", length = 100)
    public String getIslenenKonu() {
        return islenenKonu;
    }

    public void setIslenenKonu(String islenenKonu) {
        this.islenenKonu = islenenKonu;
    }

    @ManyToOne
    @JoinColumn(name = "inspection_info_id")
    public StudentAttendance getStudentAttendance() {
        return StudentAttendance;
    }

    public void setStudentAttendance(StudentAttendance StudentAttendance) {
		this.StudentAttendance = StudentAttendance;
    }

    @Column(name = "inspection_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getYoklamaTarihi() {
        return yoklamaTarihi;
    }

    public void setYoklamaTarihi(Date yoklamaTarihi) {
        this.yoklamaTarihi = yoklamaTarihi;
    }

    @Column(name = "course_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDersTarihi() {
        return dersTarihi;
    }

    public void setDersTarihi(Date dersTarihi) {
        this.dersTarihi = dersTarihi;
    }

    

}
