package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("tgl")
public class TagList {
	private int tgl_no;  //태그번호
	private String tgl_name; //태그명
	
	public int getTl_no() {
		return tgl_no;
	}
	public void setTl_no(int tl_no) {
		this.tgl_no = tl_no;
	}
	public String getTl_name() {
		return tgl_name;
	}
	public void setTl_name(String tl_name) {
		this.tgl_name = tl_name;
	}
	
	
}
