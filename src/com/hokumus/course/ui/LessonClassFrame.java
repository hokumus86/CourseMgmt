package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.hokumus.course.dao.LessonsClassDao;
import com.hokumus.course.model.management.LessonClass;
import com.hokumus.course.ui.utils.CallBackType;
import com.hokumus.course.ui.utils.ICallBackFrame;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class LessonClassFrame extends JFrame {
	private JPanel pnlSinifEkleEkrani;
	private JTextField txtSinifAdi;
	private JTextField txtSinifKodu;
	private JTextField txtSinifKapasitesi;
	private JLabel lblSinifAdi;
	private JLabel lblSinifKodu;
	private JLabel lblSinifKapasitesi;
	private JButton btnKaydet;
	private ICallBackFrame frame;

	public LessonClassFrame (ICallBackFrame frame) {
		this.frame = frame;
		initialize();
		
	}

	private void initialize() {
		setTitle("Sınıf Ekleme Ekranı");
		setSize(399, 404);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlSinifEkleEkrani());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private JPanel getPnlSinifEkleEkrani() {
		if (pnlSinifEkleEkrani == null) {
			pnlSinifEkleEkrani = new JPanel();
			pnlSinifEkleEkrani.setBorder(new TitledBorder(null, "S\u0131n\u0131f Ekleme Ekran\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlSinifEkleEkrani.setBounds(10, 11, 359, 335);
			pnlSinifEkleEkrani.setLayout(null);
			pnlSinifEkleEkrani.add(getTxtSinifAdi());
			pnlSinifEkleEkrani.add(getTxtSinifKodu());
			pnlSinifEkleEkrani.add(getTxtSinifKapasitesi());
			pnlSinifEkleEkrani.add(getLblSinifAdi());
			pnlSinifEkleEkrani.add(getLblSinifKodu());
			pnlSinifEkleEkrani.add(getLblSinifKapasitesi());
			pnlSinifEkleEkrani.add(getBtnKaydet());
		}
		return pnlSinifEkleEkrani;
	}
	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setBounds(139, 39, 123, 20);
			txtSinifAdi.setColumns(10);
		}
		return txtSinifAdi;
	}
	private JTextField getTxtSinifKodu() {
		if (txtSinifKodu == null) {
			txtSinifKodu = new JTextField();
			txtSinifKodu.setColumns(10);
			txtSinifKodu.setBounds(139, 70, 123, 20);
		}
		return txtSinifKodu;
	}
	private JTextField getTxtSinifKapasitesi() {
		if (txtSinifKapasitesi == null) {
			txtSinifKapasitesi = new JTextField();
			txtSinifKapasitesi.setColumns(10);
			txtSinifKapasitesi.setBounds(139, 101, 123, 20);
		}
		return txtSinifKapasitesi;
	}
	private JLabel getLblSinifAdi() {
		if (lblSinifAdi == null) {
			lblSinifAdi = new JLabel("Sınıf Adı :");
			lblSinifAdi.setBounds(10, 42, 101, 14);
		}
		return lblSinifAdi;
	}
	private JLabel getLblSinifKodu() {
		if (lblSinifKodu == null) {
			lblSinifKodu = new JLabel("Sınıf Kodu :");
			lblSinifKodu.setBounds(10, 73, 101, 14);
		}
		return lblSinifKodu;
	}
	private JLabel getLblSinifKapasitesi() {
		if (lblSinifKapasitesi == null) {
			lblSinifKapasitesi = new JLabel("Sınıf Kapasitesi :");
			lblSinifKapasitesi.setBounds(10, 104, 101, 14);
		}
		return lblSinifKapasitesi;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LessonClass lc = new LessonClass();
					lc.setAdi(txtSinifAdi.getText());
					lc.setKapasite(Integer.parseInt(txtSinifKapasitesi.getText()));
					lc.setKod(txtSinifKodu.getText());					
					LessonsClassDao lcdao = new LessonsClassDao();
					lcdao.save(lc);
				//	frame.callBack(CallBackType.Two);
					
				}
			});
			btnKaydet.setBounds(139, 150, 89, 23);
		}
		return btnKaydet;
	}
}
