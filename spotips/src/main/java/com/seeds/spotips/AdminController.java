package com.seeds.spotips;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/loadGenList") //일반회원관리 페이지 이동 - 일반회원 전체조회
	public ModelAndView loadGenList() {
		ModelAndView mav = new ModelAndView();
		System.out.println("컨트롤러 들어옴");
		mav=am.loadGenList();
		
		return mav;
		
	}
	@RequestMapping("/generalSearch") //일반회원조회(검색)
	public ModelAndView generalSearch() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("genManagementPg");
		
		return mav;
		
	}
	
	@RequestMapping("/businessSearch") //기업회원관리
	public ModelAndView busManagement() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("busManagementPg");
		
		return mav;
		
	}
	@RequestMapping("/goConcernPg") //관심분야 관리
	public ModelAndView adminConcern() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminConcernPg");
		
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
