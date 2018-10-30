package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("ml")
public class ManagerLog { //Spotips 관리자로그
	private String ml_mid; //관리자 아이디
	private String ml_tdate; //처리 날짜
	private int ml_tlno; //관리자처리번호
	
	public String getMl_mid() {
		return ml_mid;
	}
	public void setMl_mid(String ml_mid) {
		this.ml_mid = ml_mid;
	}
	public String getMl_tdate() {
		return ml_tdate;
	}
	public void setMl_tdate(String ml_tdate) {
		this.ml_tdate = ml_tdate;
	}
	public int getMl_tlno() {
		return ml_tlno;
	}
	public void setMl_tlno(int ml_tlno) {
		this.ml_tlno = ml_tlno;
	}
	
	
}
