package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("ll")
public class LimitList {
	private int ll_no; //권한번호
	private String ll_name; //권한
	
	public int getLl_no() {
		return ll_no;
	}
	public void setLl_no(int ll_no) {
		this.ll_no = ll_no;
	}
	public String getLl_name() {
		return ll_name;
	}
	public void setLl_name(String ll_name) {
		this.ll_name = ll_name;
	}
	
}
