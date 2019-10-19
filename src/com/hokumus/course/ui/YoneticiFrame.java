package com.hokumus.course.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.CourseModelDao;
import com.hokumus.course.dao.TeacherModelDao;
import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.CourseModel;
import com.hokumus.course.model.CourseNames;
import com.hokumus.course.model.TeacherModel;
import com.hokumus.course.model.UserModel;
import com.hokumus.course.model.UserPermission;
import com.hokumus.course.utils.CourseUtils;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class YoneticiFrame extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnogretmenler;
	private JMenuItem mnýtmHuseyinOkumus;
	private JMenu mnKurslar;
	private JMenuItem mnýtmJavaKursu;
	private JMenuItem mnýtmCKursu;
	private JMenuItem mnýtmPhpKursu;
	private JMenuItem mnýtmDreamveawerKursu;
	private JMenu mnrenciler;
	private JMenuItem mnýtmJavaKursuOgrencileri;
	private JMenuItem mnýtmCKursuOgrencileri;
	private JMenuItem mnýtmPhpKursuOgrencileri;
	private JMenuItem mnýtmDreamveawerKursuOgrencileri;
	private JPanel pnlOgrBilgi;
	private JScrollPane scrollPane;
	private JScrollPane scrollOgrBilgi;
	private JTable tblOgrBilgi;
	private JMenuItem mnitmretmenEkle;
	private JLabel lblOgrAdi;
	private JLabel lblOgrSoyadi;
	private JLabel lblEgitimDali;
	private JLabel lblTelefonNo;
	private JTextField txtOgrAdi;
	private JTextField txtOgrSoyadi;
	private JTextField txtTelefonNo;
	private JComboBox cmbEgitimDali;
	private JButton btnOgrEkle;
	private JPanel panel;

	public YoneticiFrame() {

		initialize();
	}

	private void initialize() {
		setTitle("Yönetici Yönetim Paneli");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getMenuBar_1());
		getContentPane().add(getPnlOgrBilgi());
		getContentPane().add(getPanel());

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 584, 25);
			menuBar.add(getMnogretmenler());
			menuBar.add(getMnKurslar());
			menuBar.add(getMnrenciler());
		}
		return menuBar;
	}

	private JMenu getMnogretmenler() {
		if (mnogretmenler == null) {
			mnogretmenler = new JMenu("\u00D6\u011Fretmenler");
			mnogretmenler.add(getMnitmretmenEkle());
			mnogretmenler.add(getMnýtmHuseyinOkumus());
		}
		return mnogretmenler;
	}

	private JMenuItem getMnýtmHuseyinOkumus() {
		if (mnýtmHuseyinOkumus == null) {
			mnýtmHuseyinOkumus = new JMenuItem("T\u00FCm \u00D6\u011Fretmenler");
			mnýtmHuseyinOkumus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TeacherModelDao dao = new TeacherModelDao();
					List<TeacherModel> liste = dao.getAll(new TeacherModel());
					String[] columnNames = { "id", "Adý", "Kullanýcý Adý", "Pasword", "Yetki", "E mail", "Telefon No" };
					String[][] data = new String[liste.size()][columnNames.length];
					for (int i = 0; i < liste.size(); i++) {
						data[i][0] = "" + liste.get(i).getId();
						data[i][1] = "" + liste.get(i).getName();
						data[i][2] = "" + liste.get(i).getUserName();
						data[i][3] = "" + liste.get(i).getPassword();
						data[i][4] = "" + liste.get(i).getPermission();
						data[i][5] = "" + liste.get(i).getEmail();
						data[i][6] = "" + liste.get(i).getCellPhone();
					}
					DefaultTableModel model = new DefaultTableModel(data, columnNames);
					tblOgrBilgi.setModel(model);
				}
			});
		}
		return mnýtmHuseyinOkumus;
	}

	private JMenu getMnKurslar() {
		if (mnKurslar == null) {
			mnKurslar = new JMenu("Kurslar");
			mnKurslar.add(getMnýtmJavaKursu());
			mnKurslar.add(getMnýtmCKursu());
			mnKurslar.add(getMnýtmPhpKursu());
			mnKurslar.add(getMnýtmDreamveawerKursu());
		}
		return mnKurslar;
	}

	private JMenuItem getMnýtmJavaKursu() {
		if (mnýtmJavaKursu == null) {
			mnýtmJavaKursu = new JMenuItem("Java Kursu");
			mnýtmJavaKursu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CourseModelDao dao = new CourseModelDao();
					List<CourseModel> liste = dao.getAll(new CourseModel());
					String[] columnNames = { "id", "Adý", "Kullanýcý Adý", "Pasword", "Yetki", "E mail", "Telefon No" };
					String[][] data = new String[liste.size()][columnNames.length];
					for (int i = 0; i < liste.size(); i++) {
						data[i][0] = "" + liste.get(i).getId();
						data[i][1] = "" + liste.get(i).getCourseName();
						data[i][2] = "" + liste.get(i).getCourseTime();
						data[i][3] = "" + liste.get(i).getCourseTeacher();
						data[i][4] = "" + liste.get(i).getUserName();
						data[i][5] = "" + liste.get(i).getCellPhone();
						data[i][6] = "" + liste.get(i).getEmail();
					}
					DefaultTableModel model = new DefaultTableModel(data, columnNames);
					tblOgrBilgi.setModel(model);

				}
			});
		}
		return mnýtmJavaKursu;
	}

	private JMenuItem getMnýtmCKursu() {
		if (mnýtmCKursu == null) {
			mnýtmCKursu = new JMenuItem("C# Kursu");
		}
		return mnýtmCKursu;
	}

	private JMenuItem getMnýtmPhpKursu() {
		if (mnýtmPhpKursu == null) {
			mnýtmPhpKursu = new JMenuItem("PHP Kursu");
		}
		return mnýtmPhpKursu;
	}

	private JMenuItem getMnýtmDreamveawerKursu() {
		if (mnýtmDreamveawerKursu == null) {
			mnýtmDreamveawerKursu = new JMenuItem("Dreamveawer Kursu");
		}
		return mnýtmDreamveawerKursu;
	}

	private JMenu getMnrenciler() {
		if (mnrenciler == null) {
			mnrenciler = new JMenu("Kurs \u00D6\u011Frencileri");
			mnrenciler.add(getMnýtmJavaKursuOgrencileri());
			mnrenciler.add(getMnýtmCKursuOgrencileri());
			mnrenciler.add(getMnýtmPhpKursuOgrencileri());
			mnrenciler.add(getMnýtmDreamveawerKursuOgrencileri());
		}
		return mnrenciler;
	}

	private JMenuItem getMnýtmJavaKursuOgrencileri() {
		if (mnýtmJavaKursuOgrencileri == null) {
			mnýtmJavaKursuOgrencileri = new JMenuItem("Java Kursu \u00D6\u011Frencileri");
		}
		return mnýtmJavaKursuOgrencileri;
	}

	private JMenuItem getMnýtmCKursuOgrencileri() {
		if (mnýtmCKursuOgrencileri == null) {
			mnýtmCKursuOgrencileri = new JMenuItem("C# Kursu \u00D6\u011Frencileri");
		}
		return mnýtmCKursuOgrencileri;
	}

	private JMenuItem getMnýtmPhpKursuOgrencileri() {
		if (mnýtmPhpKursuOgrencileri == null) {
			mnýtmPhpKursuOgrencileri = new JMenuItem("PHP Kursu \u00D6\u011Frencileri");
		}
		return mnýtmPhpKursuOgrencileri;
	}

	private JMenuItem getMnýtmDreamveawerKursuOgrencileri() {
		if (mnýtmDreamveawerKursuOgrencileri == null) {
			mnýtmDreamveawerKursuOgrencileri = new JMenuItem("Dreamveawer Kursu \u00D6\u011Frencileri");
		}
		return mnýtmDreamveawerKursuOgrencileri;
	}

	private JPanel getPnlOgrBilgi() {
		if (pnlOgrBilgi == null) {
			pnlOgrBilgi = new JPanel();
			pnlOgrBilgi.setBounds(10, 77, 553, 220);
			pnlOgrBilgi.setBorder(new TitledBorder(null, "\u00D6\u011Fretmen Bilgileri", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			pnlOgrBilgi.setLayout(null);
			pnlOgrBilgi.add(getScrollOgrBilgi());

		}
		return pnlOgrBilgi;
	}

	private JScrollPane getScrollOgrInf() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();

		}
		return scrollPane;
	}

	private JScrollPane getScrollOgrBilgi() {
		if (scrollOgrBilgi == null) {
			scrollOgrBilgi = new JScrollPane();
			scrollOgrBilgi.setBounds(10, 29, 533, 180);
			scrollOgrBilgi.setViewportView(getTblOgrBilgi());
		}
		return scrollOgrBilgi;
	}

	private JTable getTblOgrBilgi() {
		if (tblOgrBilgi == null) {
			tblOgrBilgi = new JTable();
		}
		return tblOgrBilgi;
	}
	private JMenuItem getMnitmretmenEkle() {
		if (mnitmretmenEkle == null) {
			mnitmretmenEkle = new JMenuItem("\u00D6\u011Fretmen Ekle");
			mnitmretmenEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
				}
				
			});
		}
		return mnitmretmenEkle;
	}
	
	private JLabel getLblOgrAdi() {
		if (lblOgrAdi == null) {
			lblOgrAdi = new JLabel("\u00D6\u011Fretmenin Ad\u0131 :");
			lblOgrAdi.setBounds(10, 22, 126, 14);
		}
		return lblOgrAdi;
	}
	private JLabel getLblOgrSoyadi() {
		if (lblOgrSoyadi == null) {
			lblOgrSoyadi = new JLabel("\u00D6\u011Fretmenin Soyad\u0131 :");
			lblOgrSoyadi.setBounds(10, 47, 126, 14);
		}
		return lblOgrSoyadi;
	}
	private JLabel getLblEgitimDali() {
		if (lblEgitimDali == null) {
			lblEgitimDali = new JLabel("E\u011Fitim Dal\u0131 :");
			lblEgitimDali.setBounds(10, 72, 126, 14);
		}
		return lblEgitimDali;
	}
	private JLabel getLblTelefonNo() {
		if (lblTelefonNo == null) {
			lblTelefonNo = new JLabel("Telefon No :");
			lblTelefonNo.setBounds(10, 97, 126, 14);
		}
		return lblTelefonNo;
	}
	private JTextField getTxtOgrAdi() {
		if (txtOgrAdi == null) {
			txtOgrAdi = new JTextField();
			txtOgrAdi.setBounds(155, 22, 111, 20);
			txtOgrAdi.setColumns(10);
		}
		return txtOgrAdi;
	}
	private JTextField getTxtOgrSoyadi() {
		if (txtOgrSoyadi == null) {
			txtOgrSoyadi = new JTextField();
			txtOgrSoyadi.setBounds(155, 47, 111, 20);
			txtOgrSoyadi.setColumns(10);
		}
		return txtOgrSoyadi;
	}
	private JTextField getTxtTelefonNo() {
		if (txtTelefonNo == null) {
			txtTelefonNo = new JTextField();
			txtTelefonNo.setBounds(155, 97, 111, 20);
			txtTelefonNo.setColumns(10);
		}
		return txtTelefonNo;
	}
	private JComboBox getCmbEgitimDali() {
		if (cmbEgitimDali == null) {
			cmbEgitimDali = new JComboBox();
			
			DefaultComboBoxModel coursenames = new DefaultComboBoxModel(CourseNames.values());
			
			cmbEgitimDali.setBounds(155, 72, 111, 20);
			cmbEgitimDali.setModel(coursenames);
		}
		return cmbEgitimDali;
	}
	private JButton getBtnOgrEkle() {
		if (btnOgrEkle == null) {
			btnOgrEkle = new JButton("Ekle");
			btnOgrEkle.setBounds(155, 134, 111, 23);
			btnOgrEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnSave_Action_PerFormed();
				}
			});
		}
		return btnOgrEkle;
	}
	protected void btnSave_Action_PerFormed() {
		if(txtOgrAdi.getText().equals("")) {
			JOptionPane.showMessageDialog(YoneticiFrame.this, "Kullanýcý Adý Boþ Geçilemez!!!");
			return;
		}
		if(txtOgrSoyadi.getText().equals("")) {
			JOptionPane.showMessageDialog(YoneticiFrame.this, "Sifre Boþ Geçilemez!!!");
			return;
		}
		TeacherModelDao dao = new TeacherModelDao();
		TeacherModel temp = new TeacherModel();
		temp.setUserName(txtOgrAdi.getText());
		temp.setPassword(txtOgrSoyadi.getText());
		temp.setEgitimdali(cmbEgitimDali.getSelectedItem().toString());
		temp.setCellPhone(txtTelefonNo.getText());
		temp.setCreatedTime(Calendar.getInstance().getTime());
		temp.setCreaterBy(CourseUtils.loginedUser2.getUserName());
		dao.save(temp);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.addComponentListener(new ComponentAdapter() {
				
				
			});
			panel.setBounds(20, 308, 543, 220);
			panel.setLayout(null);
			panel.add(getLblOgrAdi());
			panel.add(getLblOgrSoyadi());
			panel.add(getLblEgitimDali());
			panel.add(getLblTelefonNo());
			panel.add(getTxtOgrAdi());
			panel.add(getTxtOgrSoyadi());
			panel.add(getTxtTelefonNo());
			panel.add(getCmbEgitimDali());
			panel.add(getBtnOgrEkle());
		}
		return panel;
	}
}
