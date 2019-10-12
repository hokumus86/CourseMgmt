package com.hokumus.course.main;

import java.util.Calendar;

import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.UserModel;
import com.hokumus.course.model.UserPermission;

public class Runner {

	public static void main(String[] args) {
		try {
			
			UserModel  temp = new UserModel();			
			temp.setName("atýl erkan");
			temp.setUserName("aerkan");
			temp.setPassword("123");
			temp.setCellPhone("5067290000");
			temp.setEmail("huseyinokumuss@gmail.com");
			temp.setPermission(UserPermission.MANAGER);
			temp.setCreaterBy("hokumus");
			temp.setCreatedTime(Calendar.getInstance().getTime());
			UserModelDao dao = new UserModelDao();
			dao.save(temp);
			//dao.update(temp);
		
		} catch (Exception e) {
		}
	}

}
