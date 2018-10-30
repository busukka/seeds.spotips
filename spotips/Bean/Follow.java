package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("f")
public class Follow {
	
	private String f_wer; //팔로워 이메일
	private String f_ing; //팔로잉 이메일
	
	public String getF_wer() {
		return f_wer;
	}
	public void setF_wer(String f_wer) {
		this.f_wer = f_wer;
	}
	public String getF_ing() {
		return f_ing;
	}
	public void setF_ing(String f_ing) {
		this.f_ing = f_ing;
	}
	
	
}
