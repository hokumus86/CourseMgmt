package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class StudentAddFrame extends JFrame {
	private JPanel pnlStd;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtName;
	private JLabel lblName;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JTextField textField_3;
	private JLabel lblCell;
	private JLabel lblProgram;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnUpdate;
	private JButton btnFin;

	public StudentAddFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Öğrenci Yönetim Paneli");
		setSize(500, 500);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlStd());
		getContentPane().add(getTxtName());
		getContentPane().add(getLblName());
		getContentPane().add(getTxtEmail());
		getContentPane().add(getLblEmail());
		getContentPane().add(getTextField_3());
		getContentPane().add(getLblCell());
		getContentPane().add(getLblProgram());
		getContentPane().add(getComboBox());
		getContentPane().add(getBtnAdd());
		getContentPane().add(getBtnDel());
		getContentPane().add(getBtnUpdate());
		getContentPane().add(getBtnFin());

	}

	private JPanel getPnlStd() {
		if (pnlStd == null) {
			pnlStd = new JPanel();
			pnlStd.setBorder(new TitledBorder(null, "\u00D6\u011Frenci Listeleri", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			pnlStd.setBounds(10, 22, 464, 135);
			pnlStd.setLayout(null);
			pnlStd.add(getScrollPane());
		}
		return pnlStd;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 444, 113);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setColumns(10);
			txtName.setBounds(122, 225, 86, 20);
		}
		return txtName;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Ad Soyad");
			lblName.setBounds(20, 228, 46, 14);
		}
		return lblName;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(122, 267, 86, 20);
		}
		return txtEmail;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setBounds(20, 270, 46, 14);
		}
		return lblEmail;
	}

	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(122, 312, 86, 20);
		}
		return textField_3;
	}

	private JLabel getLblCell() {
		if (lblCell == null) {
			lblCell = new JLabel("Telefon Numarası");
			lblCell.setBounds(20, 315, 92, 14);
		}
		return lblCell;
	}

	private JLabel getLblProgram() {
		if (lblProgram == null) {
			lblProgram = new JLabel("Program");
			lblProgram.setBounds(20, 355, 68, 14);
		}
		return lblProgram;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(122, 352, 86, 20);
		}
		return comboBox;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Ekle");
			btnAdd.setBounds(316, 224, 89, 23);
		}
		return btnAdd;
	}

	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton("Çıkar");
			btnDel.setBounds(316, 266, 89, 23);
		}
		return btnDel;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Güncelle");
			btnUpdate.setBounds(316, 311, 89, 23);
		}
		return btnUpdate;
	}

	private JButton getBtnFin() {
		if (btnFin == null) {
			btnFin = new JButton("Bitti");
			btnFin.setBounds(316, 351, 89, 23);
		}
		return btnFin;
	}
}
