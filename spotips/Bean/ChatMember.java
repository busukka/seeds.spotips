package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("cm")
public class ChatMember { //채팅방멤버
	private int cm_crno; //채팅방번호
	private String cm_mb; //이메일
	private String cm_roomname; //채팅방이름
	
	
	public int getCm_crno() {
		return cm_crno;
	}
	public void setCm_crno(int cm_crno) {
		this.cm_crno = cm_crno;
	}
	public String getCm_mb() {
		return cm_mb;
	}
	public void setCm_mb(String cm_mb) {
		this.cm_mb = cm_mb;
	}
	public String getCm_roomname() {
		return cm_roomname;
	}
	public void setCm_roomname(String cm_roomname) {
		this.cm_roomname = cm_roomname;
	}
	
	
}
