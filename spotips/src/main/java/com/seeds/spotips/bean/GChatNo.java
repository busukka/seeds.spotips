package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("gc")
public class GChatNo { //그룹채팅번호
	private int gc_crno; //채팅방번호
	private String gc_gno; //그룹번호
	
	public int getGc_crno() {
		return gc_crno;
	}
	public void setGc_crno(int gc_crno) {
		this.gc_crno = gc_crno;
	}
	public String getGc_gno() {
		return gc_gno;
	}
	public void setGc_gno(String gc_gno) {
		this.gc_gno = gc_gno;
	}
	
	

}
