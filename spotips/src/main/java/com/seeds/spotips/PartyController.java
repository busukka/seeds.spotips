package com.seeds.spotips;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.Party;
import com.seeds.spotips.service.PartyManagement;

@Controller
public class PartyController {
	
	@Autowired
	private PartyManagement pm; 
	@Autowired
	HttpSession session;
	
	ModelAndView mav;
	
	@RequestMapping("goPartyMainPg")
	public ModelAndView partyMainPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("partyMainPg");
		return mav;
		
	}

	@RequestMapping("goPartyInsertPg")
	public ModelAndView goPartyInsertPg() {
		ModelAndView mav = new ModelAndView();
		mav=pm.goPartyInsertPg();
		return mav;
		
		
	}
	@RequestMapping("insertParty")					//required=false는 해당 객체가 존재하지않아도 에러발생 안시킴
	public ModelAndView insertParty(Party p,MultipartHttpServletRequest multi
			/*MultipartHttpServletRequest가 아닌 file을 담은 리스트로 받음*/
					,@RequestParam(value="bu_files",required=false) List<MultipartFile> files) {
		ModelAndView mav = new ModelAndView();
		System.out.println("시작시간:"+p.getP_sdate());
		System.out.println("종료시간:"+p.getP_edate());
		
		/*for(int i=0;i<files.size();i++) {
			System.out.println("파일:"+files.get(i));
		}*/
		mav=pm.insertParty(p,files,multi);
		return mav;
		
		
	}
	
	
	
}
