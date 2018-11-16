package com.seeds.spotips.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.seeds.spotips.bean.BoardUpload;
import com.seeds.spotips.bean.FieldConcern;
import com.seeds.spotips.bean.FieldList;
import com.seeds.spotips.bean.Party;

public interface PartyDao {

	boolean insertParty(Party p);

	boolean insertFileUpload(ArrayList<BoardUpload> buList);

	ArrayList<Party> getPartyList(ArrayList<FieldConcern> fcList);

	ArrayList<FieldList> getFl();

	ArrayList<FieldConcern> getFcList(String id);

	ArrayList<BoardUpload> getBuList();

}
