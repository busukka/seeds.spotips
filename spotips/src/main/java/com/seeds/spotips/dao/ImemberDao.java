package com.seeds.spotips.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.seeds.spotips.bean.BusMember;
import com.seeds.spotips.bean.FieldConcern;
import com.seeds.spotips.bean.FieldList;
import com.seeds.spotips.bean.FieldPro;
import com.seeds.spotips.bean.GenMember;
import com.seeds.spotips.bean.MbAddr;

public interface ImemberDao {
	
	

String getSecurityPw(String mb_id);

int getSerial(String mb_id);

String mailCheck(String mail);

String nameCheck(String name);

boolean insertGm(GenMember gm);

boolean insertAddr(MbAddr ma);

ArrayList<FieldList> getFieldList();

boolean insertBm(BusMember bm);

boolean insertFp(ArrayList<FieldPro> fpList);

boolean insertFc(ArrayList<FieldConcern> fcList);

boolean updateGenPw(HashMap<String, String> pwMap);

BusMember busnoCheck(String mail);

boolean updateBusPw(HashMap<String, String> pwMap);

int deleteGm(GenMember gm);

int deleteAddr(MbAddr ma);

int deleteBm(BusMember bm);

boolean insertBusFc(ArrayList<FieldConcern> fcList);

void updGenSeletCon(String mail);

void updBusSelectCon(String mail);

int getSelcetCon(String mail);

GenMember SelectGm(String mb_id);

BusMember SelectBm(String mb_id);







}
