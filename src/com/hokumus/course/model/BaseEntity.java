package com.hokumus.course.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@MappedSuperclass
public abstract class BaseEntity {
	
	private String createrBy;
	private String updaterBy;
	private String deleterBy;
	private Date createdTime;
	private Date updatedTime;
	private Date deletedTime;

	@Column(name="created_by", length = 50)
	public String getCreaterBy() {
		return createrBy;
	}

	public void setCreaterBy(String createrBy) {
		this.createrBy = createrBy;
	}

	@Column(name="updated_by", length = 50)
	public String getUpdaterBy() {
		return updaterBy;
	}

	public void setUpdaterBy(String updaterBy) {
		this.updaterBy = updaterBy;
	}
	@Column(name="deleted_by", length = 50)
	public String getDeleterBy() {
		return deleterBy;
	}

	public void setDeleterBy(String deleterBy) {
		this.deleterBy = deleterBy;
	}

	@Column(name="created_time")
	@Temporal(TemporalType.DATE)
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Column(name="updated_time")
	@Temporal(TemporalType.DATE)
	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Column(name="deleted_time")
	@Temporal(TemporalType.DATE)
	public Date getDeletedTime() {
		return deletedTime;
	}

	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}

}
