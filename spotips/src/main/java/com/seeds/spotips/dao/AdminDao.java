package com.seeds.spotips.dao;

import java.util.List;

import com.seeds.spotips.bean.GenMember;

public interface AdminDao {
	
	public List<GenMember> loadGenList(); //일반회원
	
	public String mgidCheck(String mg_id); //관리자



	

}
