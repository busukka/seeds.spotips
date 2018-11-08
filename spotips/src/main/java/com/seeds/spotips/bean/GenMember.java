package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("gm")
public class GenMember {
	private int mb_serial; //시리얼 번호
	private String mb_id; // 이메일
	private String mb_name; // 닉네임
	private String mb_pw; //비밀번호
	private String mb_birth; // 생년월일
	private String mb_gender; //성별
	private String mb_imgsysname; // 프로필사진
	private String mb_intro; // 소개글
	private String mb_joindate; // 가입일자
	private int mb_limit; // 가입일자
	private int mb_inblack; //블랙리스트여부
	private int mb_selectconcern; // 관심분야선택여부
	
	public int getMb_serial() {
		return mb_serial;
	}
	public void setMb_serial(int mb_serial) {
		this.mb_serial = mb_serial;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public String getMb_birth() {
		return mb_birth;
	}
	public void setMb_birth(String mb_birth) {
		this.mb_birth = mb_birth;
	}
	public String getMb_gender() {
		return mb_gender;
	}
	public void setMb_gender(String mb_gender) {
		this.mb_gender = mb_gender;
	}
	public String getMb_imgsysname() {
		return mb_imgsysname;
	}
	public void setMb_imgsysname(String mb_imgsysname) {
		this.mb_imgsysname = mb_imgsysname;
	}
	public String getMb_intro() {
		return mb_intro;
	}
	public void setMb_intro(String mb_intro) {
		this.mb_intro = mb_intro;
	}
	public String getMb_joindate() {
		return mb_joindate;
	}
	public void setMb_joindate(String mb_joindate) {
		this.mb_joindate = mb_joindate;
	}
	public int getMb_limit() {
		return mb_limit;
	}
	public void setMb_limit(int mb_limit) {
		this.mb_limit = mb_limit;
	}
	public int getMb_inblack() {
		return mb_inblack;
	}
	public void setMb_inblack(int mb_inblack) {
		this.mb_inblack = mb_inblack;
	}
	public int getMb_selectconcern() {
		return mb_selectconcern;
	}
	public void setMb_selectconcern(int mb_selectconcern) {
		this.mb_selectconcern = mb_selectconcern;
	}
	
}
