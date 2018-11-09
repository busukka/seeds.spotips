package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("r")
public class Reply {
	private String r_bno;// 게시물번호 
	private double r_no;// 댓글번호
	private String r_mbid; // 이메일
	private String r_date; // 댓글날짜
	private String r_content; // 내용
	
	public String getR_bno() {
		return r_bno;
	}
	public void setR_bno(String r_bno) {
		this.r_bno = r_bno;
	}
	public double getR_no() {
		return r_no;
	}
	public void setR_no(double r_no2) {
		this.r_no = r_no2;
	}
	public String getR_mbid() {
		return r_mbid;
	}
	public void setR_mbid(String r_mbid) {
		this.r_mbid = r_mbid;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	
	
	
}
