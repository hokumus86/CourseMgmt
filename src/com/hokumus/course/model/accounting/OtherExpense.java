package com.hokumus.course.model.accounting;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class OtherExpense {
	
	private BigDecimal elektrikFatura;
	private BigDecimal suFatura;
	private BigDecimal dogalGazFatura;
	private BigDecimal vergiOdeme;
	private BigDecimal internetFatura;
	
	public OtherExpense() {	}

	public OtherExpense(BigDecimal elektrikFatura, BigDecimal suFatura, BigDecimal dogalGazFatura,
			BigDecimal vergiOdeme, BigDecimal internetFatura) {
		this.elektrikFatura = elektrikFatura;
		this.suFatura = suFatura;
		this.dogalGazFatura = dogalGazFatura;
		this.vergiOdeme = vergiOdeme;
		this.internetFatura = internetFatura;
	}

	public BigDecimal getElektrikFatura() {
		return elektrikFatura;
	}

	public void setElektrikFatura(BigDecimal elektrikFatura) {
		this.elektrikFatura = elektrikFatura;
	}

	public BigDecimal getSuFatura() {
		return suFatura;
	}

	public void setSuFatura(BigDecimal suFatura) {
		this.suFatura = suFatura;
	}

	public BigDecimal getDogalGazFatura() {
		return dogalGazFatura;
	}

	public void setDogalGazFatura(BigDecimal dogalGazFatura) {
		this.dogalGazFatura = dogalGazFatura;
	}

	public BigDecimal getVergiOdeme() {
		return vergiOdeme;
	}

	public void setVergiOdeme(BigDecimal vergiOdeme) {
		this.vergiOdeme = vergiOdeme;
	}

	public BigDecimal getInternetFatura() {
		return internetFatura;
	}

	public void setInternetFatura(BigDecimal internetFatura) {
		this.internetFatura = internetFatura;
	}

	@Override
	public String toString() {
		return "DigerGiderler [elektrikFatura=" + elektrikFatura + ", suFatura=" + suFatura + ", dogalGazFatura="
				+ dogalGazFatura + ", vergiOdeme=" + vergiOdeme + ", internetFatura=" + internetFatura + "]";
	}
	
	
	
}