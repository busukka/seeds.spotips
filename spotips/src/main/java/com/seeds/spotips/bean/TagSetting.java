package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("ts")
public class TagSetting { //해시태그 설정
	private int ts_tlno; //태그넘버
	private String ts_code; //분류번호
	
	public int getTs_tlno() {
		return ts_tlno;
	}
	public void setTs_tlno(int ts_tlno) {
		this.ts_tlno = ts_tlno;
	}
	public String getTs_code() {
		return ts_code;
	}
	public void setTs_code(String ts_code) {
		this.ts_code = ts_code;
	}
	
	
}
