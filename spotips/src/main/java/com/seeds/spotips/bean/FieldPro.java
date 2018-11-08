package com.seeds.spotips.bean;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("fp")
public class FieldPro { // 분야선택 전문
	
	private String fp_mbid; //이메일
	private int fp_flno; //분야번호
	
	public String getFp_mbid() {
		return fp_mbid;
	}
	public void setFp_mbid(String fp_mbid) {
		this.fp_mbid = fp_mbid;
	}
	public int getFp_flno() {
		return fp_flno;
	}
	public void setFp_flno(int fp_flno) {
		this.fp_flno = fp_flno;
	}
	
	

}
