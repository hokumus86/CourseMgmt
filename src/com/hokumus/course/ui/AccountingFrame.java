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
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.dao.UserModelDao;
import com.hokumus.course.model.UserModel;
import javax.swing.JScrollPane;

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
	private JLabel lblNewLabel_2;
	private JTextField txt_isim;
	private JTextField txt_soyisim;
	private JTextField txt_tcno;
	private JLabel lblKursKodu;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txt_sinifkodu;
	private JTextField txt_kursadi;
	private JTextField txt_tutarOdenecek;
	private JButton btnSorgula;
	private JButton btnNewButton;
	private JLabel lblDogumTarihi;
	private JTextField txt_dogumtarihi;
	private JLabel lblNewLabel_5;
	private JTextField txt_tutarOdenen;
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
	
	public AccountingFrame() {
		initialize ();
		pnl_KayitSorgula.setVisible(false);
		pnl_OdemeBekleyen.setVisible(false);
		pnl_TamamlananKayitlar.setVisible(false);
	}

	private void initialize() {
		
		setTitle("Muhasebe");
		setSize(957,507);
		setJMenuBar(getMenuBar_1());
		getContentPane().setLayout(null);
		getContentPane().add(getPnl_TamamlananKayitlar());
		getContentPane().add(getPnl_OdemeBekleyen());
		getContentPane().add(getPnl_KayitSorgula());
		
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
					String[] columnNames = { "ID", "Isim", "Soyisim", "T.C.No", "DogumTarihi", "Kurs Kodu", "Kurs Adi", "Odenecek Tutar", "Odenen Tutar" };
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
					String[] columnNames = { "ID", "Isim", "Soyisim", "T.C.No", "DogumTarihi", "Kurs Kodu", "Kurs Adi", "Odenecek Tutar", "Odenen Tutar" };
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
			pnl_KayitSorgula.add(getLblNewLabel_2());
			pnl_KayitSorgula.add(getTxt_isim());
			pnl_KayitSorgula.add(getTxt_soyisim());
			pnl_KayitSorgula.add(getTxt_tcno());
			pnl_KayitSorgula.add(getLblKursKodu());
			pnl_KayitSorgula.add(getLblNewLabel_3());
			pnl_KayitSorgula.add(getLblNewLabel_4());
			pnl_KayitSorgula.add(getTxt_sinifkodu());
			pnl_KayitSorgula.add(getTxt_kursadi());
			pnl_KayitSorgula.add(getTxt_tutarOdenecek());
			pnl_KayitSorgula.add(getBtnSorgula());
			pnl_KayitSorgula.add(getBtnNewButton());
			pnl_KayitSorgula.add(getLblDogumTarihi());
			pnl_KayitSorgula.add(getTxt_dogumtarihi());
			pnl_KayitSorgula.add(getLblNewLabel_5());
			pnl_KayitSorgula.add(getTxt_tutarOdenen());
			pnl_KayitSorgula.add(getScrollPane_1());
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
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("T.C No");
			lblNewLabel_2.setBounds(44, 80, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTxt_isim() {
		if (txt_isim == null) {
			txt_isim = new JTextField();
			txt_isim.setBounds(117, 19, 202, 26);
			txt_isim.setColumns(10);
		}
		return txt_isim;
	}
	private JTextField getTxt_soyisim() {
		if (txt_soyisim == null) {
			txt_soyisim = new JTextField();
			txt_soyisim.setBounds(117, 47, 202, 26);
			txt_soyisim.setColumns(10);
		}
		return txt_soyisim;
	}
	private JTextField getTxt_tcno() {
		if (txt_tcno == null) {
			txt_tcno = new JTextField();
			txt_tcno.setBounds(117, 75, 202, 26);
			txt_tcno.setColumns(10);
		}
		return txt_tcno;
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
			lblNewLabel_4.setBounds(365, 78, 107, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTxt_sinifkodu() {
		if (txt_sinifkodu == null) {
			txt_sinifkodu = new JTextField();
			txt_sinifkodu.setBounds(479, 19, 202, 26);
			txt_sinifkodu.setColumns(10);
		}
		return txt_sinifkodu;
	}
	private JTextField getTxt_kursadi() {
		if (txt_kursadi == null) {
			txt_kursadi = new JTextField();
			txt_kursadi.setBounds(479, 47, 202, 26);
			txt_kursadi.setColumns(10);
		}
		return txt_kursadi;
	}
	private JTextField getTxt_tutarOdenecek() {
		if (txt_tutarOdenecek == null) {
			txt_tutarOdenecek = new JTextField();
			txt_tutarOdenecek.setBounds(479, 75, 202, 26);
			txt_tutarOdenecek.setColumns(10);
		}
		return txt_tutarOdenecek;
	}
	private JButton getBtnSorgula() {
		if (btnSorgula == null) {
			btnSorgula = new JButton("Sorgula");
			btnSorgula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getUpdateTable();
				}
			});
			btnSorgula.setBounds(742, 24, 161, 35);
		}
		return btnSorgula;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Guncelle");
			btnNewButton.setBounds(741, 61, 161, 35);
		}
		return btnNewButton;
	}
	private JLabel getLblDogumTarihi() {
		if (lblDogumTarihi == null) {
			lblDogumTarihi = new JLabel("Dogum Tarihi");
			lblDogumTarihi.setBounds(44, 108, 99, 16);
		}
		return lblDogumTarihi;
	}
	private JTextField getTxt_dogumtarihi() {
		if (txt_dogumtarihi == null) {
			txt_dogumtarihi = new JTextField();
			txt_dogumtarihi.setBounds(152, 103, 167, 26);
			txt_dogumtarihi.setColumns(10);
		}
		return txt_dogumtarihi;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Odenen Tutar");
			lblNewLabel_5.setBounds(365, 106, 107, 16);
		}
		return lblNewLabel_5;
	}
	private JTextField getTxt_tutarOdenen() {
		if (txt_tutarOdenen == null) {
			txt_tutarOdenen = new JTextField();
			txt_tutarOdenen.setBounds(479, 103, 202, 26);
			txt_tutarOdenen.setColumns(10);
		}
		return txt_tutarOdenen;
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
	
	
	protected void getUpdateTable () {
		UserModelDao dao = new UserModelDao();
		List<UserModel> liste = dao.getAll(new UserModel());
		String[] columnNames = { "ID", "Isim", "Soyisim", "T.C.No", "DogumTarihi", "Kurs Kodu", "Kurs Adi", "Odenecek Tutar", "Odenen Tutar" };
		String[][] data = new String[liste.size()][columnNames.length];
		for (int i = 0; i < liste.size(); i++) {
			
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		tbl_sorgula.setModel(model);
	}
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
		}
		return tbl_sorgula;
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