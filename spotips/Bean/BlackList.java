package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("bl")
public class BlackList {
	private String bl_mbid; // 이메일
	private String bl_insertdate; //추가날짜
	
	public String getBl_mbid() {
		return bl_mbid;
	}
	public void setBl_mbid(String bl_mbid) {
		this.bl_mbid = bl_mbid;
	}
	public String getBl_insertdate() {
		return bl_insertdate;
	}
	public void setBl_insertdate(String bl_insertdate) {
		this.bl_insertdate = bl_insertdate;
	}
	
	
	
}
