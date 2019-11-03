package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

public class CoursesFrame extends JFrame{
	private JPanel panel;
	private JLabel lblKursunAdi;
	private JTextField txtKursAdi;
	private JLabel lblBaslamaTarihi;
	private JTextField txtBaslamaTarihi;
	private JLabel lblKursFiyati;
	private JTextField txtKursFiyati;
	private JLabel lblDurum;
	private JComboBox cmbDurum;
	private JButton btnEkle;
	
	public CoursesFrame() {
		getContentPane().setLayout(null);
		setTitle("Kurs Ekleme Ekranı");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel());
		initialize();
	}

	private void initialize() {
		
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Kurs Ekleme Ekran\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 13, 540, 366);
			panel.setLayout(null);
			panel.add(getLblKursunAdi());
			panel.add(getTxtKursAdi());
			panel.add(getLblBaslamaTarihi());
			panel.add(getTxtBaslamaTarihi());
			panel.add(getLblKursFiyati());
			panel.add(getTxtKursFiyati());
			panel.add(getLblDurum());
			panel.add(getCmbDurum());
			panel.add(getBtnEkle());
		}
		return panel;
	}
	private JLabel getLblKursunAdi() {
		if (lblKursunAdi == null) {
			lblKursunAdi = new JLabel("Kursun Adı :");
			lblKursunAdi.setBounds(24, 43, 101, 16);
		}
		return lblKursunAdi;
	}
	private JTextField getTxtKursAdi() {
		if (txtKursAdi == null) {
			txtKursAdi = new JTextField();
			txtKursAdi.setBounds(152, 40, 141, 22);
			txtKursAdi.setColumns(10);
		}
		return txtKursAdi;
	}
	private JLabel getLblBaslamaTarihi() {
		if (lblBaslamaTarihi == null) {
			lblBaslamaTarihi = new JLabel("Başlama Tarihi :");
			lblBaslamaTarihi.setBounds(24, 86, 101, 16);
		}
		return lblBaslamaTarihi;
	}
	private JTextField getTxtBaslamaTarihi() {
		if (txtBaslamaTarihi == null) {
			txtBaslamaTarihi = new JTextField();
			txtBaslamaTarihi.setColumns(10);
			txtBaslamaTarihi.setBounds(152, 83, 141, 22);
		}
		return txtBaslamaTarihi;
	}
	private JLabel getLblKursFiyati() {
		if (lblKursFiyati == null) {
			lblKursFiyati = new JLabel("Kurs Fiyatı :");
			lblKursFiyati.setBounds(24, 133, 101, 16);
		}
		return lblKursFiyati;
	}
	private JTextField getTxtKursFiyati() {
		if (txtKursFiyati == null) {
			txtKursFiyati = new JTextField();
			txtKursFiyati.setColumns(10);
			txtKursFiyati.setBounds(152, 130, 141, 22);
		}
		return txtKursFiyati;
	}
	private JLabel getLblDurum() {
		if (lblDurum == null) {
			lblDurum = new JLabel("Durum :");
			lblDurum.setBounds(24, 187, 101, 16);
		}
		return lblDurum;
	}
	private JComboBox getCmbDurum() {
		if (cmbDurum == null) {
			cmbDurum = new JComboBox();
			cmbDurum.setBounds(152, 184, 141, 22);
		}
		return cmbDurum;
	}
	private JButton getBtnEkle() {
		if (btnEkle == null) {
			btnEkle = new JButton("Ekle");
			btnEkle.setBounds(152, 255, 141, 25);
		}
		return btnEkle;
	}
}
