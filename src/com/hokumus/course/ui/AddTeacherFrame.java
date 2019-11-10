package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.TeacherDao;
import com.hokumus.course.model.teacher.Teacher;
import com.hokumus.course.utils.CourseUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddTeacherFrame extends JFrame{
	private JLabel label;
	private int selectedRowId;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtOgrAdi;
	private JTextField txtOgrSoyadi;
	private JTextPane txtpOgrAdres;
	private JButton btnKaydet;
	private JButton button_1;
	private JLabel label_3;
	private JTextField txtTelefonNo;
	private JLabel label_4;
	private JTextField txtEmail;
	private JLabel label_5;
	private JTextField txtOgrUcreti;
	private JLabel label_6;
	private JTextField txtKayitTarihi;
	private JButton button_2;
	private JScrollPane scrollPane;
	private JButton btnOgrHepsiniGetir;
	private JTable tblTeacher;

	public AddTeacherFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Öğretmen Ekleme Ekranı");
		setSize(586,532);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTxtOgrAdi());
		getContentPane().add(getTxtOgrSoyadi());
		getContentPane().add(getTxtpOgrAdres());
		getContentPane().add(getBtnKaydet());
		getContentPane().add(getButton_1());
		getContentPane().add(getLabel_3());
		getContentPane().add(getTxtTelefonNo());
		getContentPane().add(getLabel_4());
		getContentPane().add(getTxtEmail());
		getContentPane().add(getLabel_5());
		getContentPane().add(getTxtOgrUcreti());
		getContentPane().add(getLabel_6());
		getContentPane().add(getTxtKayitTarihi());
		getContentPane().add(getButton_2());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnOgrHepsiniGetir());
		
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Öğretmen Adı :");
			label.setBounds(12, 48, 133, 14);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Öğretmen Soyadı :");
			label_1.setBounds(12, 73, 133, 14);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Öğretmen Adres :");
			label_2.setBounds(12, 98, 133, 14);
		}
		return label_2;
	}
	private JTextField getTxtOgrAdi() {
		if (txtOgrAdi == null) {
			txtOgrAdi = new JTextField();
			txtOgrAdi.setColumns(10);
			txtOgrAdi.setBounds(155, 48, 133, 20);
		}
		return txtOgrAdi;
	}
	private JTextField getTxtOgrSoyadi() {
		if (txtOgrSoyadi == null) {
			txtOgrSoyadi = new JTextField();
			txtOgrSoyadi.setColumns(10);
			txtOgrSoyadi.setBounds(155, 73, 133, 20);
		}
		return txtOgrSoyadi;
	}
	private JTextPane getTxtpOgrAdres() {
		if (txtpOgrAdres == null) {
			txtpOgrAdres = new JTextPane();
			txtpOgrAdres.setBounds(155, 101, 133, 100);
		}
		return txtpOgrAdres;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(txtOgrAdi.getText().equals("")) {
						JOptionPane.showMessageDialog(AddTeacherFrame.this, "Kullanıcı Adı Boş Geçilemez!!!");
						return;
					}
					if(txtOgrSoyadi.getText().equals("")) {
						JOptionPane.showMessageDialog(AddTeacherFrame.this, "Sifre Boş Geçilemez!!!");
						return;
					}
					TeacherDao dao = new TeacherDao();
					Teacher temp = new Teacher();
					temp.setAd(txtOgrAdi.getText());
					temp.setSoyad(txtOgrSoyadi.getText());
					temp.setMail(txtEmail.getText());
					temp.setTel(txtTelefonNo.getText());
					temp.setCreatedTime(Calendar.getInstance().getTime());
					temp.setCreaterBy(CourseUtils.loginedUser.getUserName());
					dao.save(temp);
					
				}
			});
			btnKaydet.setBounds(135, 225, 89, 23);
		}
		return btnKaydet;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Güncelle");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TeacherDao dao = new TeacherDao();
					Teacher temp = new Teacher();
					temp.setAd(txtOgrAdi.getText());
					temp.setSoyad(txtOgrSoyadi.getText());
					temp.setAdres(txtpOgrAdres.getText());
					temp.setTel(txtTelefonNo.getText());
					temp.setMail(txtEmail.getText());
//					temp.setUcret(txtOgrUcreti.getText());
//					temp.setKayitTarihi(txtKayitTarihi.getText());
					temp.setCreatedTime(Calendar.getInstance().getTime());
					temp.setCreaterBy(CourseUtils.loginedUser.getUserName());
					dao.update(temp);
				}
			});
			button_1.setBounds(236, 225, 89, 23);
		}
		return button_1;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Telefon No :");
			label_3.setBounds(298, 48, 103, 14);
		}
		return label_3;
	}
	private JTextField getTxtTelefonNo() {
		if (txtTelefonNo == null) {
			txtTelefonNo = new JTextField();
			txtTelefonNo.setColumns(10);
			txtTelefonNo.setBounds(411, 45, 133, 20);
		}
		return txtTelefonNo;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Email :");
			label_4.setBounds(298, 79, 103, 14);
		}
		return label_4;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(411, 76, 133, 20);
		}
		return txtEmail;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("Öğretmen Ücreti :");
			label_5.setBounds(298, 107, 103, 14);
		}
		return label_5;
	}
	private JTextField getTxtOgrUcreti() {
		if (txtOgrUcreti == null) {
			txtOgrUcreti = new JTextField();
			txtOgrUcreti.setColumns(10);
			txtOgrUcreti.setBounds(411, 104, 133, 20);
		}
		return txtOgrUcreti;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("Kayıt Tarihi :");
			label_6.setBounds(298, 135, 103, 14);
		}
		return label_6;
	}
	private JTextField getTxtKayitTarihi() {
		if (txtKayitTarihi == null) {
			txtKayitTarihi = new JTextField();
			txtKayitTarihi.setColumns(10);
			txtKayitTarihi.setBounds(411, 132, 133, 20);
		}
		return txtKayitTarihi;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("Sil");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TeacherDao dao = new TeacherDao();
					Teacher temp = new Teacher();
					temp.setId((long) selectedRowId);
					dao.delete(temp);
				}
			});
			button_2.setBounds(335, 225, 89, 23);
		}
		return button_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 250, 543, 73);
			scrollPane.setViewportView(getTblTeacher());
		}
		return scrollPane;
	}
	private JButton getBtnOgrHepsiniGetir() {
		if (btnOgrHepsiniGetir == null) {
			btnOgrHepsiniGetir = new JButton("Hepsini Getir");
			btnOgrHepsiniGetir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnGetAllUserInf_ActionPerformed();
				}
			});
			btnOgrHepsiniGetir.setBounds(216, 326, 139, 23);
		}
		return btnOgrHepsiniGetir;
	}
	private JTable getTblTeacher() {
		if (tblTeacher == null) {
			tblTeacher = new JTable();
			tblTeacher.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tblTeacher_Row_Selected();
				}
			});
		}
		return tblTeacher;
	}
	
	protected void tblTeacher_Row_Selected() {
		int row = tblTeacher.getSelectedRow();
		selectedRowId = Integer.parseInt(tblTeacher.getModel().getValueAt(row, 0).toString());
		txtOgrAdi.setText(tblTeacher.getModel().getValueAt(row, 1).toString());
		txtOgrSoyadi.setText(tblTeacher.getModel().getValueAt(row, 2).toString());
		txtpOgrAdres.setText(tblTeacher.getModel().getValueAt(row, 3).toString());
		txtTelefonNo.setText(tblTeacher.getModel().getValueAt(row, 4).toString());
		txtEmail.setText(tblTeacher.getModel().getValueAt(row, 5).toString());
		txtOgrUcreti.setText(tblTeacher.getModel().getValueAt(row, 6).toString());
		txtKayitTarihi.setText(tblTeacher.getModel().getValueAt(row, 7).toString());
}
	
	protected void btnGetAllUserInf_ActionPerformed() {
		TeacherDao dao = new TeacherDao();
		List<Teacher> liste = dao.getAll(new Teacher());
		String[] columnNames = { "id", "Adı", "Soyadı", "Adres", "Telefon", "E mail", "Ücret", "Kayıt Tarihi" };
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = "" + liste.get(i).getId();
			data[i][1] = "" + liste.get(i).getAd();
			data[i][2] = "" + liste.get(i).getSoyad();
			data[i][3] = "" + liste.get(i).getAdres();
			data[i][4] = "" + liste.get(i).getTel();
			data[i][5] = "" + liste.get(i).getMail();
			data[i][6] = "" + liste.get(i).getUcret();
			data[i][7] = "" + liste.get(i).getKayitTarihi();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tblTeacher.setModel(model);

	}
}
