package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("tl")
public class TreatList { //관리자 처리 목록
	private int tl_no; //처리목록번호
	private String tl_content; //목록내용
	
	public int getTl_no() {
		return tl_no;
	}
	public void setTl_no(int tl_no) {
		this.tl_no = tl_no;
	}
	public String getTl_content() {
		return tl_content;
	}
	public void setTl_content(String tl_content) {
		this.tl_content = tl_content;
	}
	
	
}
