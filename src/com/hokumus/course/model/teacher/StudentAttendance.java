package com.hokumus.course.model.teacher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.model.management.Courses;
import com.hokumus.course.model.management.Groups;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "student_attendance")
public class StudentAttendance extends BaseEntity {

	private Long id;
	private Attendance Attendance;
	private Groups Groups;
	private Courses Courses;

	@Id
	@SequenceGenerator(name = "seq_student_attendance", allocationSize = 1, sequenceName = "seq_student_attendance")
	@GeneratedValue(generator = "seq_student_attendance", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "inspectionForm_id")
	public Attendance getAttendance() {
		return Attendance;
	}

	public void setAttendance(Attendance Attendance) {
		this.Attendance = Attendance;
	}

	@ManyToOne
	@JoinColumn(name = "group_id")
	public Groups getGroups() {
		return Groups;
	}

	public void setGroups(Groups Groups) {
		this.Groups = Groups;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Courses getCourses() {
		return Courses;
	}

	public void setCourses(Courses Courses) {
		this.Courses = Courses;
	}

	@Override
	public String toString() {
		return "YoklamaBilgileri{" + "id=" + id + ", Attendance=" + Attendance + ", Groups=" + Groups + ", Courses=" + Courses
				+ '}';
	}

}
