package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("bm") 
public class BusMember {
	private int bm_serial; //시리얼
	private String bm_id; //이메일
	private String bm_name; //회사명(닉네임)
	private String bm_pw; //비밀번호
	private String bm_busform; //기업형태
	private int bm_busno; //기업번호
	private String bm_busrepre; //기업대표 
	private int bm_bustel; //기업연락처
	private String bm_addr; //주소
	private String bm_imgsysname; //기업사진
	private String bm_intro; //소개
	private String bm_joindate; //가입일자
	private int bm_limit; //권한번호
	private int bm_inblack; //블랙리스트 여부
	private int bm_selectconcern;//관심분야 선택여부
	
	public int getBm_serial() {
		return bm_serial;
	}
	public void setBm_serial(int bm_serial) {
		this.bm_serial = bm_serial;
	}
	public String getBm_id() {
		return bm_id;
	}
	public void setBm_id(String bm_id) {
		this.bm_id = bm_id;
	}
	public String getBm_name() {
		return bm_name;
	}
	public void setBm_name(String bm_name) {
		this.bm_name = bm_name;
	}
	public String getBm_pw() {
		return bm_pw;
	}
	public void setBm_pw(String bm_pw) {
		this.bm_pw = bm_pw;
	}
	public String getBm_busform() {
		return bm_busform;
	}
	public void setBm_busform(String bm_busform) {
		this.bm_busform = bm_busform;
	}
	public int getBm_busno() {
		return bm_busno;
	}
	public void setBm_busno(int bm_busno) {
		this.bm_busno = bm_busno;
	}
	public String getBm_busrepre() {
		return bm_busrepre;
	}
	public void setBm_busrepre(String bm_busrepre) {
		this.bm_busrepre = bm_busrepre;
	}
	public int getBm_bustel() {
		return bm_bustel;
	}
	public void setBm_bustel(int bm_bustel) {
		this.bm_bustel = bm_bustel;
	}
	public String getBm_addr() {
		return bm_addr;
	}
	public void setBm_addr(String bm_addr) {
		this.bm_addr = bm_addr;
	}
	public String getBm_imgsysname() {
		return bm_imgsysname;
	}
	public void setBm_imgsysname(String bm_imgsysname) {
		this.bm_imgsysname = bm_imgsysname;
	}
	public String getBm_intro() {
		return bm_intro;
	}
	public void setBm_intro(String bm_intro) {
		this.bm_intro = bm_intro;
	}
	public String getBm_joindate() {
		return bm_joindate;
	}
	public void setBm_joindate(String bm_joindate) {
		this.bm_joindate = bm_joindate;
	}
	public int getBm_limit() {
		return bm_limit;
	}
	public void setBm_limit(int bm_limit) {
		this.bm_limit = bm_limit;
	}
	public int getBm_inblack() {
		return bm_inblack;
	}
	public void setBm_inblack(int bm_inblack) {
		this.bm_inblack = bm_inblack;
	}
	public int getBm_selectconcern() {
		return bm_selectconcern;
	}
	public void setBm_selectconcern(int bm_selectconcern) {
		this.bm_selectconcern = bm_selectconcern;
	}
	
	
}
