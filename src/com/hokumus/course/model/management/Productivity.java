package com.hokumus.course.model.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "productivity")
public class Productivity extends BaseEntity{
	private int    id;
   	private Courses    kurs;
    private String  kursVerimlilik;
    private String  orgetmenVerimlilik;
    private String  ogrenciVerimlilik;
    private Integer kursVNotu;
    private Integer orgetmenVNotu;
    private Integer ogrenciVNotu;
    private ProfiteLows karZarar;
    private String  oneriler;

    @Id
    @SequenceGenerator(name = "seq_productivity", allocationSize = 1, sequenceName = "seq_productivity")
    @GeneratedValue(generator = "seq_productivity", strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    @OneToOne
	@JoinColumn(name = "course_id")
	public Courses getKurs() {
		return kurs;
	}

	public void setKurs(Courses kurs) {
		this.kurs = kurs;
	}
	
	@Column(name = "courseProductivity", length = 1000)
	public String getKursVerimlilik() {
		return kursVerimlilik;
	}

	public void setKursVerimlilik(String kursVerimlilik) {
		this.kursVerimlilik = kursVerimlilik;
	}
	
	@Column(name = "teacherProductivity", length = 1000)
	public String getOrgetmenVerimlilik() {
		return orgetmenVerimlilik;
	}

	public void setOrgetmenVerimlilik(String orgetmenVerimlilik) {
		this.orgetmenVerimlilik = orgetmenVerimlilik;
	}
	
	@Column(name = "studentProductivity", length = 1000)
	public String getOgrenciVerimlilik() {
		return ogrenciVerimlilik;
	}

	public void setOgrenciVerimlilik(String ogrenciVerimlilik) {
		this.ogrenciVerimlilik = ogrenciVerimlilik;
	}
	@Column(name = "courseScore")
	public Integer getKursVNotu() {
		return kursVNotu;
	}
	public void setKursVNotu(Integer kursVNotu) {
		this.kursVNotu = kursVNotu;
	}
	@Column(name = "teacherScore")
	public Integer getOrgetmenVNotu() {
		return orgetmenVNotu;
	}
	public void setOrgetmenVNotu(Integer orgetmenVNotu) {
		this.orgetmenVNotu = orgetmenVNotu;
	}
	@Column(name = "studentScore")
	public Integer getOgrenciVNotu() {
		return ogrenciVNotu;
	}
	public void setOgrenciVNotu(Integer ogrenciVNotu) {
		this.ogrenciVNotu = ogrenciVNotu;
	}
	
	@Column(name = "profitLoss")
	public ProfiteLows getKarZarar() {
		return karZarar;
	}
	public void setKarZarar(ProfiteLows karZarar) {
		this.karZarar = karZarar;
	}
	
	@Column(name = "offerings", length = 1000)
	public String getOneriler() {
		return oneriler;
	}
	public void setOneriler(String oneriler) {
		this.oneriler = oneriler;
	}

	

}
