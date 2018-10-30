package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("tr")
public class TreatResult { //신고처리 결과
	private String tr_tdate; //처리일자
	private String tr_mgid; //담당관리자
	private int tr_rlno; //신고번호
	private String tr_rlid; //피신고자
	private int tr_tlno; //관리자처리번호
	private String tr_sdate; //제한기간시작일
	private String tr_edate; //제한기간종료일
	
	public String getTr_tdate() {
		return tr_tdate;
	}
	public void setTr_tdate(String tr_tdate) {
		this.tr_tdate = tr_tdate;
	}
	public String getTr_mgid() {
		return tr_mgid;
	}
	public void setTr_mgid(String tr_mgid) {
		this.tr_mgid = tr_mgid;
	}
	public int getTr_rlno() {
		return tr_rlno;
	}
	public void setTr_rlno(int tr_rlno) {
		this.tr_rlno = tr_rlno;
	}
	public String getTr_rlid() {
		return tr_rlid;
	}
	public void setTr_rlid(String tr_rlid) {
		this.tr_rlid = tr_rlid;
	}
	public int getTr_tlno() {
		return tr_tlno;
	}
	public void setTr_tlno(int tr_tlno) {
		this.tr_tlno = tr_tlno;
	}
	public String getTr_sdate() {
		return tr_sdate;
	}
	public void setTr_sdate(String tr_sdate) {
		this.tr_sdate = tr_sdate;
	}
	public String getTr_edate() {
		return tr_edate;
	}
	public void setTr_edate(String tr_edate) {
		this.tr_edate = tr_edate;
	}
	
	
}
