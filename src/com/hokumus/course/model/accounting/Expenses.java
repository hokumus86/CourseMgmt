package com.hokumus.course.model.accounting;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.model.humenresources.Employee;
import com.hokumus.course.model.inventory.Inventory;
import com.hokumus.course.model.teacher.Teacher;
import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "expense")
public class Expenses extends BaseEntity{

    private Long id;
    private ExpensesType tanim;
    private String aciklama;
	private BigDecimal miktar;
    private Date tarih;
    private Teacher ogretmen;
    private Employee personel;
    private OtherExpense OtherExpense;
    
    public Teacher getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Teacher ogretmen) {
		this.ogretmen = ogretmen;
	}

	public Employee getPersonel() {
		return personel;
	}

	public void setPersonel(Employee personel) {
		this.personel = personel;
	}

	public OtherExpense getOtherExpense() {
		return OtherExpense;
	}

	public void setOtherExpense(OtherExpense otherExpense) {
		OtherExpense = otherExpense;
	}

    
//    @Embedded
//    public OtherExpense getOtherExpense() {
//		return OtherExpense;
//	}
//
//	public void setOtherExpense(OtherExpense OtherExpense) {
//		this.OtherExpense = OtherExpense;
//	}

	@Id
    @SequenceGenerator(name = "seq_expense", allocationSize = 1, sequenceName = "seq_expense")
    @GeneratedValue(generator = "seq_expense", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "subject", length = 100)
    public ExpensesType getTanim() {
		return tanim;
	}

	public void setTanim(ExpensesType tanim) {
		this.tanim = tanim;
	}
    
	@Column(name = "description", length = 150)
	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
    @Column(name = "quantity", precision = 14, scale = 2)
    public BigDecimal getMiktar() {
        return miktar;
    }

	public void setMiktar(BigDecimal miktar) {
        this.miktar = miktar;
    }

    @Column(name = "date")
    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

//    @ManyToOne
//    @JoinColumn(name = "teacher_id")
//    public Teacher getOgretmen() {
//        return ogretmen;
//    }
//
//    public void setOgretmen(Teacher ogretmen) {
//        this.ogretmen = ogretmen;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    public Employee getPersonel() {
//        return personel;
//    }
//
//    public void setPersonel(Employee personel) {
//        this.personel = personel;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "inventory_id")
//    public Inventory getEnvanter() {
//        return envanter;
//    }

//    public void setEnvanter(Inventory envanter) {
//        this.envanter = envanter;
//    }
//
//    @Override
//    public String toString() {
//        return   "Gider Id = " +id+" Personel id = "+personel+ " Envanter id = "+envanter+ " Ogretmen id = "+ogretmen;
//    }
 

}
