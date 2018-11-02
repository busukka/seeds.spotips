package com.seeds.spotips;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.AddrBean;
import com.seeds.spotips.bean.GenMember;
import com.seeds.spotips.bean.MbAddr;
import com.seeds.spotips.service.MemberManagement;



@Controller
@SessionAttributes("mb")//모델객체 mb 만들면 request를 session처럼 사용//mav.addObject("mb",gm) 키값("mb")으로도되고 벨류(gm)도된다
public class MemberController {
	
	@Autowired
	private MemberManagement mm; 
	@Autowired
	HttpSession session;
	
	ModelAndView mav;
	
	
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
		System.out.println(session.getAttribute("id"));
		
		return mav;
	}
	
	@RequestMapping(value = "/gdSelectPg", method = RequestMethod.GET)
	public ModelAndView gbSelectPg(@RequestParam("select") String select) {
		ModelAndView mav = new ModelAndView();
		System.out.println(select);
		mav=mm.gbSelectPg(select);
		System.out.println(mav.getViewName());
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
	
	@RequestMapping(value="/certNoCheck")
	@ResponseBody
	private boolean certNoCheck(HttpSession session, int certNo) {
		System.out.println("certNo="+certNo);
		boolean certNoCheck = mm.certNoCheck(certNo);
		return certNoCheck;
		
	}
	
	
	
	@RequestMapping("/googleLogin")
	public ModelAndView googleLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("wow");
		
		return mav;
		
	}
	
	@RequestMapping("/insertGm")
	public ModelAndView insertGm(AddrBean ab,GenMember gm) {
		ModelAndView mav = new ModelAndView();
		System.out.println("id="+gm.getGm_id());
		System.out.println("addr="+ab.getAddr1()+ab.getAddr2()+ab.getAddr3());
		mav=mm.insertGm(gm,ab);
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
