package com.hokumus.course.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.UserModel;

public class AdminFrame extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnKullanc;
	private JMenuItem mnýtmEkle;
	private JPanel pblUserInf;
	private JPanel pnlUserSettings;
	private JScrollPane scrollUserInf;
	private JTable tblUserInf;
	private JButton btnGetAllUser;

	public AdminFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Admin Yöetim Paneli");
		setSize(596, 780);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getMenuBar_1());
		getContentPane().add(getPblUserInf());
		getContentPane().add(getPnlUserSettings());
		btnGetAllUserInf_ActionPerformed();

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 588, 25);
			menuBar.add(getMnKullanc());
		}
		return menuBar;
	}

	private JMenu getMnKullanc() {
		if (mnKullanc == null) {
			mnKullanc = new JMenu("Kullan\u0131c\u0131");
			mnKullanc.add(getMnýtmEkle());
		}
		return mnKullanc;
	}

	private JMenuItem getMnýtmEkle() {
		if (mnýtmEkle == null) {
			mnýtmEkle = new JMenuItem("Ekle");
		}
		return mnýtmEkle;
	}

	private JPanel getPblUserInf() {
		if (pblUserInf == null) {
			pblUserInf = new JPanel();
			pblUserInf.setBorder(new TitledBorder(null, "Kullan\u0131c\u0131 Bilgileri", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			pblUserInf.setBounds(10, 38, 566, 254);
			pblUserInf.setLayout(null);
			pblUserInf.add(getScrollUserInf());
			pblUserInf.add(getBtnGetAllUser());
		}
		return pblUserInf;
	}

	private JPanel getPnlUserSettings() {
		if (pnlUserSettings == null) {
			pnlUserSettings = new JPanel();
			pnlUserSettings.setBorder(new TitledBorder(null, "Kullan\u0131c\u0131 \u0130\u015Flem Paneli",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlUserSettings.setBounds(10, 322, 566, 378);
			pnlUserSettings.setLayout(null);
		}
		return pnlUserSettings;
	}

	private JScrollPane getScrollUserInf() {
		if (scrollUserInf == null) {
			scrollUserInf = new JScrollPane();
			scrollUserInf.setBounds(12, 13, 542, 182);
			scrollUserInf.setViewportView(getTblUserInf());
		}
		return scrollUserInf;
	}

	private JTable getTblUserInf() {
		if (tblUserInf == null) {
			tblUserInf = new JTable();
		}
		return tblUserInf;
	}

	private JButton getBtnGetAllUser() {
		if (btnGetAllUser == null) {
			btnGetAllUser = new JButton("Kullan\u0131c\u0131lar\u0131 Getir");
			btnGetAllUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnGetAllUserInf_ActionPerformed();
				}
			});
			btnGetAllUser.setIcon(new ImageIcon("C:\\Users\\vektorel\\Desktop\\images.png"));
			btnGetAllUser.setBounds(12, 205, 542, 37);
		}
		return btnGetAllUser;
	}

	protected void btnGetAllUserInf_ActionPerformed() {
		UserModelDao dao = new UserModelDao();
		List<UserModel> liste = dao.getAll(new UserModel());
		String[] columnNames = { "id", "Adý", "Kullanýcý Adý", "Pasword", "Yetki", "E mail", "Telefon No" };
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = "" + liste.get(i).getId();
			data[i][1] = "" + liste.get(i).getName();
			data[i][2] = "" + liste.get(i).getUserName();
			data[i][3] = "" + liste.get(i).getPassword();
			data[i][4] = "" + liste.get(i).getPermission();
			data[i][5] = "" + liste.get(i).getEmail();
			data[i][6] = "" + liste.get(i).getCellPhone();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tblUserInf.setModel(model);

	}
}
