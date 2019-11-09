package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.UserModel;
import com.hokumus.course.utils.CourseUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame {
	private JTextField txtUserName;
	private JPasswordField txtSifre;

	public LoginFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		initialize();
	}

	private void initialize() {
		setTitle("Dersane Projesi Giri� Ekran�");
		setSize(444, 456);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		txtUserName = new JTextField("hokumus");
		txtUserName.setBounds(143, 112, 133, 22);
		getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setBounds(23, 115, 108, 16);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setBounds(23, 163, 108, 16);
		getContentPane().add(lblNewLabel_1);

		txtSifre = new JPasswordField("123");
		txtSifre.setBounds(143, 160, 133, 22);
		getContentPane().add(txtSifre);

		JButton btnLogin = new JButton("Giri\u015F");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_Actions();
			}

		});
		btnLogin.setBounds(177, 228, 99, 25);
		getContentPane().add(btnLogin);

		JButton btnExit = new JButton("\u00C7\u0131k\u0131\u015F");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(23, 228, 99, 25);
		getContentPane().add(btnExit);

	}

	private void login_Actions() {
		UserModelDao dao = new UserModelDao();
		List<UserModel> liste = dao.getAll(new UserModel());
		System.out.println(liste);
		boolean isUserNameValid = false;
		boolean isPasswordValid = false;
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getUserName().equals(txtUserName.getText())) {
				isUserNameValid = true;
				if (liste.get(i).getPassword().equals(txtSifre.getText())) {
					UserModel loginedUser= liste.get(i);
					CourseUtils.loginedUser = loginedUser;
					//JOptionPane.showMessageDialog(LoginFrame.this, "Ho�geldiniz");
					new MainFrame().setVisible(true);
					LoginFrame.this.dispose();
					isPasswordValid = true;
					break;
				} else {
					isPasswordValid = false;
					break;
				}
			} else {
				isUserNameValid = false;
			}
		}

		if (!isUserNameValid) {
			JOptionPane.showMessageDialog(LoginFrame.this, "Kullanıcı Bulunamadı");
		} else if (!isPasswordValid) {
			JOptionPane.showMessageDialog(LoginFrame.this, "Şifre Yanlış");
		}
	}
}
