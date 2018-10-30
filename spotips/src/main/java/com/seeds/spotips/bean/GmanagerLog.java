package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("gml")
public class GmanagerLog { //그룹관리자 로그
	private String gml_gmbid; // 이메일
	private String gml_treatdate; //처리날짜
	private String gml_gmbgno; //그룹번호
	private int gml_gmbgrade; //등급
	private String gml_managerlog; //로그
	public String getGml_gmbid() {
		return gml_gmbid;
	}
	public void setGml_gmbid(String gml_gmbid) {
		this.gml_gmbid = gml_gmbid;
	}
	public String getGml_treatdate() {
		return gml_treatdate;
	}
	public void setGml_treatdate(String gml_treatdate) {
		this.gml_treatdate = gml_treatdate;
	}
	public String getGml_gmbgno() {
		return gml_gmbgno;
	}
	public void setGml_gmbgno(String gml_gmbgno) {
		this.gml_gmbgno = gml_gmbgno;
	}
	public int getGml_gmbgrade() {
		return gml_gmbgrade;
	}
	public void setGml_gmbgrade(int gml_gmbgrade) {
		this.gml_gmbgrade = gml_gmbgrade;
	}
	public String getGml_managerlog() {
		return gml_managerlog;
	}
	public void setGml_managerlog(String gml_managerlog) {
		this.gml_managerlog = gml_managerlog;
	}
	
	
}
