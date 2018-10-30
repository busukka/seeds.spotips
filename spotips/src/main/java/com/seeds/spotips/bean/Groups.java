package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("g")
public class Groups { //그룹
	private String g_no; //그룹번호
	private String g_name; //그룹명
	private int g_flno; //분야번호
	private String g_date; //개설날짜
	private String g_imgsysname; //그룹로고
	private String g_intro; //그룹설명
	private String g_leader; //이메일
	private int g_openlv; //공개범위
	private int g_totalmb; //그룹총인원
	
	
	public String getG_no() {
		return g_no;
	}
	public void setG_no(String g_no) {
		this.g_no = g_no;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public int getG_flno() {
		return g_flno;
	}
	public void setG_flno(int g_flno) {
		this.g_flno = g_flno;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
	public String getG_imgsysname() {
		return g_imgsysname;
	}
	public void setG_imgsysname(String g_imgsysname) {
		this.g_imgsysname = g_imgsysname;
	}
	public String getG_intro() {
		return g_intro;
	}
	public void setG_intro(String g_intro) {
		this.g_intro = g_intro;
	}
	public String getG_leader() {
		return g_leader;
	}
	public void setG_leader(String g_leader) {
		this.g_leader = g_leader;
	}
	public int getG_openlv() {
		return g_openlv;
	}
	public void setG_openlv(int g_openlv) {
		this.g_openlv = g_openlv;
	}
	public int getG_totalmb() {
		return g_totalmb;
	}
	public void setG_totalmb(int g_totalmb) {
		this.g_totalmb = g_totalmb;
	}
	
	
	
}
