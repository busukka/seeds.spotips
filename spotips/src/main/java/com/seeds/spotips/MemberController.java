package com.seeds.spotips;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.MemberManagement;

//1
//2
//3s
//4
//7
//10
@Controller
//@SessionAttributes("mb")
public class MemberController {
	
	@Autowired
	private MemberManagement mm; //�쉶�썝愿�由� �꽌鍮꾩뒪 �겢�옒�뒪
	@Autowired
	HttpSession session;
	
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginPg");
		
		return mav;
		
	}
	
	@RequestMapping("/loginAccess")
	public ModelAndView joinForm(
			@RequestParam("mb_id") String mb_id,
			@RequestParam("mb_pw") String mb_pw) {
		ModelAndView mav = new ModelAndView();
		mav=mm.loginAccess(mb_id,mb_pw);
		
		return mav;
	}
	
	@RequestMapping(value = "/gdSelectPg", method = RequestMethod.GET)
	public ModelAndView gbSelectPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("gdSelectPg");
		
		return mav;
		
	}
	
	@RequestMapping("/joinGenPg")
	public ModelAndView joinGenPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joinGenPg");
		
		return mav;
		
	}
	@RequestMapping("/joinBusPg")
	public ModelAndView joinBusPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joinBusPg");
		
		return mav;
		
	}
	
	@RequestMapping("/googleLogin")
	public ModelAndView googleLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("wow");
		
		return mav;
		
	}
	
	@RequestMapping("/insertGm")
	public ModelAndView insertGm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectConcern");
		
		return mav;
		
	}
	@RequestMapping("/insertBm")
	public ModelAndView insertBm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("busJoinSuccess");
		
		return mav;
		
	}
	@RequestMapping("/remindGenPwPg")
	public ModelAndView RemindGenPwPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("remindGenPwPg");
		
		return mav;
		
	}
	
	@RequestMapping("/remindBusPwPg")
	public ModelAndView RemindBusPwPg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("remindBusPwPg");
		
		return mav;
		
	}
	
	
	
	
	
}
