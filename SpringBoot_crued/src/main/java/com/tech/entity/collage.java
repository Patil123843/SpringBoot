package com.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class collage {
	@Id
    private String c_id;
	
	
	private String c_name;

	private String c_addrs;

	private String c_department;

	private String c_fild;


	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_addrs() {
		return c_addrs;
	}

	public void setC_addrs(String c_addrs) {
		this.c_addrs = c_addrs;
	}

	public String getC_department() {
		return c_department;
	}

	public void setC_department(String c_department) {
		this.c_department = c_department;
	}

	public String getC_fild() {
		return c_fild;
	}

	public void setC_fild(String c_fild) {
		this.c_fild = c_fild;
	}

}
