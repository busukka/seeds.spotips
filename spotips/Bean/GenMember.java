package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("gm")
public class GenMember {
	private int gm_serial; //시리얼 번호
	private String gm_id; // 이메일
	private String gm_name; // 닉네임
	private String gm_pw; //비밀번호
	private String gm_birth; // 생년월일
	private String gm_gender; //성별
	private String gm_imgsysname; // 프로필사진
	private String gm_intro; // 소개글
	private String gm_joindate; // 가입일자
	private int gm_limit; // 가입일자
	private int gm_inblack; //블랙리스트여부
	private int gm_selectconcern; // 관심분야선택여부
	
	public int getGm_serial() {
		return gm_serial;
	}
	public void setGm_serial(int gm_serial) {
		this.gm_serial = gm_serial;
	}
	public String getGm_id() {
		return gm_id;
	}
	public void setGm_id(String gm_id) {
		this.gm_id = gm_id;
	}
	public String getGm_name() {
		return gm_name;
	}
	public void setGm_name(String gm_name) {
		this.gm_name = gm_name;
	}
	public String getGm_pw() {
		return gm_pw;
	}
	public void setGm_pw(String gm_pw) {
		this.gm_pw = gm_pw;
	}
	public String getGm_birth() {
		return gm_birth;
	}
	public void setGm_birth(String gm_birth) {
		this.gm_birth = gm_birth;
	}
	public String getGm_gender() {
		return gm_gender;
	}
	public void setGm_gender(String gm_gender) {
		this.gm_gender = gm_gender;
	}
	public String getGm_imgsysname() {
		return gm_imgsysname;
	}
	public void setGm_imgsysname(String gm_imgsysname) {
		this.gm_imgsysname = gm_imgsysname;
	}
	public String getGm_intro() {
		return gm_intro;
	}
	public void setGm_intro(String gm_intro) {
		this.gm_intro = gm_intro;
	}
	public String getGm_joindate() {
		return gm_joindate;
	}
	public void setGm_joindate(String gm_joindate) {
		this.gm_joindate = gm_joindate;
	}
	public int getGm_limit() {
		return gm_limit;
	}
	public void setGm_limit(int gm_limit) {
		this.gm_limit = gm_limit;
	}
	public int getGm_inblack() {
		return gm_inblack;
	}
	public void setGm_inblack(int gm_inblack) {
		this.gm_inblack = gm_inblack;
	}
	public int getGm_selectconcern() {
		return gm_selectconcern;
	}
	public void setGm_selectconcern(int gm_selectconcern) {
		this.gm_selectconcern = gm_selectconcern;
	}
	
}
