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
@Table(name = "usr")
public class UserModel extends BaseEntity {

	private int id;
	private String name;
	private String userName;
	private String password;
	private String cellPhone;
	private String email;
	private UserPermission permission;

	@SequenceGenerator(name = "seq_usr_id",initialValue = 1,allocationSize = 1,sequenceName = "seq_usr_id")
	@GeneratedValue(generator = "seq_usr_id",strategy = GenerationType.SEQUENCE)
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name",length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 @Column(name = "user_name",unique = true,length = 100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(length = 50,name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Enumerated
	@JoinColumn(name = "permision_type")
	public UserPermission getPermission() {
		return permission;
	}

	public void setPermission(UserPermission permission) {
		this.permission = permission;
	}
	
	 @Override
	    public String toString() {
	        return name +" " ;
	    }

}
