package com.seeds.spotips;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.AdminManagement;

@Controller
public class AdminController {

	@Autowired
	private AdminManagement am;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/adminPg") //관리자 페이지
	public ModelAndView adminPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminPg");
		
		return mav;
	}
	
	@RequestMapping("/genManagement") //일반회원관리
	public ModelAndView genManagement() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("genManagement");
		
		return mav;
		
	}
	@RequestMapping("/busManagement") //기업회원관리
	public ModelAndView busManagement() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("busManagement");
		
		return mav;
		
	}
	@RequestMapping("/adminConcern") //관심분야 관리
	public ModelAndView adminConcern() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminConcern");
		
		return mav;
		
	}
	@RequestMapping("/genBlackList") //일반회원 블랙리스트 관리
	public ModelAndView genBlackList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("genBlackList");
		
		return mav;
		
	}
	@RequestMapping("/busBlackList") //기업회원 블랙리스트 관리
	public ModelAndView busBlackList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("busBlackList");
		
		return mav;
		
	}
	@RequestMapping("/reportManagement") //신고관리
	public ModelAndView reportManagement() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reportManagement");
		
		return mav;
		
	}
	@RequestMapping("/partyManagement") //모임관리
	public ModelAndView partyManagement() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("partyManagement");
		
		return mav;
		
	}
	
	
	
	
}
