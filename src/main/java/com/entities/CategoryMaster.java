package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_master")
public class CategoryMaster {

	@Id
	@Column(name = "cat_cd", length = 5)
	private String catCd;

	@Column(name = "cat_shortname", length = 10, nullable = false)
	private String catShortname;

	@Column(name = "cat_fullname", length = 20, nullable = false)
	private String catFullname;

	public String getCatCd() {
		return catCd;
	}

	public void setCatCd(String catCd) {
		this.catCd = catCd;
	}

	public String getCatShortname() {
		return catShortname;
	}

	public void setCatShortname(String catShortname) {
		this.catShortname = catShortname;
	}

	public String getCatFullname() {
		return catFullname;
	}

	public void setCatFullname(String catFullname) {
		this.catFullname = catFullname;
	}

	public CategoryMaster(String catCd, String catShortname, String catFullname) {
		super();
		this.catCd = catCd;
		this.catShortname = catShortname;
		this.catFullname = catFullname;
	}

	public CategoryMaster() {
		super();

	}
}
