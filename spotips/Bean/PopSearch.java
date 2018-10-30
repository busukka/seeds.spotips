package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("ps")
public class PopSearch {
	private int ps_tlno;//태그번호
	private String ps_mbid;//이메일
	private String ps_date;//검색일시
	
	public int getPs_tlno() {
		return ps_tlno;
	}
	public void setPs_tlno(int ps_tlno) {
		this.ps_tlno = ps_tlno;
	}
	public String getPs_mbid() {
		return ps_mbid;
	}
	public void setPs_mbid(String ps_mbid) {
		this.ps_mbid = ps_mbid;
	}
	public String getPs_date() {
		return ps_date;
	}
	public void setPs_date(String ps_date) {
		this.ps_date = ps_date;
	}
	
	
	
}
