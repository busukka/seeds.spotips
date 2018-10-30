package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("tl")
public class TagList {
	private int tl_no;  //태그번호
	private String tl_name; //태그명
	
	public int getTl_no() {
		return tl_no;
	}
	public void setTl_no(int tl_no) {
		this.tl_no = tl_no;
	}
	public String getTl_name() {
		return tl_name;
	}
	public void setTl_name(String tl_name) {
		this.tl_name = tl_name;
	}
	
	
}
