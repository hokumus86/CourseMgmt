package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DaysFrame extends JFrame{
	private JPanel panel;
	private JLabel lblKursGunuSec;
	private JComboBox cmbKursGunuSec;
	private JLabel lblKursSaatiSec;
	private JComboBox cmbKursSaatiSec;
	private JButton btnEkle;
	
	public DaysFrame() {
		getContentPane().setLayout(null);
		setSize(500, 500);
		setTitle("Kurs Günleri Ekleme Ekranı");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel());
		initialize();
	}

	private void initialize() {
	
		
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Kurs G\u00FCnleri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 13, 380, 315);
			panel.setLayout(null);
			panel.add(getLblKursGunuSec());
			panel.add(getCmbKursGunuSec());
			panel.add(getLblKursSaatiSec());
			panel.add(getCmbKursSaatiSec());
			panel.add(getBtnEkle());
		}
		return panel;
	}
	private JLabel getLblKursGunuSec() {
		if (lblKursGunuSec == null) {
			lblKursGunuSec = new JLabel("Kurs Günü Seç :");
			lblKursGunuSec.setBounds(25, 51, 136, 16);
		}
		return lblKursGunuSec;
	}
	private JComboBox getCmbKursGunuSec() {
		if (cmbKursGunuSec == null) {
			cmbKursGunuSec = new JComboBox();
			cmbKursGunuSec.setBounds(177, 48, 136, 22);
		}
		return cmbKursGunuSec;
	}
	private JLabel getLblKursSaatiSec() {
		if (lblKursSaatiSec == null) {
			lblKursSaatiSec = new JLabel("Kurs Saati Seç :");
			lblKursSaatiSec.setBounds(25, 95, 136, 16);
		}
		return lblKursSaatiSec;
	}
	private JComboBox getCmbKursSaatiSec() {
		if (cmbKursSaatiSec == null) {
			cmbKursSaatiSec = new JComboBox();
			cmbKursSaatiSec.setBounds(177, 92, 136, 22);
		}
		return cmbKursSaatiSec;
	}
	private JButton getBtnEkle() {
		if (btnEkle == null) {
			btnEkle = new JButton("Ekle");
			btnEkle.setBounds(138, 169, 97, 25);
		}
		return btnEkle;
	}
}
