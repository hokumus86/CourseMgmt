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
import com.hokumus.course.model.management.LessonClass;
import com.hokumus.course.model.teacher.Teacher;
import com.hokumus.course.utils.CourseUtils;
import com.toedter.calendar.JDateChooser;

public class ManagementFrame extends JFrame {
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
	private JButton btnGrupEkle;
	private JButton btnSinifEkle;
	private JButton btnKursEkle;
	private JButton btnAddTeacher;
	private JButton btnAddDays;
	private JDateChooser dateBasTarihi;
	private JDateChooser dateBitTarihi;

	public ManagementFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new MainFrame().setVisible(true);
			}
		});
		initialize();
		pnlGrupKursEklemeEkrani.setVisible(false);
	}

	private void initialize() {
		setTitle("Yönetici Paneli Ekranı");
		getContentPane().setLayout(null);
		setSize(746, 709);
		getContentPane().add(getPnlGrupKursEklemeEkrani());
		setVisible(false);

		TeacherDao dao = new TeacherDao();
		List<Teacher> liste = dao.getAll(new Teacher());
		Teacher[] data = new Teacher[liste.size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = liste.get(i);
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(data);
		cmbTeacher.setModel(model);

		DaysDao ddao = new DaysDao();
		List<Days> dliste = ddao.getAll(new Days());
		Days[] ddata = new Days[dliste.size()];
		for (int i = 0; i < ddata.length; i++) {
			ddata[i] = dliste.get(i);
		}

		DefaultComboBoxModel cmodel = new DefaultComboBoxModel(ddata);
		cmbKursGunleri.setModel(cmodel);
		getContentPane().add(getBtnGrupEkle());
		getContentPane().add(getBtnSinifEkle());
		getContentPane().add(getBtnKursEkle());
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
			pnlGrupKursEklemeEkrani.setBounds(12, 82, 671, 482);
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

		}
		return pnlGrupKursEklemeEkrani;
	}

	private JLabel getLblKursAdi() {
		if (lblKursAdi == null) {
			lblKursAdi = new JLabel("Kurs Adı :");
			lblKursAdi.setBounds(10, 31, 133, 14);
		}
		return lblKursAdi;
	}

	private JLabel getLblKursOgr() {
		if (lblKursOgr == null) {
			lblKursOgr = new JLabel("Kurs Öğretmeni :");
			lblKursOgr.setBounds(10, 56, 133, 14);
		}
		return lblKursOgr;
	}

	private JLabel getLblBasTarihi() {
		if (lblBasTarihi == null) {
			lblBasTarihi = new JLabel("Başlama Tarihi :");
			lblBasTarihi.setBounds(348, 84, 103, 14);
		}
		return lblBasTarihi;
	}

	private JLabel getLblSinifAdi() {
		if (lblSinifAdi == null) {
			lblSinifAdi = new JLabel("Sınıf Adı :");
			lblSinifAdi.setBounds(348, 34, 103, 14);
		}
		return lblSinifAdi;
	}

	private JLabel getLblKursGunleri() {
		if (lblKursGunleri == null) {
			lblKursGunleri = new JLabel("Kurs Günleri :");
			lblKursGunleri.setBounds(348, 59, 103, 14);
		}
		return lblKursGunleri;
	}

	private JLabel getLblrenciSays() {
		if (lblrenciSays == null) {
			lblrenciSays = new JLabel("Öğrenci Sayısı :");
			lblrenciSays.setBounds(10, 81, 133, 14);
		}
		return lblrenciSays;
	}

	private JTextField getTxtKursAdi() {
		if (txtKursAdi == null) {
			txtKursAdi = new JTextField();
			txtKursAdi.setColumns(10);
			txtKursAdi.setBounds(153, 28, 133, 20);
		}
		return txtKursAdi;
	}

	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setColumns(10);
			txtSinifAdi.setBounds(461, 31, 133, 20);
		}
		return txtSinifAdi;
	}

	private JLabel getLblBitTarihi() {
		if (lblBitTarihi == null) {
			lblBitTarihi = new JLabel("Bitiş Tarihi :");
			lblBitTarihi.setBounds(348, 109, 103, 14);
		}
		return lblBitTarihi;
	}

	private JButton getBtnKaydetKurs() {
		if (btnKaydetKurs == null) {
			btnKaydetKurs = new JButton("Kaydet");
			btnKaydetKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LessonClass lc = new LessonClass();
					lc.setAdi("Lab 2");
					lc.setKapasite(15);
					lc.setKod("LAB2");
					lc.setCreaterBy(CourseUtils.loginedUser.getUserName());
					lc.setCreatedTime(Calendar.getInstance().getTime());

					LessonsClassDao lcdao = new LessonsClassDao();
					lcdao.save(lc);

					Days d = new Days();
					d.setGun1(1);
					d.setGun2(2);
					d.setGun3(3);
					d.setGun4(4);
					d.setGun5(5);
					d.setGun6(6);
					d.setGun7(7);
					d.setSaat(4);
					DaysDao dd = new DaysDao();
					dd.save(d);

					CoursesDao daoc = new CoursesDao();
					Courses temp = new Courses();
					temp.setAdi(txtKursAdi.getText());
					temp.setbaslamaTarihi(Calendar.getInstance().getTime());
					temp.setCreatedTime(Calendar.getInstance().getTime());
					temp.setCreaterBy(CourseUtils.loginedUser.getUserName());
					temp.setDurum("Aktif");
					temp.setFiyat(new BigDecimal(Integer.parseInt("5000")));
					daoc.save(temp);

					Groups g = new Groups();
					g.setAdi("Java 44");
					g.setBaslamaTarihi(Calendar.getInstance().getTime());
					g.setBitisTarihi(Calendar.getInstance().getTime());
					g.setCourses(temp);
					g.setDays(d);
					g.setLessonClass(lc);
					g.setOgrenciSayisi(Integer.parseInt(txtOgrenciSayisi.getText()));
					g.setTeacher((Teacher) cmbTeacher.getSelectedItem());
					GroupsDao dao = new GroupsDao();
					dao.save(g);

				}
			});
			btnKaydetKurs.setBounds(137, 142, 89, 23);
		}
		return btnKaydetKurs;
	}

	private JButton getBtnGuncelleKurs() {
		if (btnGuncelleKurs == null) {
			btnGuncelleKurs = new JButton("Güncelle");
			btnGuncelleKurs.setBounds(236, 142, 89, 23);
		}
		return btnGuncelleKurs;
	}

	private JButton getBtnSilKurs() {
		if (btnSilKurs == null) {
			btnSilKurs = new JButton("Sil");
			btnSilKurs.setBounds(335, 142, 89, 23);
		}
		return btnSilKurs;
	}

	private JTextField getTxtOgrenciSayisi() {
		if (txtOgrenciSayisi == null) {
			txtOgrenciSayisi = new JTextField();
			txtOgrenciSayisi.setColumns(10);
			txtOgrenciSayisi.setBounds(153, 78, 133, 20);
		}
		return txtOgrenciSayisi;
	}

	private JComboBox getCmbKursGunleri() {
		if (cmbKursGunleri == null) {
			cmbKursGunleri = new JComboBox();
			cmbKursGunleri.setBounds(461, 53, 133, 20);

		}
		return cmbKursGunleri;
	}

	private JComboBox getCmbTeacher() {
		if (cmbTeacher == null) {
			cmbTeacher = new JComboBox();
			cmbTeacher.setBounds(153, 51, 131, 24);
		}
		return cmbTeacher;
	}

	private JScrollPane getScrollGrupKurs() {
		if (scrollGrupKurs == null) {
			scrollGrupKurs = new JScrollPane();
			scrollGrupKurs.setBounds(12, 178, 543, 255);
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
		//dateBasTarihi.setDate(new Date(tblGrupKurs.getModel().getValueAt(row, 3).toString()));
		//dateBitTarihi.setDate(new Date( tblGrupKurs.getModel().getValueAt(row, 4).toString()));
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
			btnGrupHepsiniGetir.setBounds(209, 446, 139, 23);
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

	private JButton getBtnGrupEkle() {
		if (btnGrupEkle == null) {
			btnGrupEkle = new JButton("Kurs Grubu Ekle");
			btnGrupEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnlGrupKursEklemeEkrani.setVisible(true);
				}
			});
			btnGrupEkle.setBounds(25, 34, 126, 25);
		}
		return btnGrupEkle;
	}

	private JButton getBtnSinifEkle() {
		if (btnSinifEkle == null) {
			btnSinifEkle = new JButton("Sınıf Ekle");
			btnSinifEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LessonClassFrame().setVisible(true);
				}
			});
			btnSinifEkle.setBounds(163, 34, 126, 25);
		}
		return btnSinifEkle;
	}

	private JButton getBtnKursEkle() {
		if (btnKursEkle == null) {
			btnKursEkle = new JButton("Kurs Ekle");
			btnKursEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CoursesFrame().setVisible(true);
				}
			});
			btnKursEkle.setBounds(301, 34, 126, 25);
		}
		return btnKursEkle;
	}

	private JButton getBtnAddTeacher() {
		if (btnAddTeacher == null) {
			btnAddTeacher = new JButton("+");
			btnAddTeacher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAddTeacher_Action_Performed();
				}
			});
			btnAddTeacher.setBounds(285, 51, 51, 25);
		}
		return btnAddTeacher;
	}

	protected void btnAddTeacher_Action_Performed() {
		new AddTeacherFrame().setVisible(true);

	}

	private JButton getBtnAddDays() {
		if (btnAddDays == null) {
			btnAddDays = new JButton("+");
			btnAddDays.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DaysFrame().setVisible(true);
				}
			});
			btnAddDays.setBounds(607, 51, 52, 25);
		}
		return btnAddDays;
	}
	private JDateChooser getDateBasTarihi() {
		if (dateBasTarihi == null) {
			dateBasTarihi = new JDateChooser();
			dateBasTarihi.setBounds(461, 84, 131, 22);
		}
		return dateBasTarihi;
	}
	private JDateChooser getDateBitTarihi() {
		if (dateBitTarihi == null) {
			dateBitTarihi = new JDateChooser();
			dateBitTarihi.setBounds(461, 109, 133, 22);
		}
		return dateBitTarihi;
	}
}
