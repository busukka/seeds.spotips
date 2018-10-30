package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("mg")
public class Manager { //관리자계정
	private String mg_id; //아이디
	private int mg_serial; //시리얼
	private String mg_pw; //비밀번호
	private String mg_name; //이름
	
	public String getMg_id() {
		return mg_id;
	}
	public void setMg_id(String mg_id) {
		this.mg_id = mg_id;
	}
	public int getMg_serial() {
		return mg_serial;
	}
	public void setMg_serial(int mg_serial) {
		this.mg_serial = mg_serial;
	}
	public String getMg_pw() {
		return mg_pw;
	}
	public void setMg_pw(String mg_pw) {
		this.mg_pw = mg_pw;
	}
	public String getMg_name() {
		return mg_name;
	}
	public void setMg_name(String mg_name) {
		this.mg_name = mg_name;
	}
	
	
}
