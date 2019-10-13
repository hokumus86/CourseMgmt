package com.hokumus.course.ui;

import javax.swing.JFrame;

import com.hokumus.course.model.UserModel;
import com.hokumus.course.model.UserPermission;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private UserModel loginedUser;
	private JButton btnAdmin;
	private JButton btnManager;
	private JButton btnStudent;
	private JButton btnTeacher;

	public MainFrame(UserModel temp) {
		this.loginedUser = temp;
		intialize();
	}

	private void intialize() {
		setTitle("Course Ana Ekran  :" + loginedUser.getUserName() + " - " + loginedUser.getPermission());
		setSize(637, 553);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnAdmin());
		getContentPane().add(getBtnYnetici());
		getContentPane().add(getBtnOgrenci());
		getContentPane().add(getBtnOgretmen());
		generateRoolForPermision(loginedUser.getPermission());
	}

	private void generateRoolForPermision(UserPermission permission) {
		switch (permission) {
		case ADMIN:

			break;
		case MANAGER:
			btnAdmin.setEnabled(false);
			break;

		case STUDENT:
			btnAdmin.setEnabled(false);
			btnManager.setEnabled(false);
			btnTeacher.setEnabled(false);
			break;
		case TEACHER:
			btnAdmin.setEnabled(false);
			btnManager.setEnabled(false);
			break;

		default:
			break;
		}

	}

	private JButton getBtnAdmin() {
		if (btnAdmin == null) {
			btnAdmin = new JButton("Admin Paneli");
			btnAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AdminFrame().setVisible(true);
				}
			});
			btnAdmin.setBounds(74, 26, 227, 125);
		}
		return btnAdmin;
	}

	private JButton getBtnYnetici() {
		if (btnManager == null) {
			btnManager = new JButton("Y\u00F6netici Paneli");
			btnManager.setBounds(335, 26, 227, 125);
		}
		return btnManager;
	}

	private JButton getBtnOgrenci() {
		if (btnStudent == null) {
			btnStudent = new JButton("\u00D6grenci Paneli");
			btnStudent.setBounds(74, 182, 227, 118);
		}
		return btnStudent;
	}

	private JButton getBtnOgretmen() {
		if (btnTeacher == null) {
			btnTeacher = new JButton("\u00D6\u011Fretmen Paneli");
			btnTeacher.setBounds(335, 182, 227, 118);
		}
		return btnTeacher;
	}
}
