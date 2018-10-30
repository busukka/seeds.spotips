package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("gmb")
public class GMember { //그룹멤버
	private String gmb_gno; //그룹번호
	private String gmb_id; //이메일
	private int gmb_grade; //등급
	private String gmb_joindate; //가입날짜
	
	public String getGmb_gno() {
		return gmb_gno;
	}
	public void setGmb_gno(String gmb_gno) {
		this.gmb_gno = gmb_gno;
	}
	public String getGmb_id() {
		return gmb_id;
	}
	public void setGmb_id(String gmb_id) {
		this.gmb_id = gmb_id;
	}
	public int getGmb_grade() {
		return gmb_grade;
	}
	public void setGmb_grade(int gmb_grade) {
		this.gmb_grade = gmb_grade;
	}
	public String getGmb_joindate() {
		return gmb_joindate;
	}
	public void setGmb_joindate(String gmb_joindate) {
		this.gmb_joindate = gmb_joindate;
	}
	
	
}
