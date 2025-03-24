package com.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="shift_master")
public class ShiftMaster {
	
	@Id
    @Column(name = "shift_cd", length = 5)
    private String shiftCd;

    @Column(name = "shift_name", length = 15, nullable = false)
    private String shiftName;

    @Column(name = "shift_intime", nullable = false)
    private LocalTime shiftIntime;

    @Column(name = "shift_outtime", nullable = false)
    private LocalTime shiftOuttime;

    @Transient // This field is calculated but not stored in DB
    private int shiftHour;

    public String getShiftCd() {
        return shiftCd;
    }

    public void setShiftCd(String shiftCd) {
        this.shiftCd = shiftCd;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public LocalTime getShiftIntime() {
        return shiftIntime;
    }

    public void setShiftIntime(LocalTime shiftIntime) {
        this.shiftIntime = shiftIntime;
    }

    public LocalTime getShiftOuttime() {
        return shiftOuttime;
    }

    public void setShiftOuttime(LocalTime shiftOuttime) {
        this.shiftOuttime = shiftOuttime;
    }

    public int getShiftHour() {
        return shiftOuttime.getHour() - shiftIntime.getHour();
    }

	public ShiftMaster(String shiftCd, String shiftName, LocalTime shiftIntime, LocalTime shiftOuttime, int shiftHour) {
		super();
		this.shiftCd = shiftCd;
		this.shiftName = shiftName;
		this.shiftIntime = shiftIntime;
		this.shiftOuttime = shiftOuttime;
		this.shiftHour = shiftHour;
	}

	public ShiftMaster() {
		super();
	}

	
	
}
