package com.hokumus.course.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.CoursesDao;
import com.hokumus.course.dao.DaysDao;
import com.hokumus.course.dao.GroupsDao;
import com.hokumus.course.dao.LessonsClassDao;
import com.hokumus.course.dao.TeacherDao;
import com.hokumus.course.model.management.Courses;
import com.hokumus.course.model.management.Days;
import com.hokumus.course.model.management.Groups;
import com.hokumus.course.model.management.KursGunleri;
import com.hokumus.course.model.management.LessonClass;
import com.hokumus.course.model.teacher.Teacher;
import com.hokumus.course.ui.utils.CallBackType;
import com.hokumus.course.ui.utils.ICallBackFrame;
import com.hokumus.course.utils.CourseUtils;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ManagementFrame extends JFrame implements ICallBackFrame{
	private int selectedRowId;
	private JPanel pnlGrupKursEklemeEkrani;
	private JLabel lblKursAdi;
	private JLabel lblKursOgr;
	private JLabel lblBasTarihi;
	private JLabel lblSinifAdi;
	private JLabel lblKursGunleri;
	private JLabel lblrenciSays;
	private JTextField txtKursAdi;
	private JTextField txtSinifAdi;
	private JLabel lblBitTarihi;
	private JButton btnKaydetKurs;
	private JButton btnGuncelleKurs;
	private JButton btnSilKurs;
	private JTextField txtOgrenciSayisi;
	private JComboBox cmbKursGunleri;
	private JComboBox cmbTeacher;
	private JScrollPane scrollGrupKurs;
	private JTable tblGrupKurs;
	private JButton btnGrupHepsiniGetir;
	private JButton btnSinifEkle;
	private JButton btnAddTeacher;
	private JButton btnAddDays;
	private JDateChooser dateBasTarihi;
	private JDateChooser dateBitTarihi;
	private JLabel label;
	private JComboBox cmbCourseSelect;
	private JButton btnAddCourses;

	public ManagementFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new MainFrame().setVisible(true);
			}
		});
		initialize();
	}

	private void initialize() {
		setTitle("Yönetici Paneli Ekranı");
		getContentPane().setLayout(null);
		setSize(746, 709);
		getContentPane().add(getPnlGrupKursEklemeEkrani());
		setVisible(false);

		fillTeacherCombo();

		DaysDao ddao = new DaysDao();
		List<Days> dliste = ddao.getAll(new Days());
		Days[] ddata = new Days[dliste.size()];
		for (int i = 0; i < ddata.length; i++) {
			ddata[i] = dliste.get(i);
		}

		DefaultComboBoxModel cmodel = new DefaultComboBoxModel(ddata);
		cmbKursGunleri.setModel(cmodel);
		
		DaysDao daodays = new  DaysDao();
		List<Days> gunler = daodays.getAll(new Days());
		Days[] g = new Days[gunler.size()];
		for (int i = 0; i < gunler.size(); i++) {
			g[i] = gunler.get(i);			
		}
		DefaultComboBoxModel kursgunleri = new DefaultComboBoxModel(g);
		cmbKursGunleri.setModel(kursgunleri);
		
		fillCoursesCombo();
		fillTeacherCombo();
	}

	private void fillTeacherCombo()  {
		TeacherDao dao = new TeacherDao();
		List<Teacher> liste = dao.getAll(new Teacher());
		Teacher[] data = new Teacher[liste.size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = liste.get(i);
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(data);
		cmbTeacher.setModel(model);
	}

	private void fillCoursesCombo() {
		CoursesDao dao = new CoursesDao();
		List<Courses> liste = dao.getAll(new Courses());
		Object[] c = (Object[])liste.toArray();
		DefaultComboBoxModel modelCourses = new DefaultComboBoxModel(c);
		getCmbCourseSelect().setModel(modelCourses);
		
	}

	protected void btnDelete_ActionPerformed() {
		TeacherDao dao = new TeacherDao();
		Teacher temp = new Teacher();
		temp.setId((long) selectedRowId);
		dao.delete(temp);
	}

	private JPanel getPnlGrupKursEklemeEkrani() {
		if (pnlGrupKursEklemeEkrani == null) {
			pnlGrupKursEklemeEkrani = new JPanel();
			pnlGrupKursEklemeEkrani.setBounds(12, 82, 671, 538);
			pnlGrupKursEklemeEkrani.setLayout(null);
			pnlGrupKursEklemeEkrani.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					"Grup Kurs Ekleme Ekran\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlGrupKursEklemeEkrani.add(getLblKursAdi());
			pnlGrupKursEklemeEkrani.add(getLblKursOgr());
			pnlGrupKursEklemeEkrani.add(getLblBasTarihi());
			pnlGrupKursEklemeEkrani.add(getLblSinifAdi());
			pnlGrupKursEklemeEkrani.add(getLblKursGunleri());
			pnlGrupKursEklemeEkrani.add(getLblrenciSays());
			pnlGrupKursEklemeEkrani.add(getTxtKursAdi());
			pnlGrupKursEklemeEkrani.add(getTxtSinifAdi());
			pnlGrupKursEklemeEkrani.add(getLblBitTarihi());
			pnlGrupKursEklemeEkrani.add(getBtnKaydetKurs());
			pnlGrupKursEklemeEkrani.add(getBtnGuncelleKurs());
			pnlGrupKursEklemeEkrani.add(getBtnSilKurs());
			pnlGrupKursEklemeEkrani.add(getTxtOgrenciSayisi());
			pnlGrupKursEklemeEkrani.add(getCmbKursGunleri());
			pnlGrupKursEklemeEkrani.add(getCmbTeacher());
			pnlGrupKursEklemeEkrani.add(getScrollGrupKurs());
			pnlGrupKursEklemeEkrani.add(getBtnGrupHepsiniGetir());
			pnlGrupKursEklemeEkrani.add(getBtnAddTeacher());
			pnlGrupKursEklemeEkrani.add(getBtnAddDays());
			pnlGrupKursEklemeEkrani.add(getDateBasTarihi());
			pnlGrupKursEklemeEkrani.add(getDateBitTarihi());
			pnlGrupKursEklemeEkrani.add(getLabel());
			pnlGrupKursEklemeEkrani.add(getCmbCourseSelect());
			pnlGrupKursEklemeEkrani.add(getBtnAddCourses());
			pnlGrupKursEklemeEkrani.add(getBtnSinifEkle());

		}
		return pnlGrupKursEklemeEkrani;
	}

	private JLabel getLblKursAdi() {
		if (lblKursAdi == null) {
			lblKursAdi = new JLabel("Kurs Adı :");
			lblKursAdi.setBounds(10, 63, 133, 14);
		}
		return lblKursAdi;
	}

	private JLabel getLblKursOgr() {
		if (lblKursOgr == null) {
			lblKursOgr = new JLabel("Kurs Öğretmeni :");
			lblKursOgr.setBounds(10, 88, 133, 14);
		}
		return lblKursOgr;
	}

	private JLabel getLblBasTarihi() {
		if (lblBasTarihi == null) {
			lblBasTarihi = new JLabel("Başlama Tarihi :");
			lblBasTarihi.setBounds(348, 83, 103, 14);
		}
		return lblBasTarihi;
	}

	private JLabel getLblSinifAdi() {
		if (lblSinifAdi == null) {
			lblSinifAdi = new JLabel("Sınıf Adı :");
			lblSinifAdi.setBounds(348, 33, 103, 14);
		}
		return lblSinifAdi;
	}

	private JLabel getLblKursGunleri() {
		if (lblKursGunleri == null) {
			lblKursGunleri = new JLabel("Kurs Günleri :");
			lblKursGunleri.setBounds(348, 58, 103, 14);
		}
		return lblKursGunleri;
	}

	private JLabel getLblrenciSays() {
		if (lblrenciSays == null) {
			lblrenciSays = new JLabel("Öğrenci Sayısı :");
			lblrenciSays.setBounds(10, 113, 133, 14);
		}
		return lblrenciSays;
	}

	private JTextField getTxtKursAdi() {
		if (txtKursAdi == null) {
			txtKursAdi = new JTextField();
			txtKursAdi.setColumns(10);
			txtKursAdi.setBounds(153, 60, 133, 20);
		}
		return txtKursAdi;
	}

	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setColumns(10);
			txtSinifAdi.setBounds(461, 28, 133, 22);
		}
		return txtSinifAdi;
	}

	private JLabel getLblBitTarihi() {
		if (lblBitTarihi == null) {
			lblBitTarihi = new JLabel("Bitiş Tarihi :");
			lblBitTarihi.setBounds(348, 108, 103, 14);
		}
		return lblBitTarihi;
	}

	private JButton getBtnKaydetKurs() {
		if (btnKaydetKurs == null) {
			btnKaydetKurs = new JButton("Kaydet");
			btnKaydetKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					

					
					Groups g = new Groups();
					g.setAdi("Java 44");
					g.setBaslamaTarihi(Calendar.getInstance().getTime());
					g.setBitisTarihi(Calendar.getInstance().getTime());
					//g.setCourses(temp);
					g.setDays((Days)cmbKursGunleri.getSelectedItem());
					//g.setLessonClass(lc);
					g.setOgrenciSayisi(Integer.parseInt(txtOgrenciSayisi.getText()));
					g.setTeacher((Teacher) cmbTeacher.getSelectedItem());
					GroupsDao dao = new GroupsDao();
					dao.save(g);

				}
			});
			btnKaydetKurs.setBounds(135, 198, 89, 23);
		}
		return btnKaydetKurs;
	}

	private JButton getBtnGuncelleKurs() {
		if (btnGuncelleKurs == null) {
			btnGuncelleKurs = new JButton("Güncelle");
			btnGuncelleKurs.setBounds(234, 198, 89, 23);
		}
		return btnGuncelleKurs;
	}

	private JButton getBtnSilKurs() {
		if (btnSilKurs == null) {
			btnSilKurs = new JButton("Sil");
			btnSilKurs.setBounds(333, 198, 89, 23);
		}
		return btnSilKurs;
	}

	private JTextField getTxtOgrenciSayisi() {
		if (txtOgrenciSayisi == null) {
			txtOgrenciSayisi = new JTextField();
			txtOgrenciSayisi.setColumns(10);
			txtOgrenciSayisi.setBounds(153, 110, 133, 20);
		}
		return txtOgrenciSayisi;
	}

	private JComboBox getCmbKursGunleri() {
		if (cmbKursGunleri == null) {
			cmbKursGunleri = new JComboBox();
			cmbKursGunleri.setBounds(463, 59, 133, 22);

		}
		return cmbKursGunleri;
	}

	private JComboBox getCmbTeacher() {
		if (cmbTeacher == null) {
			cmbTeacher = new JComboBox();
			cmbTeacher.setBounds(153, 83, 131, 24);
		}
		return cmbTeacher;
	}

	private JScrollPane getScrollGrupKurs() {
		if (scrollGrupKurs == null) {
			scrollGrupKurs = new JScrollPane();
			scrollGrupKurs.setBounds(10, 234, 543, 255);
			scrollGrupKurs.setViewportView(getTblGrupKurs());
		}
		return scrollGrupKurs;
	}

	private JTable getTblGrupKurs() {
		if (tblGrupKurs == null) {
			tblGrupKurs = new JTable();
			tblGrupKurs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tblGrupKurs_Row_Selected();
				}
			});
		}
		return tblGrupKurs;
	}

	protected void tblGrupKurs_Row_Selected() {
		int row = tblGrupKurs.getSelectedRow();
		selectedRowId = Integer.parseInt(tblGrupKurs.getModel().getValueAt(row, 0).toString());
		txtKursAdi.setText(tblGrupKurs.getModel().getValueAt(row, 1).toString());
		txtOgrenciSayisi.setText(tblGrupKurs.getModel().getValueAt(row, 2).toString());
		dateBasTarihi.setDate(new Date(tblGrupKurs.getModel().getValueAt(row, 3).toString()));
		dateBitTarihi.setDate(new Date( tblGrupKurs.getModel().getValueAt(row, 4).toString()));
		cmbKursGunleri.setSelectedItem(tblGrupKurs.getModel().getValueAt(row, 5).toString());
		txtSinifAdi.setText(tblGrupKurs.getModel().getValueAt(row, 6).toString());
		cmbTeacher.setSelectedItem(tblGrupKurs.getModel().getValueAt(row, 7).toString());
		
	}

	private JButton getBtnGrupHepsiniGetir() {
		if (btnGrupHepsiniGetir == null) {
			btnGrupHepsiniGetir = new JButton("Hepsini Getir");
			btnGrupHepsiniGetir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnGetAllGroups_ActionPerformed();

				}
			});
			btnGrupHepsiniGetir.setBounds(207, 502, 139, 23);
		}
		return btnGrupHepsiniGetir;
	}

	protected void btnGetAllGroups_ActionPerformed() {
		GroupsDao dao = new GroupsDao();
		List<Groups> liste = dao.getAll(new Groups());
		String[] columnNames = { "id", "Kurs Adı", "Öğrenci Sayısı", "Başlama Tarihi", "Bitiş Tarihi", "Günler", "Sınıf adı", "Öğretmen Adı" };
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = "" + liste.get(i).getId();
			data[i][1] = "" + liste.get(i).getAdi();
			data[i][2] = "" + liste.get(i).getOgrenciSayisi();
			data[i][3] = "" + liste.get(i).getBaslamaTarihi();
			data[i][4] = "" + liste.get(i).getBitisTarihi();
			data[i][5] = "" + liste.get(i).getDays();
			data[i][6] = "" + liste.get(i).getLessonClass();
			data[i][7] = "" + liste.get(i).getTeacher();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tblGrupKurs.setModel(model);

	}

	private JButton getBtnSinifEkle() {
		if (btnSinifEkle == null) {
			btnSinifEkle = new JButton("+");
			btnSinifEkle.setBounds(606, 28, 43, 19);
			btnSinifEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LessonClassFrame().setVisible(true);
				}
			});
		}
		return btnSinifEkle;
	}

	private JButton getBtnAddTeacher() {
		if (btnAddTeacher == null) {
			btnAddTeacher = new JButton("+");
			btnAddTeacher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAddTeacher_Action_Performed();
				}
			});
			btnAddTeacher.setBounds(285, 83, 51, 25);
		}
		return btnAddTeacher;
	}

	protected void btnAddTeacher_Action_Performed() {
		new AddTeacherFrame(ManagementFrame.this).setVisible(true);

	}

	private JButton getBtnAddDays() {
		if (btnAddDays == null) {
			btnAddDays = new JButton("+");
			btnAddDays.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DaysFrame().setVisible(true);
				}
			});
			btnAddDays.setBounds(606, 56, 43, 19);
		}
		return btnAddDays;
	}
	private JDateChooser getDateBasTarihi() {
		if (dateBasTarihi == null) {
			dateBasTarihi = new JDateChooser();
			dateBasTarihi.setBounds(461, 83, 131, 22);
		}
		return dateBasTarihi;
	}
	private JDateChooser getDateBitTarihi() {
		if (dateBitTarihi == null) {
			dateBitTarihi = new JDateChooser();
			dateBitTarihi.setBounds(461, 108, 133, 22);
		}
		return dateBitTarihi;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Kurs Öğretmeni :");
			label.setBounds(10, 36, 133, 14);
		}
		return label;
	}
	private JComboBox getCmbCourseSelect() {
		if (cmbCourseSelect == null) {
			cmbCourseSelect = new JComboBox();
			cmbCourseSelect.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					JOptionPane.showMessageDialog(ManagementFrame.this, cmbCourseSelect.getSelectedItem().toString());
				}
			});
			cmbCourseSelect.setBounds(153, 31, 131, 24);
		}
		return cmbCourseSelect;
	}
	private JButton getBtnAddCourses() {
		if (btnAddCourses == null) {
			btnAddCourses = new JButton("+");
			btnAddCourses.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CoursesFrame(ManagementFrame.this).setVisible(true);
				}
			});
			btnAddCourses.setBounds(285, 31, 51, 25);
		}
		return btnAddCourses;
	}

	@Override
	public void callBack(CallBackType callback) {
		if(callback == CallBackType.One) {
			fillCoursesCombo();
		}
		else if (callback == CallBackType.Two) {
			fillTeacherCombo();
		}
		
	}
}
