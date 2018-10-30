package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("cu")
public class ChatUpload { //채팅방 업로드
	private String cu_ccid; //이메일
	private String cu_ccdate; //보낸날짜
	private int cu_crno; //채팅방번호
	private String cu_filesys; //사진영상sys
	private String cu_fileori; //사진영상ori
	private String cu_path; //경로
	
	public String getCu_ccid() {
		return cu_ccid;
	}
	public void setCu_ccid(String cu_ccid) {
		this.cu_ccid = cu_ccid;
	}
	public String getCu_ccdate() {
		return cu_ccdate;
	}
	public void setCu_ccdate(String cu_ccdate) {
		this.cu_ccdate = cu_ccdate;
	}
	public int getCu_crno() {
		return cu_crno;
	}
	public void setCu_crno(int cu_crno) {
		this.cu_crno = cu_crno;
	}
	public String getCu_filesys() {
		return cu_filesys;
	}
	public void setCu_filesys(String cu_filesys) {
		this.cu_filesys = cu_filesys;
	}
	public String getCu_fileori() {
		return cu_fileori;
	}
	public void setCu_fileori(String cu_fileori) {
		this.cu_fileori = cu_fileori;
	}
	public String getCu_path() {
		return cu_path;
	}
	public void setCu_path(String cu_path) {
		this.cu_path = cu_path;
	}
	

}
