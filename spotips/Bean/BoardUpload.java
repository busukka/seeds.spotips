package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("bu")
public class BoardUpload { //게시판업로드
	private String bu_code; //분류번호
	private String bu_filesys; //사진, 영상 sys
	private String bu_fileori; //사진, 영상 ori
	private String bu_path; //경로
	
	public String getBu_code() {
		return bu_code;
	}
	public void setBu_code(String bu_code) {
		this.bu_code = bu_code;
	}
	public String getBu_filesys() {
		return bu_filesys;
	}
	public void setBu_filesys(String bu_filesys) {
		this.bu_filesys = bu_filesys;
	}
	public String getBu_fileori() {
		return bu_fileori;
	}
	public void setBu_fileori(String bu_fileori) {
		this.bu_fileori = bu_fileori;
	}
	public String getBu_path() {
		return bu_path;
	}
	public void setBu_path(String bu_path) {
		this.bu_path = bu_path;
	}
	
	
}
