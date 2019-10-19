package com.hokumus.course.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.UserModel;
import com.hokumus.course.model.UserPermission;
import com.hokumus.course.utils.CourseUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminFrame extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnKullanc;
	private JMenuItem mnýtmEkle;
	private JPanel pblUserInf;
	private JPanel pnlUserSettings;
	private JScrollPane scrollUserInf;
	private JTable tblUserInf;
	private JButton btnGetAllUser;
	private JLabel lblKullancAd;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JLabel lblifre;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JTextField txtCellNum;
	private JLabel lblTelefon;
	private JLabel label_3;
	private JComboBox cmbPermision;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblAdSoyad;
	private JTextField txtName;
	private int selectedRowId;

	public AdminFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Admin Yöetim Paneli");
		setSize(678, 801);
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
			pnlUserSettings.setBounds(10, 322, 629, 378);
			pnlUserSettings.setLayout(null);
			pnlUserSettings.add(getLblKullancAd());
			pnlUserSettings.add(getTxtUserName());
			pnlUserSettings.add(getTxtPassword());
			pnlUserSettings.add(getLblifre());
			pnlUserSettings.add(getTxtEmail());
			pnlUserSettings.add(getLblEmail());
			pnlUserSettings.add(getTxtCellNum());
			pnlUserSettings.add(getLblTelefon());
			pnlUserSettings.add(getLabel_3());
			pnlUserSettings.add(getCmbPermision());
			pnlUserSettings.add(getBtnSave());
			pnlUserSettings.add(getBtnUpdate());
			pnlUserSettings.add(getBtnDelete());
			pnlUserSettings.add(getLblAdSoyad());
			pnlUserSettings.add(getTxtName());
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
			tblUserInf.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tblUserInf_Row_Selected();
				}
			});
		}
		return tblUserInf;
	}

	protected void tblUserInf_Row_Selected() {
		int row = tblUserInf.getSelectedRow();
		selectedRowId = Integer.parseInt(tblUserInf.getModel().getValueAt(row, 0).toString());
		txtName.setText(tblUserInf.getModel().getValueAt(row, 1).toString());
		txtUserName.setText(tblUserInf.getModel().getValueAt(row, 2).toString());
		txtPassword.setText(tblUserInf.getModel().getValueAt(row, 3).toString());
		cmbPermision.setSelectedItem(tblUserInf.getModel().getValueAt(row, 4));
		txtEmail.setText(tblUserInf.getModel().getValueAt(row, 5).toString());
		txtCellNum.setText(tblUserInf.getModel().getValueAt(row, 6).toString());
		
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
	private JLabel getLblKullancAd() {
		if (lblKullancAd == null) {
			lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
			lblKullancAd.setBounds(12, 43, 147, 16);
		}
		return lblKullancAd;
	}
	private JTextField getTxtUserName() {
		if (txtUserName == null) {
			txtUserName = new JTextField();
			txtUserName.setBounds(181, 40, 116, 22);
			txtUserName.setColumns(10);
		}
		return txtUserName;
	}
	private JTextField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JTextField();
			txtPassword.setColumns(10);
			txtPassword.setBounds(181, 72, 116, 22);
		}
		return txtPassword;
	}
	private JLabel getLblifre() {
		if (lblifre == null) {
			lblifre = new JLabel("\u015Eifre");
			lblifre.setBounds(12, 75, 147, 16);
		}
		return lblifre;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(181, 109, 116, 22);
		}
		return txtEmail;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setBounds(12, 112, 147, 16);
		}
		return lblEmail;
	}
	private JTextField getTxtCellNum() {
		if (txtCellNum == null) {
			txtCellNum = new JTextField();
			txtCellNum.setColumns(10);
			txtCellNum.setBounds(477, 43, 116, 22);
		}
		return txtCellNum;
	}
	private JLabel getLblTelefon() {
		if (lblTelefon == null) {
			lblTelefon = new JLabel("Telefon");
			lblTelefon.setBounds(308, 46, 147, 16);
		}
		return lblTelefon;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
			label_3.setBounds(309, 75, 147, 16);
		}
		return label_3;
	}
	private JComboBox getCmbPermision() {
		if (cmbPermision == null) {
			cmbPermision = new JComboBox();
			DefaultComboBoxModel model = new DefaultComboBoxModel(UserPermission.values());
			
			cmbPermision.setBounds(477, 71, 116, 24);
			cmbPermision.setModel(model);
			
		}
		return cmbPermision;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Kaydet");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSave_Action_PerFormed();
				}
			});
			btnSave.setBounds(91, 281, 121, 25);
		}
		return btnSave;
	}
	protected void btnSave_Action_PerFormed() {
		if(txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(AdminFrame.this, "Kullanýcý Adý Boþ Geçilemez!!!");
			return;
		}
		if(txtPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(AdminFrame.this, "Sifre Boþ Geçilemez!!!");
			return;
		}
		UserModelDao dao = new UserModelDao();
		UserModel temp = new UserModel();
		temp.setUserName(txtUserName.getText());
		temp.setPassword(txtPassword.getText());
		temp.setEmail(txtEmail.getText());
		temp.setCellPhone(txtCellNum.getText());
		temp.setCreatedTime(Calendar.getInstance().getTime());
		temp.setCreaterBy(CourseUtils.loginedUser.getUserName());
		temp.setPermission((UserPermission)cmbPermision.getSelectedItem());
		dao.save(temp);
		
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("G\u00FCncelle");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnUpdate_Action_Performed();
				}
			});
			btnUpdate.setBounds(271, 281, 129, 25);
		}
		return btnUpdate;
	}
	protected void btnUpdate_Action_Performed() {
		UserModelDao dao = new UserModelDao();
		UserModel temp = new UserModel();
		temp.setUserName(txtUserName.getText());
		temp.setPassword(txtPassword.getText());
		temp.setEmail(txtEmail.getText());
		temp.setCellPhone(txtCellNum.getText());
		temp.setPermission((UserPermission)cmbPermision.getSelectedItem());
		temp.setId(selectedRowId);
		temp.setUpdatedTime(Calendar.getInstance().getTime());
		temp.setUpdaterBy(CourseUtils.loginedUser.getUserName());
		temp.setName(txtName.getText());
		dao.update(temp);
		
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Sil");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnDelete_ActionPerformed();
				}
			});
			btnDelete.setBounds(456, 281, 121, 25);
		}
		return btnDelete;
	}
	protected void btnDelete_ActionPerformed() {
		UserModelDao dao = new UserModelDao();
		UserModel temp = new UserModel();
		temp.setId(selectedRowId);
		dao.delete(temp);
		
	}

	private JLabel getLblAdSoyad() {
		if (lblAdSoyad == null) {
			lblAdSoyad = new JLabel("Ad\u0131 Soyad\u0131");
			lblAdSoyad.setBounds(308, 112, 147, 16);
		}
		return lblAdSoyad;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setColumns(10);
			txtName.setBounds(477, 109, 116, 22);
		}
		return txtName;
	}
}
