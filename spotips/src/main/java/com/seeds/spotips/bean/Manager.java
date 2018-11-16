package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("mg")
public class Manager { //관리자계정
	private String mb_id; //아이디
	private int mb_serial; //시리얼
	private String mb_pw; //비밀번호
	private String mb_name; //이름
	private String mb_imgsysname;
	
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public int getMb_serial() {
		return mb_serial;
	}
	public void setMb_serial(int mb_serial) {
		this.mb_serial = mb_serial;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_imgsysname() {
		return mb_imgsysname;
	}
	public void setMb_imgsysname(String mb_imgsysname) {
		this.mb_imgsysname = mb_imgsysname;
	}
	}
	
	
