package com.hokumus.course.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.hokumus.course.dao.CoursesDao;
import com.hokumus.course.model.management.Courses;
import com.hokumus.course.model.management.Durum;
import com.hokumus.course.utils.CourseUtils;
import com.toedter.calendar.JDateChooser;

public class CoursesFrame extends JFrame {
	private JPanel panel;
	private JLabel lblKursunAdi;
	private JTextField txtKursAdi;
	private JLabel lblBaslamaTarihi;
	private JLabel lblKursFiyati;
	private JTextField txtKursFiyati;
	private JLabel lblDurum;
	private JComboBox cmbDurum;
	private JButton btnEkle;

	public CoursesFrame() {	
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);
		setTitle("Kurs Ekleme Ekranı");
		setSize(499, 446);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel());
		DefaultComboBoxModel durum = new DefaultComboBoxModel(Durum.values());
		cmbDurum.setModel(durum);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Kurs Ekleme Ekran\u0131", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			panel.setBounds(12, 13, 462, 366);
			panel.setLayout(null);
			panel.add(getLblKursunAdi());
			panel.add(getTxtKursAdi());
			panel.add(getLblBaslamaTarihi());
			panel.add(getLblKursFiyati());
			panel.add(getTxtKursFiyati());
			panel.add(getLblDurum());
			panel.add(getCmbDurum());
			panel.add(getBtnEkle());

			JDateChooser dateBaslamaTarihi = new JDateChooser();
			dateBaslamaTarihi.setBounds(152, 86, 141, 20);
			panel.add(dateBaslamaTarihi);
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
			btnEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					CoursesDao daoc = new CoursesDao();
					Courses temp = new Courses();
					temp.setAdi(txtKursAdi.getText());
					temp.setbaslamaTarihi(Calendar.getInstance().getTime());
					temp.setCreatedTime(Calendar.getInstance().getTime());
					temp.setCreaterBy(CourseUtils.loginedUser.getUserName());
					// temp.setDurum(cmbDurum.getActionCommand());
					temp.setFiyat(new BigDecimal(Integer.parseInt(txtKursFiyati.getText())));
					daoc.save(temp);

				}
			});
			btnEkle.setBounds(152, 255, 141, 25);
		}
		return btnEkle;
	}
}
