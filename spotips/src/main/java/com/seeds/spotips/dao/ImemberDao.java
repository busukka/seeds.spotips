package com.seeds.spotips.dao;

import com.seeds.spotips.bean.Member;

public interface ImemberDao {
	
	

String getSecurityPw(String mb_id);

int getSerial(String mb_id);

}
