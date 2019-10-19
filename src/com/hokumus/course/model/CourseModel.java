package com.hokumus.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "Course")

public class CourseModel extends BaseEntity{

	private int id;
	private String courseName;
	private String courseTime;
	private String courseTeacher;
	private String userName;
	private String cellPhone;
	private String email;

	
	@SequenceGenerator(name = "seq_course_id",initialValue = 1,allocationSize = 1,sequenceName = "seq_course_id")
	@GeneratedValue(generator = "seq_course_id",strategy = GenerationType.SEQUENCE)
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "course_Name",length = 250)
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@Column(name = "course_Time",length = 250)
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	
	@Column(name = "course_Teacher",length = 250)
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	
	@Column(name = "user_Name",length = 250)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "cell_number",length = 50)
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	@Column(name = "email",length = 100)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
