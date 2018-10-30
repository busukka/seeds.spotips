package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("cc")
public class ChatContent { //채팅방 내용
	private int cc_crno; //채팅방 번호
	private String cc_date; //보낸날짜
	private String cc_id; //이메일
	private String cc_content; //내용
	public int getCc_crno() {
		return cc_crno;
	}
	public void setCc_crno(int cc_crno) {
		this.cc_crno = cc_crno;
	}
	public String getCc_date() {
		return cc_date;
	}
	public void setCc_date(String cc_date) {
		this.cc_date = cc_date;
	}
	public String getCc_id() {
		return cc_id;
	}
	public void setCc_id(String cc_id) {
		this.cc_id = cc_id;
	}
	public String getCc_content() {
		return cc_content;
	}
	public void setCc_content(String cc_content) {
		this.cc_content = cc_content;
	}
	
	
	
}
