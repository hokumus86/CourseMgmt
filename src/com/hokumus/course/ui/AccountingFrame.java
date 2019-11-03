package com.hokumus.course.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.IncomingsDao;
import com.hokumus.course.dao.StudentDao;
import com.hokumus.course.dao.StudentPaymentsDao;
import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.UserModel;
import com.hokumus.course.model.accounting.IncomeType;
import com.hokumus.course.model.ogrenci.Student;
import com.hokumus.course.model.ogrenci.StudentPayments;
import com.hokumus.course.utils.CourseUtils;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

public class AccountingFrame extends JFrame{
	private JMenuBar menuBar;
	private JMenu mnIslemler;
	private JMenuItem mntmKayitSorgula;
	private JMenuItem mntmCikis;
	private JMenu mnRaporlar;
	private JMenuItem mntmTamamlananKayitlar;
	private JMenuItem mntmOdemeBekleyenKayitler;
	private JPanel pnl_KayitSorgula;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txt_isim;
	private JTextField txt_soyisim;
	private JLabel lblKursKodu;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txt_sinifkodu;
	private JTextField txt_kursadi;
	private JTextField txt_tutarOdenecek;
	private JButton btnSorgula;
	private JButton btnNewButton;
	private JPanel pnl_TamamlananKayitlar;
	private JLabel lblTamamlananKayitlar;
	private JPanel pnl_OdemeBekleyen;
	private JLabel lblOdemeBekleyenKayitlar;
	private JScrollPane scrollPane;
	private JTable tbl_sorgula;
	private JScrollPane scrollPane_1;
	private JTable tbl_OdemeBekleyen;
	private JScrollPane scrollPane_2;
	private JTable tbl_tamamlanan;
	
	private int selectedRowId;
	
	public AccountingFrame() {
		initialize ();
		pnl_KayitSorgula.setVisible(false);
		pnl_OdemeBekleyen.setVisible(false);
		pnl_TamamlananKayitlar.setVisible(false);
	}

	private void initialize() {
		
		setTitle("Muhasebe");
		setSize(975,526);
		setJMenuBar(getMenuBar_1());
		getContentPane().setLayout(null);
		getContentPane().add(getPnl_KayitSorgula());
		getContentPane().add(getPnl_OdemeBekleyen());
		getContentPane().add(getPnl_TamamlananKayitlar());
		
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnIslemler());
			menuBar.add(getMnRaporlar());
		}
		return menuBar;
	}
	private JMenu getMnIslemler() {
		if (mnIslemler == null) {
			mnIslemler = new JMenu("Islemler");
			mnIslemler.add(getMntmKayitSorgula());
			mnIslemler.add(getMntmCikis());
		}
		return mnIslemler;
	}
	private JMenuItem getMntmKayitSorgula() {
		if (mntmKayitSorgula == null) {
			mntmKayitSorgula = new JMenuItem("Guncelle");
			mntmKayitSorgula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnl_KayitSorgula.setVisible(true);
					pnl_TamamlananKayitlar.setVisible(false);
					pnl_OdemeBekleyen.setVisible(false);
				}
			});
		}
		return mntmKayitSorgula;
	}
	private JMenuItem getMntmCikis() {
		if (mntmCikis == null) {
			mntmCikis = new JMenuItem("Cikis");
			mntmCikis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AccountingFrame.this.setVisible(false);
				}
			});
		}
		return mntmCikis;
	}
	private JMenu getMnRaporlar() {
		if (mnRaporlar == null) {
			mnRaporlar = new JMenu("Raporlar");
			mnRaporlar.add(getMntmTamamlananKayitlar());
			mnRaporlar.add(getMntmOdemeBekleyenKayitler());
		}
		return mnRaporlar;
	}
	private JMenuItem getMntmTamamlananKayitlar() {
		if (mntmTamamlananKayitlar == null) {
			mntmTamamlananKayitlar = new JMenuItem("Tamamlanan Kayitlar");
			mntmTamamlananKayitlar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnl_OdemeBekleyen.setVisible(false);
					pnl_KayitSorgula.setVisible(false);
					pnl_TamamlananKayitlar.setVisible(true);
					
					UserModelDao dao = new UserModelDao();
					List<UserModel> liste = dao.getAll(new UserModel());
					String[] columnNames = { "id", "Isim", "Soyisim", "Odeme Turu", "Sinif Kodu", "Kurs Adi", "Odenen Tutar"};
					String[][] data = new String[liste.size()][columnNames.length];
					for (int i = 0; i < liste.size(); i++) {
						
					}
					DefaultTableModel model = new DefaultTableModel(data, columnNames);
					tbl_tamamlanan.setModel(model);
				}
			});
		}
		return mntmTamamlananKayitlar;
	}
	private JMenuItem getMntmOdemeBekleyenKayitler() {
		if (mntmOdemeBekleyenKayitler == null) {
			mntmOdemeBekleyenKayitler = new JMenuItem("Odeme Bekleyen Kayitlar");
			mntmOdemeBekleyenKayitler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnl_KayitSorgula.setVisible(false);
					pnl_TamamlananKayitlar.setVisible(false);
					pnl_OdemeBekleyen.setVisible(true);
					
					UserModelDao dao = new UserModelDao();
					List<UserModel> liste = dao.getAll(new UserModel());
					String[] columnNames = { "id", "Isim", "Soyisim", "Odeme Turu", "Sinif Kodu", "Kurs Adi", "Odenen Tutar"};
					String[][] data = new String[liste.size()][columnNames.length];
					for (int i = 0; i < liste.size(); i++) {
						
					}
					DefaultTableModel model = new DefaultTableModel(data, columnNames);
					tbl_OdemeBekleyen.setModel(model);
				}
			});
		}
		return mntmOdemeBekleyenKayitler;
	}
	private JPanel getPnl_KayitSorgula() {
		if (pnl_KayitSorgula == null) {
			pnl_KayitSorgula = new JPanel();
			pnl_KayitSorgula.setBounds(6, 6, 945, 451);
			pnl_KayitSorgula.setLayout(null);
			pnl_KayitSorgula.add(getLblNewLabel());
			pnl_KayitSorgula.add(getLblNewLabel_1());
			pnl_KayitSorgula.add(getTxt_isim());
			pnl_KayitSorgula.add(getTxt_soyisim());
			pnl_KayitSorgula.add(getLblKursKodu());
			pnl_KayitSorgula.add(getLblNewLabel_3());
			pnl_KayitSorgula.add(getLblNewLabel_4());
			pnl_KayitSorgula.add(getTxt_sinifkodu());
			pnl_KayitSorgula.add(getTxt_kursadi());
			pnl_KayitSorgula.add(getTxt_tutarOdenecek());
			pnl_KayitSorgula.add(getBtnSorgula());
			pnl_KayitSorgula.add(getBtnNewButton());
			pnl_KayitSorgula.add(getScrollPane_1());
			
			JLabel lblNewLabel_2 = new JLabel("Odeme Turu");
			lblNewLabel_2.setBounds(44, 79, 72, 16);
			pnl_KayitSorgula.add(lblNewLabel_2);
			
			JComboBox cmbOdemeTuru = new JComboBox();
			cmbOdemeTuru.setBounds(120, 76, 202, 22);
			DefaultComboBoxModel odemeTuru = new DefaultComboBoxModel(IncomeType.values());
			cmbOdemeTuru.setModel(odemeTuru);
			pnl_KayitSorgula.add(cmbOdemeTuru);
			
			JButton btnYeniKayit = new JButton("Yeni Kayit");
			btnYeniKayit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StudentPayments temp_SP = new StudentPayments();
		 			temp_SP.setAciklama("JAVA");
		 			temp_SP.setOdemeMiktari(new BigDecimal(txt_tutarOdenecek.getText()));
		 			StudentPaymentsDao dao_sp = new StudentPaymentsDao();
		 			dao_sp.save(temp_SP);
					
				}
			});
			btnYeniKayit.setBounds(721, 47, 161, 26);
			pnl_KayitSorgula.add(btnYeniKayit);
		}
		return pnl_KayitSorgula;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Isim");
			lblNewLabel.setBounds(44, 24, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Soyisim");
			lblNewLabel_1.setBounds(44, 52, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTxt_isim() {
		if (txt_isim == null) {
			txt_isim = new JTextField();
			txt_isim.setBounds(120, 19, 202, 26);
			txt_isim.setColumns(10);
		}
		return txt_isim;
	}
	private JTextField getTxt_soyisim() {
		if (txt_soyisim == null) {
			txt_soyisim = new JTextField();
			txt_soyisim.setBounds(120, 47, 202, 26);
			txt_soyisim.setColumns(10);
		}
		return txt_soyisim;
	}
	private JLabel getLblKursKodu() {
		if (lblKursKodu == null) {
			lblKursKodu = new JLabel("Sinif Kodu");
			lblKursKodu.setBounds(365, 22, 85, 16);
		}
		return lblKursKodu;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Kurs Adi");
			lblNewLabel_3.setBounds(365, 50, 85, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Odenecek Tutar");
			lblNewLabel_4.setBounds(365, 79, 107, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTxt_sinifkodu() {
		if (txt_sinifkodu == null) {
			txt_sinifkodu = new JTextField();
			txt_sinifkodu.setBounds(455, 20, 202, 26);
			txt_sinifkodu.setColumns(10);
		}
		return txt_sinifkodu;
	}
	private JTextField getTxt_kursadi() {
		if (txt_kursadi == null) {
			txt_kursadi = new JTextField();
			txt_kursadi.setBounds(455, 48, 202, 26);
			txt_kursadi.setColumns(10);
		}
		return txt_kursadi;
	}
	private JTextField getTxt_tutarOdenecek() {
		if (txt_tutarOdenecek == null) {
			txt_tutarOdenecek = new JTextField();
			txt_tutarOdenecek.setBounds(455, 75, 202, 26);
			txt_tutarOdenecek.setColumns(10);
		}
		return txt_tutarOdenecek;
	}
	private JButton getBtnSorgula() {
		if (btnSorgula == null) {
			btnSorgula = new JButton("Sorgula");
			btnSorgula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentDao dao_student = new StudentDao();
					List<Student> list_student = dao_student.getAll(new Student());
					
					StudentPaymentsDao dao = new StudentPaymentsDao();
					List<StudentPayments> list_sp = dao.getAll(new StudentPayments());
					String[] columnNames = { "id", "Isim", "Soyisim", "Odeme Turu", "Sinif Kodu", "Kurs Adi", "Odenen Tutar"};
					String [] [] data = new String[list_sp.size()][columnNames.length];
					for (int i = 0; i < list_sp.size(); i++) {
						data[i][0] = "" + list_sp.get(i).getId();
						data[i][1] = "" + list_student.get(i).getAd();
						data[i][2] = "" + list_student.get(i).getSoyad();
						data[i][3] = "";
						data[i][4] = "";
						data[i][5] = "";
						data[i][6] = "" + list_sp.get(i).getOdemeMiktari();
					}
					DefaultTableModel model = new DefaultTableModel(data, columnNames);
					tbl_sorgula.setModel(model);
					
				}
			});
			btnSorgula.setBounds(721, 19, 161, 26);
		}
		return btnSorgula;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Guncelle");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StudentPayments temp_SP = new StudentPayments();
					temp_SP.setUpdaterBy(CourseUtils.loginedUser.getUserName());
					temp_SP.setOdemeTarihi(Calendar.getInstance().getTime());
					//temp_SP.setOdemeMiktari(new BigDecimal(getTxt_tutarOdenecek()));
					
				}
			});
			btnNewButton.setBounds(721, 74, 161, 26);
		}
		return btnNewButton;
	}
	private JPanel getPnl_TamamlananKayitlar() {
		if (pnl_TamamlananKayitlar == null) {
			pnl_TamamlananKayitlar = new JPanel();
			pnl_TamamlananKayitlar.setBounds(6, 6, 945, 451);
			pnl_TamamlananKayitlar.setLayout(null);
			pnl_TamamlananKayitlar.add(getLblTamamlananKayitlar());
			pnl_TamamlananKayitlar.add(getScrollPane_2());
		}
		return pnl_TamamlananKayitlar;
	}
	private JLabel getLblTamamlananKayitlar() {
		if (lblTamamlananKayitlar == null) {
			lblTamamlananKayitlar = new JLabel("TAMAMLANAN KAYITLAR");
			lblTamamlananKayitlar.setHorizontalAlignment(SwingConstants.CENTER);
			lblTamamlananKayitlar.setFont(new Font("Lucida Grande", Font.BOLD, 22));
			lblTamamlananKayitlar.setBounds(6, 18, 933, 27);
		}
		return lblTamamlananKayitlar;
	}
	private JPanel getPnl_OdemeBekleyen() {
		if (pnl_OdemeBekleyen == null) {
			pnl_OdemeBekleyen = new JPanel();
			pnl_OdemeBekleyen.setBounds(6, 6, 945, 451);
			pnl_OdemeBekleyen.setLayout(null);
			pnl_OdemeBekleyen.add(getLblOdemeBekleyenKayitlar());
			pnl_OdemeBekleyen.add(getScrollPane_1_1());
		}
		return pnl_OdemeBekleyen;
	}
	private JLabel getLblOdemeBekleyenKayitlar() {
		if (lblOdemeBekleyenKayitlar == null) {
			lblOdemeBekleyenKayitlar = new JLabel("ODEME BEKLEYEN KAYITLAR");
			lblOdemeBekleyenKayitlar.setBounds(6, 18, 933, 27);
			lblOdemeBekleyenKayitlar.setHorizontalAlignment(SwingConstants.CENTER);
			lblOdemeBekleyenKayitlar.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		}
		return lblOdemeBekleyenKayitlar;
	}
	
	
//	protected void getUpdateTable () {
//		UserModelDao dao = new UserModelDao();
//		List<UserModel> liste = dao.getAll(new UserModel());
//		String[] columnNames = { "ID", "Isim", "Soyisim", "T.C.No", "DogumTarihi", "Kurs Kodu", "Kurs Adi", "Odenecek Tutar", "Odenen Tutar" };
//		String[][] data = new String[liste.size()][columnNames.length];
//		for (int i = 0; i < liste.size(); i++) {
//			
//		}
//		DefaultTableModel model = new DefaultTableModel(data, columnNames);
//		tbl_sorgula.setModel(model);
//	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 142, 933, 303);
			scrollPane.setViewportView(getTbl_sorgula());
		}
		return scrollPane;
	}
	private JTable getTbl_sorgula() {
		if (tbl_sorgula == null) {
			tbl_sorgula = new JTable();
			tbl_sorgula.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tbl_sorgula_Row_Selected();
				}

				
			});
		}
		return tbl_sorgula;
	}
	
	protected void tbl_sorgula_Row_Selected() {
		int row = tbl_sorgula.getSelectedRow();
		selectedRowId = Integer.parseInt(tbl_sorgula.getModel().getValueAt(row, 0).toString());
		txt_isim.setText(tbl_sorgula.getModel().getValueAt(row, 1).toString());
		txt_soyisim.setText(tbl_sorgula.getModel().getValueAt(row, 2).toString());
		
		txt_sinifkodu.setText(tbl_sorgula.getModel().getValueAt(row, 4).toString());
		txt_kursadi.setText(tbl_sorgula.getModel().getValueAt(row, 5).toString());
		
	}
	
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(6, 53, 933, 392);
			scrollPane_1.setViewportView(getTbl_OdemeBekleyen());
		}
		return scrollPane_1;
	}
	private JTable getTbl_OdemeBekleyen() {
		if (tbl_OdemeBekleyen == null) {
			tbl_OdemeBekleyen = new JTable();
		}
		return tbl_OdemeBekleyen;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(6, 53, 933, 392);
			scrollPane_2.setViewportView(getTbl_tamamlanan());
		}
		return scrollPane_2;
	}
	private JTable getTbl_tamamlanan() {
		if (tbl_tamamlanan == null) {
			tbl_tamamlanan = new JTable();
		}
		return tbl_tamamlanan;
	}
}
