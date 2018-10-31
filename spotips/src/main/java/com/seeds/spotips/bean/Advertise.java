package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

//영재/A
//영재/B
@Alias("ad")
public class Advertise {
	private String ad_no; //광고번호
	private String ad_bmid; // 이메일
	private int ad_flno; // 분야번호
	private int ad_serial; // 광고 시리얼
	private String ad_content; // 광고 내용
	private String ad_link; // 링크
	
	
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public String getAd_bmid() {
		return ad_bmid;
	}
	public void setAd_bmid(String ad_bmid) {
		this.ad_bmid = ad_bmid;
	}
	public int getAd_flno() {
		return ad_flno;
	}
	public void setAd_flno(int ad_flno) {
		this.ad_flno = ad_flno;
	}
	public int getAd_serial() {
		return ad_serial;
	}
	public void setAd_serial(int ad_serial) {
		this.ad_serial = ad_serial;
	}
	public String getAd_content() {
		return ad_content;
	}
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	public String getAd_link() {
		return ad_link;
	}
	public void setAd_link(String ad_link) {
		this.ad_link = ad_link;
	}
	
	
	
	
	
}
