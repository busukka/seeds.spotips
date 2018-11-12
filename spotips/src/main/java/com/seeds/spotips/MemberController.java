package com.seeds.spotips;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.AddrBean;
import com.seeds.spotips.bean.GenMember;
import com.seeds.spotips.bean.Manager;
import com.seeds.spotips.service.MemberManagement;



	@Controller
	/*@SessionAttributes("mb")*///모델객체 키값"mb"를 만들면 session이 죽을때까지 그 모델객체 mb의 라이프사이클이 유지된다
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
			@RequestParam("mb_pw") String mb_pw) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		ModelAndView mav = new ModelAndView();
		mav=mm.loginAccess(mb_id,mb_pw);
		
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
		mav=mm.joinBusPg();
		
		return mav;
		
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
		System.out.println("id="+gm.getMb_id());
		System.out.println("addr="+ab.getAddr1()+ab.getAddr2()+ab.getAddr3());
		mav=mm.insertGm(gm,ab);
		System.out.println(mav.getViewName());
		return mav;
		
	}
	@RequestMapping(value="/insertBm", method = RequestMethod.POST)
	public ModelAndView insertBm(HttpServletRequest request,AddrBean ab) {
		ModelAndView mav = new ModelAndView();
		//String[] arr= {"1","4"};//트랜잭션확인용
		String[] arr=request.getParameterValues("fl_no");
		//System.out.println(arr.length);
		mav=mm.insertBm(arr,request,ab);
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
	@RequestMapping(value="/selectConcern",method = RequestMethod.POST)
	public ModelAndView selectConcern(HttpServletRequest request) {
		mav = new ModelAndView();
		String[] arr = request.getParameterValues("fl_no");
		mav=mm.selectConcern(arr);
		return mav;
		
	}
	
	@RequestMapping(value="/adminMbManagerPg",method = RequestMethod.GET)
	public ModelAndView adminMbManagerPg(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		mav = new ModelAndView();
		mav=mm.adminMbManagerPg();
		return mav;
		
	}
	@RequestMapping(value="/insertMg",method = RequestMethod.POST)
	public ModelAndView inserMg(Manager mg) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		mav = new ModelAndView();
		mav = mm.insertMg(mg);
		return mav;
		
	}
	
	
}
