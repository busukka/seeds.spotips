package com.seeds.spotips.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.BoardUpload;
import com.seeds.spotips.bean.FieldConcern;
import com.seeds.spotips.bean.FieldList;
import com.seeds.spotips.bean.Party;
import com.seeds.spotips.dao.ImemberDao;
import com.seeds.spotips.dao.PartyDao;
import com.seeds.spotips.userclass.UploadFile;

@Service
public class PartyManagement {

	
	@Autowired
	private PartyDao pDao; // 필드명과 bean태그의 id와 일치해야한다
	
	@Autowired
	private UploadFile upload;
	/*@Autowired
	private MemberManagement mm;*/
	@Autowired
	private ImemberDao mDao;
	
	@Autowired
	private HttpSession session; // session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다

	private ModelAndView mav;
						/*[ idx-goPartyInsertPg ]*/
	public ModelAndView goPartyInsertPg() {
		mav=new ModelAndView();
		String view=null;
		getFieldList();
		view="partyInsertPg";
		mav.setViewName(view);
		
		return mav;
	}
						/*[ idx-getFieldList ]*/
public void getFieldList() {
	mav = new ModelAndView();
	ArrayList<FieldList> fl = new ArrayList<FieldList>();
	String FLCheckBoxHTML = null;
	fl = mDao.getFieldList();
	FLCheckBoxHTML = makeFieldListCheckBox(fl);
	System.out.println("FLCheckBoxHTML생성 완료");
	mav.addObject("FLCheckBoxHTML", FLCheckBoxHTML);

}
					/*[ idx-makeFieldListCheckBox ]*/
private String makeFieldListCheckBox(ArrayList<FieldList> fl) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < fl.size(); i++) {
		sb.append("<input type='checkbox' name='fl_no' value='" + fl.get(i).getFl_no() + "'>"
				+ fl.get(i).getFl_name());
	}
	return sb.toString();
}

						/*[ idx-insertParty ]*/
public ModelAndView insertParty(Party p, List<MultipartFile> files, MultipartHttpServletRequest multi) {
	mav = new ModelAndView();
	String id = (String) session.getAttribute("id");
	
	System.out.println("게시자:"+id);
	for (int i = 0; i < files.size(); i++) {
		String f = files.get(i).getOriginalFilename();
		System.out.println("file" + i + ":" + f);
	}
	 
	p.setP_leader(id);
	boolean insertP=pDao.insertParty(p);
	System.out.println("p_no="+p.getP_no());
	boolean	insertF = false;
	insertF = upload.fileUp(files,p.getP_no(),multi);
	
	
	if(insertP && insertF) {
		mav.addObject("insertCheck",true);
	}else {
		mav.addObject("insertCheck",false);
	}
	mav.setViewName("partyInsertPg");
	return mav;
}

						/*[ idx-getPartyList]*/
public ModelAndView getPartyList() {
	mav = new ModelAndView();
	String id = (String) session.getAttribute("id");
	ArrayList<FieldConcern> fcList = new ArrayList<>();
	fcList = pDao.getFcList(id); //현재 회원의 관심분야 리스트
	
	/*for(int i=0;i<fcList.size();i++) {
		System.out.println("fcList"+fcList.get(i).getFc_flno());
	}*/
	
	ArrayList<Party> pList = new ArrayList<>();
	ArrayList<FieldList> flList = new ArrayList<>(); //가져온 분야 리스트
	ArrayList<FieldList> pfList = new ArrayList<>(); //각 모임의 분야명을 모임리스트와 같은순서로 담을 리스트(모델객체로 넣을 리스트)
	ArrayList<BoardUpload> buList = new ArrayList<>();
	flList = pDao.getFl(); //가져온 분야리스트
	
	/*회원의 관심분야에 해당하는 모임만 Select*/
	pList=pDao.getPartyList(fcList); //가져온 모임 리스트
	
	//가져갈 모임에 대한 분야 리스트 만드는과정
	for(int p=0;p<pList.size();p++) {
		for(int f=0;f<flList.size();f++) {
			if(pList.get(p).getFl_no()==flList.get(f).getFl_no()) {
				pfList.add(flList.get(f));
				System.out.println(p+"번째 분야:"+pfList.get(p).getFl_name());
				}
			}
		}
	
	buList=pDao.getBuList();
	for(int i =0;i<buList.size();i++) {
		System.out.println("bu_path="+buList.get(i).getBu_path());
	}
	mav.addObject("buList",buList);
	mav.addObject("pfList",pfList);
	//makePListHTML(pList);
	mav.addObject("pList",pList);
	mav.setViewName("partyList");
	return mav;
	
	}









}
