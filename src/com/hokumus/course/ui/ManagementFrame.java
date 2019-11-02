package com.hokumus.course.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
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

public class ManagementFrame extends JFrame{
	private JMenuBar menuBar;
	private JMenu mnDuzenle;
	private JMenu mnKursGruplari;
	private JMenuItem mnitmOgrKGS;
	private JMenuItem mnitmKursKGS;
	private JMenuItem mnitmJavaKursu;
	private JMenuItem mnitmPhpKursu;
	private JPanel pnlGirisEkrani;
	private JLabel lblOgrAdi;
	private JLabel lblOgrSoyadi;
	private JLabel lblOgrUcret;
	private JLabel lblTelefonNo;
	private JLabel lblEmail;
	private JLabel lblOgrAdres;
	private JTextField txtOgrAdi;
	private JTextField txtOgrSoyadi;
	private JTextField txtOgrUcreti;
	private JTextField txtTelefonNo;
	private JTextField txtEmail;
	private JTextPane txtpOgrAdres;
	private JLabel lblKayitTarihi;
	private JTextField txtKayitTarihi;
	private JButton btnKaydet;
	private JButton btnGuncelle;
	private JButton btnSil;
	private int selectedRowId;
	private JScrollPane scrollTeacher;
	private JTable tblTeacher;
	private JButton btnOgrHepsiniGetir;
	private JPanel pnlGrupKursEklemeEkrani;
	private JLabel lblKursAdi;
	private JLabel lblKursOgr;
	private JLabel lblBasTarihi;
	private JLabel lblSinifAdi;
	private JLabel lblKursGunleri;
	private JLabel lblrenciSays;
	private JTextField txtKursAdi;
	private JTextField txtBasTarihi;
	private JTextField txtSinifAdi;
	private JLabel lblBitTarihi;
	private JTextField txtBitTarihi;
	private JButton btnKaydetKurs;
	private JButton btnGuncelleKurs;
	private JButton btnSilKurs;
	private JTextField txtOgrenciSayisi;
	private JComboBox cmbKursGunleri;
	private JComboBox cmbTeacher;
	private JScrollPane scrollGrupKurs;
	private JTable tblGrupKurs;
	private JButton btnGrupHepsiniGetir;
	
	
	
	public ManagementFrame() {

		initialize();
		//pnlGirisEkrani.setVisible(false);
		//pnlKursEklemeEkrani.setVisible(false);
	}
	
	private void initialize() {
		getContentPane().setLayout(null);
		setSize(600,735);
		getContentPane().add(getMenuBar_1());
		getContentPane().add(getPnlGirisEkrani());
		getContentPane().add(getPnlGrupKursEklemeEkrani());
		setVisible(false);
		
		TeacherDao dao = new TeacherDao();
		List<Teacher> liste  = dao.getAll(new Teacher());
		Teacher [] data = new Teacher[liste.size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = liste.get(i);
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(data);
		cmbTeacher.setModel(model);
		
		DaysDao ddao= new DaysDao();
		List<Days> dliste = ddao.getAll(new Days());
		Days [] ddata = new Days[dliste.size()];
		for (int i = 0; i < ddata.length; i++) {
			ddata[i] = dliste.get(i);
		}
		
		DefaultComboBoxModel cmodel = new DefaultComboBoxModel(ddata);
		cmbKursGunleri.setModel(cmodel);
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 584, 21);
			menuBar.add(getMnDuzenle());
			menuBar.add(getMnKursGruplari());
		}
		return menuBar;
	}
	private JMenu getMnDuzenle() {
		if (mnDuzenle == null) {
			mnDuzenle = new JMenu("Düzenle");
			mnDuzenle.add(getMnitmOgrKGS());
			mnDuzenle.add(getMnitmKursKGS());
		}
		return mnDuzenle;
	}
	private JMenu getMnKursGruplari() {
		if (mnKursGruplari == null) {
			mnKursGruplari = new JMenu("Kurs Grupları");
			mnKursGruplari.add(getMnitmJavaKursu());
			mnKursGruplari.add(getMnitmPhpKursu());
		}
		return mnKursGruplari;
	}
	private JMenuItem getMnitmOgrKGS() {
		if (mnitmOgrKGS == null) {
			mnitmOgrKGS = new JMenuItem("Öğretmen K-G-S");
			mnitmOgrKGS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//	pnlGirisEkrani.setVisible(false);
					pnlGirisEkrani.setVisible(true);
				
				}
			});
		}
		return mnitmOgrKGS;
	}
	private JMenuItem getMnitmKursKGS() {
		if (mnitmKursKGS == null) {
			mnitmKursKGS = new JMenuItem("Kurs K-G-S");
			mnitmKursKGS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pnlGrupKursEklemeEkrani.setVisible(true);
					
				}
			});
		}
		return mnitmKursKGS;
	}
	private JMenuItem getMnitmJavaKursu() {
		if (mnitmJavaKursu == null) {
			mnitmJavaKursu = new JMenuItem("Java Kursu");
		}
		return mnitmJavaKursu;
	}
	private JMenuItem getMnitmPhpKursu() {
		if (mnitmPhpKursu == null) {
			mnitmPhpKursu = new JMenuItem("PHP Kursu");
		}
		return mnitmPhpKursu;
	}
	private JPanel getPnlGirisEkrani() {
		if (pnlGirisEkrani == null) {
			pnlGirisEkrani = new JPanel();
			pnlGirisEkrani.addComponentListener(new ComponentAdapter() {
			
				@Override
				public void componentHidden(ComponentEvent arg0) {
					pnlGirisEkrani.setVisible(true);
				}
			});
			pnlGirisEkrani.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u00D6\u011Fretmen Bilgileri Kay\u0131t Ekran\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlGirisEkrani.setBounds(10, 32, 564, 343);
			pnlGirisEkrani.setLayout(null);
			pnlGirisEkrani.add(getLblOgrAdi());
			pnlGirisEkrani.add(getLblOgrSoyadi());
			pnlGirisEkrani.add(getLblOgrUcret());
			pnlGirisEkrani.add(getLblTelefonNo());
			pnlGirisEkrani.add(getLblEmail());
			pnlGirisEkrani.add(getLblOgrAdres());
			pnlGirisEkrani.add(getTxtOgrAdi());
			pnlGirisEkrani.add(getTxtOgrSoyadi());
			pnlGirisEkrani.add(getTxtOgrUcreti());
			pnlGirisEkrani.add(getTxtTelefonNo());
			pnlGirisEkrani.add(getTxtEmail());
			pnlGirisEkrani.add(getTxtpOgrAdres());
			pnlGirisEkrani.add(getLblKayitTarihi());
			pnlGirisEkrani.add(getTxtKayitTarihi());
			pnlGirisEkrani.add(getBtnKaydet());
			pnlGirisEkrani.add(getBtnGuncelle());
			pnlGirisEkrani.add(getBtnSil());
			pnlGirisEkrani.add(getBtnOgrHepsiniGetir());
			pnlGirisEkrani.add(getScrollTeacher());

		}
		return pnlGirisEkrani;
	}
	private JLabel getLblOgrAdi() {
		if (lblOgrAdi == null) {
			lblOgrAdi = new JLabel("Öğretmen Adı :");
			lblOgrAdi.setBounds(10, 31, 133, 14);
		}
		return lblOgrAdi;
	}
	private JLabel getLblOgrSoyadi() {
		if (lblOgrSoyadi == null) {
			lblOgrSoyadi = new JLabel("Öğretmen Soyadı :");
			lblOgrSoyadi.setBounds(10, 56, 133, 14);
		}
		return lblOgrSoyadi;
	}
	private JLabel getLblOgrUcret() {
		if (lblOgrUcret == null) {
			lblOgrUcret = new JLabel("Öğretmen Ücreti :");
			lblOgrUcret.setBounds(296, 90, 103, 14);
		}
		return lblOgrUcret;
	}
	private JLabel getLblTelefonNo() {
		if (lblTelefonNo == null) {
			lblTelefonNo = new JLabel("Telefon No :");
			lblTelefonNo.setBounds(296, 31, 103, 14);
		}
		return lblTelefonNo;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email :");
			lblEmail.setBounds(296, 62, 103, 14);
		}
		return lblEmail;
	}
	private JLabel getLblOgrAdres() {
		if (lblOgrAdres == null) {
			lblOgrAdres = new JLabel("Öğretmen Adres :");
			lblOgrAdres.setBounds(10, 81, 133, 14);
		}
		return lblOgrAdres;
	}
	private JTextField getTxtOgrAdi() {
		if (txtOgrAdi == null) {
			txtOgrAdi = new JTextField();
			txtOgrAdi.setBounds(153, 31, 133, 20);
			txtOgrAdi.setColumns(10);
		}
		return txtOgrAdi;
	}
	private JTextField getTxtOgrSoyadi() {
		if (txtOgrSoyadi == null) {
			txtOgrSoyadi = new JTextField();
			txtOgrSoyadi.setColumns(10);
			txtOgrSoyadi.setBounds(153, 56, 133, 20);
		}
		return txtOgrSoyadi;
	}
	private JTextField getTxtOgrUcreti() {
		if (txtOgrUcreti == null) {
			txtOgrUcreti = new JTextField();
			txtOgrUcreti.setColumns(10);
			txtOgrUcreti.setBounds(409, 87, 133, 20);
		}
		return txtOgrUcreti;
	}
	private JTextField getTxtTelefonNo() {
		if (txtTelefonNo == null) {
			txtTelefonNo = new JTextField();
			txtTelefonNo.setColumns(10);
			txtTelefonNo.setBounds(409, 28, 133, 20);
		}
		return txtTelefonNo;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(409, 59, 133, 20);
		}
		return txtEmail;
	}
	private JTextPane getTxtpOgrAdres() {
		if (txtpOgrAdres == null) {
			txtpOgrAdres = new JTextPane();
			txtpOgrAdres.setBounds(153, 84, 133, 100);
		}
		return txtpOgrAdres;
	}
	private JLabel getLblKayitTarihi() {
		if (lblKayitTarihi == null) {
			lblKayitTarihi = new JLabel("Kayıt Tarihi :");
			lblKayitTarihi.setBounds(296, 118, 103, 14);
		}
		return lblKayitTarihi;
	}
	private JTextField getTxtKayitTarihi() {
		if (txtKayitTarihi == null) {
			txtKayitTarihi = new JTextField();
			txtKayitTarihi.setColumns(10);
			txtKayitTarihi.setBounds(409, 115, 133, 20);
		}
		return txtKayitTarihi;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(txtOgrAdi.getText().equals("")) {
						JOptionPane.showMessageDialog(ManagementFrame.this, "Kullanıcı Adı Boş Geçilemez!!!");
						return;
					}
					if(txtOgrSoyadi.getText().equals("")) {
						JOptionPane.showMessageDialog(ManagementFrame.this, "Sifre Boş Geçilemez!!!");
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
			btnKaydet.setBounds(135, 208, 89, 23);
		}
		return btnKaydet;
	}
	private JButton getBtnGuncelle() {
		if (btnGuncelle == null) {
			btnGuncelle = new JButton("Güncelle");
			btnGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnUpdate_Action_Performed();
				}
			});
			btnGuncelle.setBounds(234, 208, 89, 23);
		}
		return btnGuncelle;
	}
	
	protected void btnUpdate_Action_Performed() {
		TeacherDao dao = new TeacherDao();
		Teacher temp = new Teacher();
		temp.setAd(txtOgrAdi.getText());
		temp.setSoyad(txtOgrSoyadi.getText());
		temp.setAdres(txtpOgrAdres.getText());
		temp.setTel(txtTelefonNo.getText());
		temp.setMail(txtEmail.getText());
//		temp.setUcret(txtOgrUcreti.getText());
//		temp.setKayitTarihi(txtKayitTarihi.getText());
		temp.setCreatedTime(Calendar.getInstance().getTime());
		temp.setCreaterBy(CourseUtils.loginedUser.getUserName());
		dao.update(temp);
		
	}
	
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("Sil");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnDelete_ActionPerformed();
				}
			});
			btnSil.setBounds(333, 208, 89, 23);
		}
		return btnSil;
		
	}
	protected void btnDelete_ActionPerformed() {
		TeacherDao dao = new TeacherDao();
		Teacher temp = new Teacher();
		temp.setId((long) selectedRowId);
		dao.delete(temp);
}
	private JScrollPane getScrollTeacher() {
		if (scrollTeacher == null) {
			scrollTeacher = new JScrollPane();
			scrollTeacher.setBounds(10, 233, 543, 73);
			scrollTeacher.setViewportView(getTblTeacher());
		}
		return scrollTeacher;
	}
	private JTable getTblTeacher() {
		if (tblTeacher == null) {
			tblTeacher = new JTable();
			tblTeacher.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					tblTeacher_Row_Selected();
				}
			});
			tblTeacher.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
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
	private JButton getBtnOgrHepsiniGetir() {
		if (btnOgrHepsiniGetir == null) {
			btnOgrHepsiniGetir = new JButton("Hepsini Getir");
			btnOgrHepsiniGetir.setBounds(214, 309, 139, 23);
			btnOgrHepsiniGetir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnGetAllUserInf_ActionPerformed();
				}
			});
		}
		return btnOgrHepsiniGetir;
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
	private JPanel getPnlGrupKursEklemeEkrani() {
		if (pnlGrupKursEklemeEkrani == null) {
			pnlGrupKursEklemeEkrani = new JPanel();
			pnlGrupKursEklemeEkrani.setBounds(10, 386, 564, 291);
			pnlGrupKursEklemeEkrani.setLayout(null);
			pnlGrupKursEklemeEkrani.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Grup Kurs Ekleme Ekran\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlGrupKursEklemeEkrani.add(getLblKursAdi());
			pnlGrupKursEklemeEkrani.add(getLblKursOgr());
			pnlGrupKursEklemeEkrani.add(getLblBasTarihi());
			pnlGrupKursEklemeEkrani.add(getLblSinifAdi());
			pnlGrupKursEklemeEkrani.add(getLblKursGunleri());
			pnlGrupKursEklemeEkrani.add(getLblrenciSays());
			pnlGrupKursEklemeEkrani.add(getTxtKursAdi());
			pnlGrupKursEklemeEkrani.add(getTxtBasTarihi());
			pnlGrupKursEklemeEkrani.add(getTxtSinifAdi());
			pnlGrupKursEklemeEkrani.add(getLblBitTarihi());
			pnlGrupKursEklemeEkrani.add(getTxtBitTarihi());
			pnlGrupKursEklemeEkrani.add(getBtnKaydetKurs());
			pnlGrupKursEklemeEkrani.add(getBtnGuncelleKurs());
			pnlGrupKursEklemeEkrani.add(getBtnSilKurs());
			pnlGrupKursEklemeEkrani.add(getTxtOgrenciSayisi());
			pnlGrupKursEklemeEkrani.add(getCmbKursGunleri());
			pnlGrupKursEklemeEkrani.add(getCmbTeacher());
			pnlGrupKursEklemeEkrani.add(getScrollGrupKurs());
			pnlGrupKursEklemeEkrani.add(getBtnGrupHepsiniGetir());

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
			lblBasTarihi.setBounds(296, 81, 103, 14);
		}
		return lblBasTarihi;
	}
	private JLabel getLblSinifAdi() {
		if (lblSinifAdi == null) {
			lblSinifAdi = new JLabel("Sınıf Adı :");
			lblSinifAdi.setBounds(296, 31, 103, 14);
		}
		return lblSinifAdi;
	}
	private JLabel getLblKursGunleri() {
		if (lblKursGunleri == null) {
			lblKursGunleri = new JLabel("Kurs Günleri :");
			lblKursGunleri.setBounds(296, 56, 103, 14);
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
	private JTextField getTxtBasTarihi() {
		if (txtBasTarihi == null) {
			txtBasTarihi = new JTextField();
			txtBasTarihi.setColumns(10);
			txtBasTarihi.setBounds(409, 78, 133, 20);
		}
		return txtBasTarihi;
	}
	private JTextField getTxtSinifAdi() {
		if (txtSinifAdi == null) {
			txtSinifAdi = new JTextField();
			txtSinifAdi.setColumns(10);
			txtSinifAdi.setBounds(409, 28, 133, 20);
		}
		return txtSinifAdi;
	}
	private JLabel getLblBitTarihi() {
		if (lblBitTarihi == null) {
			lblBitTarihi = new JLabel("Bitiş Tarihi :");
			lblBitTarihi.setBounds(296, 106, 103, 14);
		}
		return lblBitTarihi;
	}
	private JTextField getTxtBitTarihi() {
		if (txtBitTarihi == null) {
			txtBitTarihi = new JTextField();
			txtBitTarihi.setColumns(10);
			txtBitTarihi.setBounds(409, 103, 133, 20);
		}
		return txtBitTarihi;
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
					d.setGun1(6);
					d.setGun2(7);
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
					
					
					
					Groups g = new  Groups();
					g.setAdi("Java 44");
					g.setBaslamaTarihi(Calendar.getInstance().getTime());
					g.setBitisTarihi(Calendar.getInstance().getTime());
					g.setCourses(temp);
					g.setDays(d);
					g.setLessonClass(lc);
					g.setOgrenciSayisi(Integer.parseInt(txtOgrenciSayisi.getText()));
					g.setTeacher((Teacher)cmbTeacher.getSelectedItem());
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
			cmbKursGunleri.setBounds(409, 53, 133, 20);
			
			
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
			scrollGrupKurs.setBounds(10, 178, 543, 73);
			scrollGrupKurs.setColumnHeaderView(getTblGrupKurs());
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
		txtOgrAdi.setText(tblGrupKurs.getModel().getValueAt(row, 1).toString());
		txtOgrSoyadi.setText(tblGrupKurs.getModel().getValueAt(row, 2).toString());
		txtpOgrAdres.setText(tblGrupKurs.getModel().getValueAt(row, 3).toString());
		txtTelefonNo.setText(tblGrupKurs.getModel().getValueAt(row, 4).toString());
		txtEmail.setText(tblGrupKurs.getModel().getValueAt(row, 5).toString());
		txtOgrUcreti.setText(tblGrupKurs.getModel().getValueAt(row, 6).toString());
		txtKayitTarihi.setText(tblGrupKurs.getModel().getValueAt(row, 7).toString());
}
	private JButton getBtnGrupHepsiniGetir() {
		if (btnGrupHepsiniGetir == null) {
			btnGrupHepsiniGetir = new JButton("Hepsini Getir");
			btnGrupHepsiniGetir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnGrupHepsiniGetir.setBounds(222, 255, 139, 23);
		}
		return btnGrupHepsiniGetir;
	}
	
	protected void btnGetAllGroups_ActionPerformed() {
		GroupsDao dao = new GroupsDao();
		List<Groups> liste = dao.getAll(new Groups());
		String[] columnNames = { "id", "Adı", "Soyadı", "Adres", "Telefon", "E mail", "Ücret", "Kayıt Tarihi" };
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
}

