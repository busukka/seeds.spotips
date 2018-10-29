package com.seeds.spotips;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.Member;
import com.seeds.spotips.service.MemberManagement;

//안녕하세요
//최형진
//정영재
//아
@Controller
@SessionAttributes("mb")
public class HomeController {
	
	@Autowired
	private MemberManagement mm; //회원관리 서비스 클래스
	
	@Autowired
	HttpSession session;
	
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public ModelAndView joinForm() {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("joinForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public ModelAndView memberInsert(Member mb) {
		ModelAndView mav = new ModelAndView(); 
		mav=mm.memberInsert(mb);
		
		return mav;
	}
	
}
