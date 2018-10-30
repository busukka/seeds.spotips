package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("b")
public class Board {
	private String b_no;// 게시물번호
	private String b_mbid;// 이메일
	private String b_flno;// 분야번호
	private String b_content;// 내용
	private String b_date;// 날짜
	private int b_openlv;// 공개비공개
	private int b_temsave;// 임시저장
	
	public String getB_no() {
		return b_no;
	}
	public void setB_no(String b_no) {
		this.b_no = b_no;
	}
	public String getB_mbid() {
		return b_mbid;
	}
	public void setB_mbid(String b_mbid) {
		this.b_mbid = b_mbid;
	}
	public String getB_flno() {
		return b_flno;
	}
	public void setB_flno(String b_flno) {
		this.b_flno = b_flno;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_openlv() {
		return b_openlv;
	}
	public void setB_openlv(int b_openlv) {
		this.b_openlv = b_openlv;
	}
	public int getB_temsave() {
		return b_temsave;
	}
	public void setB_temsave(int b_temsave) {
		this.b_temsave = b_temsave;
	}
	
	
	
}
