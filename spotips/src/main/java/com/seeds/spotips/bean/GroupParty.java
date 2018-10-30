package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("gp")
public class GroupParty { //그룹내모임
	private String gp_gno; //그룹번호
	private String gp_pno; //모임번호
	
	public String getGp_gno() {
		return gp_gno;
	}
	public void setGp_gno(String gp_gno) {
		this.gp_gno = gp_gno;
	}
	public String getGp_pno() {
		return gp_pno;
	}
	public void setGp_pno(String gp_pno) {
		this.gp_pno = gp_pno;
	}
	
	
}
