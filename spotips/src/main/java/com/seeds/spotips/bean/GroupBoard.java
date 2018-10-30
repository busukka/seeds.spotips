package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("gb")
public class GroupBoard {//그룹게시판
	private String gb_gno; //그룹번호
	private String gb_bno; //게시물번호
	private String gb_id; //이메일
	
	public String getGb_gno() {
		return gb_gno;
	}
	public void setGb_gno(String gb_gno) {
		this.gb_gno = gb_gno;
	}
	public String getGb_bno() {
		return gb_bno;
	}
	public void setGb_bno(String gb_bno) {
		this.gb_bno = gb_bno;
	}
	public String getGb_id() {
		return gb_id;
	}
	public void setGb_id(String gb_id) {
		this.gb_id = gb_id;
	}
	
	
	
}
