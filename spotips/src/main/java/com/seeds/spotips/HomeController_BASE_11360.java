package com.seeds.spotips;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.Member;
import com.seeds.spotips.service.MemberManagement;

@Controller
@SessionAttributes("mb")
public class HomeController {
	
	@Autowired
	private MemberManagement mm; //회원관리 서비스 클래스
	@Autowired
	HttpSession session;
	
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
		return mav;
		
	}
	
	@RequestMapping("/memberInsert")
	public ModelAndView insertMember(Member mb) {
		ModelAndView mav = new ModelAndView();
		mav=mm.memberInsert(mb);
		return mav;
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		
		
		return "joinForm";
	}
	
	
	
}
