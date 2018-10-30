package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("fc")
public class FieldConcern { //분야선택 관심
	
	private String fc_mbid;//이메일
	private int fc_flno;// 분야번호
	
	
	public String getFc_mbid() {
		return fc_mbid;
	}
	public void setFc_mbid(String fc_mbid) {
		this.fc_mbid = fc_mbid;
	}
	public int getFc_flno() {
		return fc_flno;
	}
	public void setFc_flno(int fc_flno) {
		this.fc_flno = fc_flno;
	}
	
	
}
