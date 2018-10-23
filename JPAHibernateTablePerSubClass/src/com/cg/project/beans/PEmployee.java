package com.cg.project.beans;

import javax.persistence.Entity;

@Entity
public class PEmployee extends Employee{
	private int hra, ta, da;

	public PEmployee() {
		super();
	}

	public PEmployee(int hra, int ta, int da) {
		super();
		this.hra = hra;
		this.ta = ta;
		this.da = da;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getTa() {
		return ta;
	}

	public void setTa(int ta) {
		this.ta = ta;
	}

	public int getDa() {
		return da;
	}

	public void setDa(int da) {
		this.da = da;
	}

	@Override
	public String toString() {
		return "PEmployee [hra=" + hra + ", ta=" + ta + ", da=" + da + "]";
	}
	
}
