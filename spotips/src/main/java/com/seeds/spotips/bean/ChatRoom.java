package com.seeds.spotips.bean;

import org.apache.ibatis.type.Alias;

@Alias("cr")
public class ChatRoom { //채팅방
	private int cr_no; //채팅방번호

	public int getCr_no() {
		return cr_no;
	}

	public void setCr_no(int cr_no) {
		this.cr_no = cr_no;
	}
	
	
}
