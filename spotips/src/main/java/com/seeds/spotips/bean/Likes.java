package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("lk")
public class Likes { //좋아요
	private String lk_bno;//게시물번호
	private String lk_id; //이메일
	private int lk_on; //좋아요
	
	public String getLk_bno() {
		return lk_bno;
	}
	public void setLk_bno(String lk_bno) {
		this.lk_bno = lk_bno;
	}
	public String getLk_id() {
		return lk_id;
	}
	public void setLk_id(String lk_id) {
		this.lk_id = lk_id;
	}
	public int getLk_on() {
		return lk_on;
	}
	public void setLk_on(int lk_on) {
		this.lk_on = lk_on;
	}
	
}
