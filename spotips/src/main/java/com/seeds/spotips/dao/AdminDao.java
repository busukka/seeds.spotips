package com.seeds.spotips.dao;

import java.util.List;

import com.seeds.spotips.bean.BusMember;
import com.seeds.spotips.bean.FieldList;
import com.seeds.spotips.bean.GenMember;

public interface AdminDao {
	//일반회원 전체조회
	public List<GenMember> loadGenList(); 
	
	//관리자 id 확인
	public String mgidCheck(String mb_id); 
	
	//기업회원 전체조회
	public List<BusMember> loadBusList(); 
	
	//기업회원검색결과조회 닉네임
	public List<BusMember> businessNameSearch(String key);
	
	//기업회원검색결과조회 이메일
	public List<BusMember> businessIdSearch(String key);
	
	//일반회원검색결과조회 닉네임
	public List<GenMember> generalNameSearch(String key);
	
	//일반회원검색결과조회 이메일
	public List<GenMember> generalIdSearch(String key);
	
	//관심분야 전체 조회
	public List<FieldList> goConcernPg();
	
	
	
	
	



	

}
