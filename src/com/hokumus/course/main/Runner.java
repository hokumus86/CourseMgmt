package com.hokumus.course.main;

import java.util.Calendar;

import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.UserModel;
import com.hokumus.course.model.UserPermission;
import com.hokumus.course.ui.LoginFrame;

public class Runner {

	public static void main(String[] args) {
		try {

			new LoginFrame().setVisible(true);

//			UserModel  temp = new UserModel();			
//			temp.setName("ömer faruk");
//			temp.setUserName("ofaruk");
//			temp.setPassword("123");
//			temp.setCellPhone("5067290000");
//			temp.setEmail("huseyinokumuss@gmail.com");
//			temp.setPermission(UserPermission.TEACHER);
//			temp.setCreaterBy("hokumus");
//			temp.setCreatedTime(Calendar.getInstance().getTime());
//			UserModelDao dao = new UserModelDao();
//			dao.save(temp);
			// dao.update(temp);

		} catch (Exception e) {
		}
	}

}
