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
	private JMenuItem mn�tmHuseyinOkumus;
	private JMenu mnKurslar;
	private JMenuItem mn�tmJavaKursu;
	private JMenuItem mn�tmCKursu;
	private JMenuItem mn�tmPhpKursu;
	private JMenuItem mn�tmDreamveawerKursu;
	private JMenu mnrenciler;
	private JMenuItem mn�tmJavaKursuOgrencileri;
	private JMenuItem mn�tmCKursuOgrencileri;
	private JMenuItem mn�tmPhpKursuOgrencileri;
	private JMenuItem mn�tmDreamveawerKursuOgrencileri;
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
		setTitle("Y�netici Y�netim Paneli");
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
			mnogretmenler.add(getMn�tmHuseyinOkumus());
		}
		return mnogretmenler;
	}

	private JMenuItem getMn�tmHuseyinOkumus() {
		if (mn�tmHuseyinOkumus == null) {
			mn�tmHuseyinOkumus = new JMenuItem("T\u00FCm \u00D6\u011Fretmenler");
			mn�tmHuseyinOkumus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TeacherModelDao dao = new TeacherModelDao();
					List<TeacherModel> liste = dao.getAll(new TeacherModel());
					String[] columnNames = { "id", "Ad�", "Kullan�c� Ad�", "Pasword", "Yetki", "E mail", "Telefon No" };
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
		return mn�tmHuseyinOkumus;
	}

	private JMenu getMnKurslar() {
		if (mnKurslar == null) {
			mnKurslar = new JMenu("Kurslar");
			mnKurslar.add(getMn�tmJavaKursu());
			mnKurslar.add(getMn�tmCKursu());
			mnKurslar.add(getMn�tmPhpKursu());
			mnKurslar.add(getMn�tmDreamveawerKursu());
		}
		return mnKurslar;
	}

	private JMenuItem getMn�tmJavaKursu() {
		if (mn�tmJavaKursu == null) {
			mn�tmJavaKursu = new JMenuItem("Java Kursu");
			mn�tmJavaKursu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CourseModelDao dao = new CourseModelDao();
					List<CourseModel> liste = dao.getAll(new CourseModel());
					String[] columnNames = { "id", "Ad�", "Kullan�c� Ad�", "Pasword", "Yetki", "E mail", "Telefon No" };
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
		return mn�tmJavaKursu;
	}

	private JMenuItem getMn�tmCKursu() {
		if (mn�tmCKursu == null) {
			mn�tmCKursu = new JMenuItem("C# Kursu");
		}
		return mn�tmCKursu;
	}

	private JMenuItem getMn�tmPhpKursu() {
		if (mn�tmPhpKursu == null) {
			mn�tmPhpKursu = new JMenuItem("PHP Kursu");
		}
		return mn�tmPhpKursu;
	}

	private JMenuItem getMn�tmDreamveawerKursu() {
		if (mn�tmDreamveawerKursu == null) {
			mn�tmDreamveawerKursu = new JMenuItem("Dreamveawer Kursu");
		}
		return mn�tmDreamveawerKursu;
	}

	private JMenu getMnrenciler() {
		if (mnrenciler == null) {
			mnrenciler = new JMenu("Kurs \u00D6\u011Frencileri");
			mnrenciler.add(getMn�tmJavaKursuOgrencileri());
			mnrenciler.add(getMn�tmCKursuOgrencileri());
			mnrenciler.add(getMn�tmPhpKursuOgrencileri());
			mnrenciler.add(getMn�tmDreamveawerKursuOgrencileri());
		}
		return mnrenciler;
	}

	private JMenuItem getMn�tmJavaKursuOgrencileri() {
		if (mn�tmJavaKursuOgrencileri == null) {
			mn�tmJavaKursuOgrencileri = new JMenuItem("Java Kursu \u00D6\u011Frencileri");
		}
		return mn�tmJavaKursuOgrencileri;
	}

	private JMenuItem getMn�tmCKursuOgrencileri() {
		if (mn�tmCKursuOgrencileri == null) {
			mn�tmCKursuOgrencileri = new JMenuItem("C# Kursu \u00D6\u011Frencileri");
		}
		return mn�tmCKursuOgrencileri;
	}

	private JMenuItem getMn�tmPhpKursuOgrencileri() {
		if (mn�tmPhpKursuOgrencileri == null) {
			mn�tmPhpKursuOgrencileri = new JMenuItem("PHP Kursu \u00D6\u011Frencileri");
		}
		return mn�tmPhpKursuOgrencileri;
	}

	private JMenuItem getMn�tmDreamveawerKursuOgrencileri() {
		if (mn�tmDreamveawerKursuOgrencileri == null) {
			mn�tmDreamveawerKursuOgrencileri = new JMenuItem("Dreamveawer Kursu \u00D6\u011Frencileri");
		}
		return mn�tmDreamveawerKursuOgrencileri;
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
			JOptionPane.showMessageDialog(YoneticiFrame.this, "Kullan�c� Ad� Bo� Ge�ilemez!!!");
			return;
		}
		if(txtOgrSoyadi.getText().equals("")) {
			JOptionPane.showMessageDialog(YoneticiFrame.this, "Sifre Bo� Ge�ilemez!!!");
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
