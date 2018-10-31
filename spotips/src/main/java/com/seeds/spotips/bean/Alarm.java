package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;


/*현서/A*/
/*현서/B*/
@Alias("a")
public class Alarm {
	private String a_outid;//알람 발신자
	private String a_inid;// 알람 수신자
	private String a_date; // 알림발생 일시
	private String a_kind; // 알림종류
	private String a_content;// 알림 내용
	private String a_action; // 알림 클릭 액션
	private int a_read; // 알림확인 여부
	
	
	public String getA_outid() {
		return a_outid;
	}
	public void setA_outid(String a_outid) {
		this.a_outid = a_outid;
	}
	public String getA_inid() {
		return a_inid;
	}
	public void setA_inid(String a_inid) {
		this.a_inid = a_inid;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	public String getA_kind() {
		return a_kind;
	}
	public void setA_kind(String a_kind) {
		this.a_kind = a_kind;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getA_action() {
		return a_action;
	}
	public void setA_action(String a_action) {
		this.a_action = a_action;
	}
	public int getA_read() {
		return a_read;
	}
	public void setA_read(int a_read) {
		this.a_read = a_read;
	}
	
	
	
}
