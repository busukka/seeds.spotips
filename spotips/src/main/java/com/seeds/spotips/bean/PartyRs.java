package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("prs")
public class PartyRs {
	private String prs_pno; //모임번호
	private String prs_id; //이메일(예약)
	private String prs_date;// 모임예약날짜
	private int prs_partinchk;//참여여부
	private String prs_review; // 평가및 사유
	private String prs_hope; //바라는점
	
	public String getPrs_pno() {
		return prs_pno;
	}
	public void setPrs_pno(String prs_pno) {
		this.prs_pno = prs_pno;
	}
	public String getPrs_id() {
		return prs_id;
	}
	public void setPrs_id(String prs_id) {
		this.prs_id = prs_id;
	}
	public String getPrs_date() {
		return prs_date;
	}
	public void setPrs_date(String prs_date) {
		this.prs_date = prs_date;
	}
	public int getPrs_partinchk() {
		return prs_partinchk;
	}
	public void setPrs_partinchk(int prs_partinchk) {
		this.prs_partinchk = prs_partinchk;
	}
	public String getPrs_review() {
		return prs_review;
	}
	public void setPrs_review(String prs_review) {
		this.prs_review = prs_review;
	}
	public String getPrs_hope() {
		return prs_hope;
	}
	public void setPrs_hope(String prs_hope) {
		this.prs_hope = prs_hope;
	}
	
}
