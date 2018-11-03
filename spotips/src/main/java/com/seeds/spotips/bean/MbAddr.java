package com.seeds.spotips.bean;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

@Alias("ma")
public class MbAddr {
	private String ma_gmid; //이메일
	private String ma_addr; //회원주소
	
	public String getMa_gmid() {
		return ma_gmid;
	}
	public void setMa_gmid(String ma_gmid) {
		this.ma_gmid = ma_gmid;
	}
	public String getMa_addr() {
		return ma_addr;
	}
	public void setMa_addr(String ma_addr) {
		this.ma_addr = ma_addr;
	}
	
	
	
	
}
