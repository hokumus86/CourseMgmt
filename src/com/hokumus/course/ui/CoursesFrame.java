package com.hokumus.course.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.CoursesDao;
import com.hokumus.course.model.management.Courses;
import com.hokumus.course.model.management.Durum;
import com.hokumus.course.ui.utils.CallBackType;
import com.hokumus.course.ui.utils.ICallBackFrame;
import com.hokumus.course.utils.CourseUtils;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	private JPanel pnlCourseList;
	private JScrollPane scrollCourseList;
	private JTable tblCourseList;
	private ICallBackFrame frame;

	public CoursesFrame(ICallBackFrame frame) {	
		this.frame = frame;
		initialize();
	}
	

	private void initialize() {
		getContentPane().setLayout(null);
		setTitle("Kurs Ekleme Ekranı");
		setSize(499, 603);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel());
		DefaultComboBoxModel durum = new DefaultComboBoxModel(Durum.values());
		cmbDurum.setModel(durum);
		getContentPane().add(getPnlCourseList());
		fillTableCoursesLists();

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Kurs Ekleme Ekran\u0131", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			panel.setBounds(12, 13, 462, 296);
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
					temp.setDurum(((Durum)cmbDurum.getSelectedItem()).name());
					temp.setFiyat(new BigDecimal(Integer.parseInt(txtKursFiyati.getText())));
					daoc.save(temp);
					fillTableCoursesLists();
					frame.callBack(CallBackType.One);

				}
			});
			btnEkle.setBounds(152, 255, 141, 25);
		}
		return btnEkle;
	}
	private JPanel getPnlCourseList() {
		if (pnlCourseList == null) {
			pnlCourseList = new JPanel();
			pnlCourseList.setBorder(new TitledBorder(null, "Kurs Listesi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlCourseList.setBounds(12, 322, 467, 213);
			pnlCourseList.setLayout(null);
			pnlCourseList.add(getScrollCourseList());
		}
		return pnlCourseList;
	}
	private JScrollPane getScrollCourseList() {
		if (scrollCourseList == null) {
			scrollCourseList = new JScrollPane();
			scrollCourseList.setBounds(12, 26, 443, 174);
			scrollCourseList.setViewportView(getTblCourseList());
		}
		return scrollCourseList;
	}
	private JTable getTblCourseList() {
		if (tblCourseList == null) {
			tblCourseList = new JTable();
		}
		return tblCourseList;
	}
	
	private void fillTableCoursesLists() {
		CoursesDao dao = new CoursesDao();
		List<Courses> liste = dao.getAll(new Courses());
		String[] columnNames = {"id", "Adı","Başlama Tarihi", "Fiyatı", "Durum"};
		String [][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = liste.get(i).getId().toString();
			data[i][1] = liste.get(i).getAdi();
			data[i][2] = liste.get(i).getbaslamaTarihi().toString();
			data[i][3] = liste.get(i).getFiyat().toString();
			data[i][4] = liste.get(i).getDurum();
			
		}
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		tblCourseList.setModel(model);
	}
}
