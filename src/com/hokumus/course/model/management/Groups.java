package com.hokumus.course.model.management;

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

import com.hokumus.course.model.humenresources.Teacher;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "groups")
public class Groups extends BaseEntity {

	private Long id;
	private String adi;
	private Courses Courses;
	private Teacher Teacher;
	private int ogrenciSayisi;
	private LessonClass LessonClass;
	private Days Days;
	private Date baslamaTarihi;
	private Date bitisTarihi;

	@Id
	@SequenceGenerator(name = "seq_group", allocationSize = 1, sequenceName = "seq_group")
	@GeneratedValue(generator = "seq_group", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Courses getCourses() {
		return Courses;
	}

	public void setCourses(Courses Courses) {
		this.Courses = Courses;
	}

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return Teacher;
	}

	public void setTeacher(Teacher Teacher) {
		this.Teacher = Teacher;
	}

	@Column(name = "student_count")
	public int getOgrenciSayisi() {
		return ogrenciSayisi;
	}

	public void setOgrenciSayisi(int ogrenciSayisi) {
		this.ogrenciSayisi = ogrenciSayisi;
	}

	@ManyToOne
	@JoinColumn(name = "room_id")
	public LessonClass getLessonClass() {
		return LessonClass;
	}

	public void setLessonClass(LessonClass LessonClass) {
		this.LessonClass = LessonClass;
	}

	@ManyToOne
	@JoinColumn(name = "Days")
	public Days getDays() {
		return Days;
	}

	public void setDays(Days Days) {
		this.Days = Days;
	}

	@Column(name = "start_date")
	public Date getBaslamaTarihi() {
		return baslamaTarihi;
	}

	public void setBaslamaTarihi(Date baslamaTarihi) {
		this.baslamaTarihi = baslamaTarihi;
	}

	@Column(name = "end_date")
	public Date getBitisTarihi() {
		return bitisTarihi;
	}

	public void setBitisTarihi(Date bitisTarihi) {
		this.bitisTarihi = bitisTarihi;
	}

	@Override
	public String toString() {
		return "Grup{" + "id=" + id + ", adi=" + adi + ", Courses=" + Courses + ", Teacher=" + Teacher
				+ ", ogrenciSayisi=" + ogrenciSayisi + ", LessonClass=" + LessonClass + ", baslamaTarihi="
				+ baslamaTarihi + ", bitisTarihi=" + bitisTarihi + '}';
	}

	public Groups getByUsernameAndPassword(String kullaniciAdi, String sifre) {
//        Criteria criteria = baseService.getSession().createCriteria(Grup.class);
//        criteria.add(Restrictions.eq("grupAdi", kullaniciAdi));
//        criteria.add(Restrictions.eq("sifre", sifre));
//        return (Grup) criteria.uniqueResult();
		return null;
	}

}