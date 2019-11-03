package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.hokumus.course.model.management.Days;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DaysFrame extends JFrame{
	private JPanel panel;
	private JLabel lblKursGunuSec;
	private JLabel lblKursSaatiSec;
	private JComboBox cmbKursSaatiSec;
	private JButton btnEkle;
	private JCheckBox chckbxPazartesi;
	private JCheckBox chckbxSali;
	private JCheckBox chckbxPersembe;
	private JCheckBox chckbxCarsamba;
	private JCheckBox chckbxCumartesi;
	private JCheckBox chckbxCuma;
	private JCheckBox chckbxPazar;
	
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
			panel.add(getLblKursSaatiSec());
			panel.add(getCmbKursSaatiSec());
			panel.add(getBtnEkle());
			panel.add(getChckbxPazartesi());
			panel.add(getChckbxSali());
			panel.add(getChckbxPersembe());
			panel.add(getChckbxCarsamba());
			panel.add(getChckbxCumartesi());
			panel.add(getChckbxCuma());
			panel.add(getChckbxPazar());
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
	private JLabel getLblKursSaatiSec() {
		if (lblKursSaatiSec == null) {
			lblKursSaatiSec = new JLabel("Kurs Saati Seç :");
			lblKursSaatiSec.setBounds(25, 245, 136, 16);
		}
		return lblKursSaatiSec;
	}
	private JComboBox getCmbKursSaatiSec() {
		if (cmbKursSaatiSec == null) {
			cmbKursSaatiSec = new JComboBox();
			cmbKursSaatiSec.setBounds(143, 242, 136, 22);
		}
		return cmbKursSaatiSec;
	}
	private JButton getBtnEkle() {
		if (btnEkle == null) {
			btnEkle = new JButton("Ekle");
			btnEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Days d = new Days();
					d.setGun1(chckbxPazartesi.isSelected()==true?1:0);
					d.setGun2(chckbxSali.isSelected()==true?1:0);
					d.setGun3(chckbxCarsamba.isSelected()==true?1:0);
					d.setGun4(chckbxPersembe.isSelected()==true?1:0);
					d.setGun5(chckbxCuma.isSelected()==true?1:0);
					d.setGun6(chckbxCumartesi.isSelected()==true?1:0);
					d.setGun7(chckbxPazar.isSelected()==true?1:0);
				}
			});
			btnEkle.setBounds(143, 277, 97, 25);
		}
		return btnEkle;
	}
	private JCheckBox getChckbxPazartesi() {
		if (chckbxPazartesi == null) {
			chckbxPazartesi = new JCheckBox("Pazartesi");
			chckbxPazartesi.setBounds(141, 17, 113, 25);
		}
		return chckbxPazartesi;
	}
	private JCheckBox getChckbxSali() {
		if (chckbxSali == null) {
			chckbxSali = new JCheckBox("Salı");
			chckbxSali.setBounds(141, 47, 113, 25);
		}
		return chckbxSali;
	}
	private JCheckBox getChckbxPersembe() {
		if (chckbxPersembe == null) {
			chckbxPersembe = new JCheckBox("Perşembe");
			chckbxPersembe.setBounds(141, 106, 113, 25);
		}
		return chckbxPersembe;
	}
	private JCheckBox getChckbxCarsamba() {
		if (chckbxCarsamba == null) {
			chckbxCarsamba = new JCheckBox("Çarşamba");
			chckbxCarsamba.setBounds(141, 76, 113, 25);
		}
		return chckbxCarsamba;
	}
	private JCheckBox getChckbxCumartesi() {
		if (chckbxCumartesi == null) {
			chckbxCumartesi = new JCheckBox("Cumartesi");
			chckbxCumartesi.setBounds(141, 166, 113, 25);
		}
		return chckbxCumartesi;
	}
	private JCheckBox getChckbxCuma() {
		if (chckbxCuma == null) {
			chckbxCuma = new JCheckBox("Cuma");
			chckbxCuma.setBounds(141, 136, 113, 25);
		}
		return chckbxCuma;
	}
	private JCheckBox getChckbxPazar() {
		if (chckbxPazar == null) {
			chckbxPazar = new JCheckBox("Pazar");
			chckbxPazar.setBounds(141, 196, 113, 25);
		}
		return chckbxPazar;
	}
}
