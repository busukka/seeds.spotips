package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("p")
public class Party {
	private String p_no; // 모임번호
	private String p_leader; // 이메일<모임장>
	private String p_name; // 모임명
	private int fl_no; // 분야번호
	private String p_date; // 게시일자
	private String p_sdate; // 모임시작시간
	private String p_edate; // 모임종료시간
	private String p_place; // 모임장소 
	private int p_total; // 총인원 
	private int p_reserv;// 예약 인원
	private String p_content; // 내용
	
	
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getP_leader() {
		return p_leader;
	}
	public void setP_leader(String p_leader) {
		this.p_leader = p_leader;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public String getP_sdate() {
		return p_sdate;
	}
	public void setP_sdate(String p_sdate) {
		this.p_sdate = p_sdate;
	}
	public String getP_edate() {
		return p_edate;
	}
	public void setP_edate(String p_edate) {
		this.p_edate = p_edate;
	}
	public String getP_place() {
		return p_place;
	}
	public void setP_place(String p_place) {
		this.p_place = p_place;
	}
	public int getP_total() {
		return p_total;
	}
	public void setP_total(int p_total) {
		this.p_total = p_total;
	}
	public int getP_reserv() {
		return p_reserv;
	}
	public void setP_reserv(int p_reserv) {
		this.p_reserv = p_reserv;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getFl_no() {
		return fl_no;
	}
	public void setFl_no(int fl_no) {
		this.fl_no = fl_no;
	}
	
	
	
}
