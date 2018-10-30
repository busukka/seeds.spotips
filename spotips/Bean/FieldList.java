package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("fl")
public class FieldList {
	private int fl_no; //분야번호
	private String fl_name; //분야명
	private String fl_imgsysname; //분야이미지
	
	public int getFl_no() {
		return fl_no;
	}
	public void setFl_no(int fl_no) {
		this.fl_no = fl_no;
	}
	public String getFl_name() {
		return fl_name;
	}
	public void setFl_name(String fl_name) {
		this.fl_name = fl_name;
	}
	public String getFl_imgsysname() {
		return fl_imgsysname;
	}
	public void setFl_imgsysname(String fl_imgsysname) {
		this.fl_imgsysname = fl_imgsysname;
	}
	
	
}
