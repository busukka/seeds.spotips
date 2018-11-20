package com.seeds.spotips;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.AdminManagement;

@Controller
public class AdminController {

	@Autowired
	private AdminManagement am;
	
	@RequestMapping("/adminPg") //관리자 페이지
	public ModelAndView adminPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminPg");
		
		return mav;
	}

	/*@RequestMapping("/nav") //관리자 페이지
	public ModelAndView nav() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("nav");
		
		return mav;
	}*/
	
	
	@RequestMapping("/loadGenList") //일반회원관리 페이지 이동 - 일반회원 전체조회
	public ModelAndView loadGenList() {
		ModelAndView mav = new ModelAndView();
		mav=am.loadGenList();
		
		return mav;
		
	}
	@RequestMapping("/generalSearch") //일반회원조회(검색)
	public ModelAndView generalSearch(HttpServletRequest request,HttpServletResponse reponse) throws Exception{
		ModelAndView mav = new ModelAndView();
		System.out.println("컨트롤러 들어옴3");
		mav=am.generalSearch(request);
		return mav;
		
	}
	
	@RequestMapping("/loadBusList") //기업회원관리 페이지 이동 - 기업회원 전체조회
	public ModelAndView loadBusList() {
		ModelAndView mav = new ModelAndView();
		System.out.println("컨트롤러 들어옴");
		mav=am.loadBusList();
		
		return mav;
		
	}
	
	@RequestMapping("/businessSearch") //기업회원조회(검색)
	public ModelAndView businessSearch(HttpServletRequest request,HttpServletResponse reponse) throws Exception{
		ModelAndView mav = new ModelAndView();
		System.out.println("컨트롤러 들어옴2");
		mav=am.businessSearch(request);
		return mav;
		
	}
	
	@RequestMapping("/goConcernPg") //관심분야 관리
	public ModelAndView goConcernPg() {
		ModelAndView mav = new ModelAndView();
		mav=am.goConcernPg();
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/concernInsert") //관심분야 추가
	public ModelAndView concernInsert() {
		ModelAndView mav = new ModelAndView();
		mav=am.concernInsert();
		System.out.println("컨트롤러 들어옴 concernInsert");
		return mav;
	}

	@RequestMapping("/conChkForm") //관심분야 중복체크화면 이동
	public ModelAndView conChkForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("concernCheckForm");
		return mav;
	}
	
	@RequestMapping("/genBlackListSearch") //일반회원 블랙리스트 관리
	public ModelAndView genBlackList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("genBlackListPg");
		
		return mav;
		
	}
	@RequestMapping("/busBlackListSearch") //기업회원 블랙리스트 관리
	public ModelAndView busBlackList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("busBlackListPg");
		
		return mav;
		
	}
	@RequestMapping("/reportManagement") //신고관리
	public ModelAndView reportManagement() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reportManagementPg");
		
		return mav;
		
	}
	@RequestMapping("/partyManagement") //모임관리
	public ModelAndView partyManagement() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("partyManagementPg");
		
		return mav;
		
	}
	
	
	
	
}
