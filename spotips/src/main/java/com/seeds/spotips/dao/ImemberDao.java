package com.seeds.spotips.dao;

import com.seeds.spotips.bean.GenMember;
import com.seeds.spotips.bean.MbAddr;

public interface ImemberDao {
	
	

String getSecurityPw(String mb_id);

int getSerial(String mb_id);

String mailCheck(String mail);

String nameCheck(String name);

boolean insertGm(GenMember gm);

boolean insertAddr(MbAddr ma);

}
