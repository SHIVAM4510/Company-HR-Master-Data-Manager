package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_master")
public class CompanyMaster {

	@Id
	@Column(name = "Comp_code", length = 5) // primary key 
	private String compCode;

	@Column(name = "Comp_name", length = 50)
	private String compName;

	@Column(name = "Comp_add1", length = 50)
	private String compAdd1;

	@Column(name = "Comp_add2", length = 50)
	private String compAdd2;

	@Column(name = "Comp_add3", length = 50)
	private String compAdd3;

	@Column(name = "Comp_add4", length = 50)
	private String compAdd4;

	@Column(name = "Comp_add5", length = 50)
	private String compAdd5;

	@Column(name = "City", length = 50)
	private String city;

	@Column(name = "State", length = 50)
	private String state;

	@Column(name = "Pincode", length = 6, columnDefinition = "CHAR(6)")
	private String pincode;

	@Column(name = "GSTIN", length = 15, unique = true)
	private String gstin;

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompAdd1() {
		return compAdd1;
	}

	public void setCompAdd1(String compAdd1) {
		this.compAdd1 = compAdd1;
	}

	public String getCompAdd2() {
		return compAdd2;
	}

	public void setCompAdd2(String compAdd2) {
		this.compAdd2 = compAdd2;
	}

	public String getCompAdd3() {
		return compAdd3;
	}

	public void setCompAdd3(String compAdd3) {
		this.compAdd3 = compAdd3;
	}

	public String getCompAdd4() {
		return compAdd4;
	}

	public void setCompAdd4(String compAdd4) {
		this.compAdd4 = compAdd4;
	}

	public String getCompAdd5() {
		return compAdd5;
	}

	public void setCompAdd5(String compAdd5) {
		this.compAdd5 = compAdd5;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

}
