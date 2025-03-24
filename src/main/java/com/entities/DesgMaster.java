package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "desg_master")
public class DesgMaster {

	@Id
	@Column(name = "desg_cd", length = 5)
	private String desgCd;

	@Column(name = "desg_shortname", length = 10, nullable = false)
	private String desgShortname;

	@Column(name = "desg_fullname", length = 20, nullable = false)
	private String desgFullname;

	public String getDesgCd() {
		return desgCd;
	}

	public void setDesgCd(String desgCd) {
		this.desgCd = desgCd;
	}

	public String getDesgShortname() {
		return desgShortname;
	}

	public void setDesgShortname(String desgShortname) {
		this.desgShortname = desgShortname;
	}

	public String getDesgFullname() {
		return desgFullname;
	}

	public void setDesgFullname(String desgFullname) {
		this.desgFullname = desgFullname;
	}

	public DesgMaster(String desgCd, String desgShortname, String desgFullname) {
		super();
		this.desgCd = desgCd;
		this.desgShortname = desgShortname;
		this.desgFullname = desgFullname;
	}

	public DesgMaster() {
		super();
		
	}
}
