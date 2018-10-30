package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("rl")
public class ReportList { //신고리스트
	private int rl_no; //신고번호
	private String rl_rid; //피신고자
	private String rl_bno; // 게시물 번호
	private int rl_rno; //댓글 번호
	private String rl_mbid; //신고 접수자
	private String rl_date; //신고날짜
	private String rl_obj; //신고 글내용
	private String content; //신고항목
	private int rl_tlno; //관리자 처리 번호
	
	public int getRl_no() {
		return rl_no;
	}
	public void setRl_no(int rl_no) {
		this.rl_no = rl_no;
	}
	public String getRl_rid() {
		return rl_rid;
	}
	public void setRl_rid(String rl_rid) {
		this.rl_rid = rl_rid;
	}
	public String getRl_bno() {
		return rl_bno;
	}
	public void setRl_bno(String rl_bno) {
		this.rl_bno = rl_bno;
	}
	public int getRl_rno() {
		return rl_rno;
	}
	public void setRl_rno(int rl_rno) {
		this.rl_rno = rl_rno;
	}
	public String getRl_mbid() {
		return rl_mbid;
	}
	public void setRl_mbid(String rl_mbid) {
		this.rl_mbid = rl_mbid;
	}
	public String getRl_date() {
		return rl_date;
	}
	public void setRl_date(String rl_date) {
		this.rl_date = rl_date;
	}
	public String getRl_obj() {
		return rl_obj;
	}
	public void setRl_obj(String rl_obj) {
		this.rl_obj = rl_obj;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRl_tlno() {
		return rl_tlno;
	}
	public void setRl_tlno(int rl_tlno) {
		this.rl_tlno = rl_tlno;
	}

}
