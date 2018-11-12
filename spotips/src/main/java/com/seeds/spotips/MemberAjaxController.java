package com.seeds.spotips;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.MemberManagement;
@Controller
@RequestMapping("/ajax")
public class MemberAjaxController {
	
	@Autowired
	private MemberManagement mm;
	
	ModelAndView mav;
	
	@RequestMapping(value = "/mailCheck",produces="application/json; charset=utf-8" )
	private @ResponseBody String mailCheck(String mail) {
		System.out.println("mail="+mail);
		String json=mm.mailCheck(mail);
		return json;
	}
	

	@RequestMapping(value = "/nameCheck",produces="application/json; charset=utf-8" )
	private @ResponseBody boolean nameCheck(String name) {
		System.out.println("name="+name);
		boolean nameCheck=mm.nameCheck(name);
		return nameCheck;
	}
	
	@RequestMapping(value="/certNoCheck")
	@ResponseBody
	private boolean certNoCheck(HttpSession session, int certNo) {
		System.out.println("certNo="+certNo);
		boolean certNoCheck = mm.certNoCheck(certNo);
		return certNoCheck;
		
	}
	
	@RequestMapping(value = "/mailBusnoCheck",produces="application/json; charset=utf-8" )
	private @ResponseBody String mailBusnoCheck(String mail,String busno) {
		System.out.println("mail="+mail);
		System.out.println("busno="+busno);
		String json=mm.mailBusnoCheck(mail,busno);
		
		return json;
	}
	
	@RequestMapping(value = "/mgInsertForm")
	public ModelAndView mgInsertForm() {
		mav = new ModelAndView();
		mav.setViewName("mgInsertForm");
		return mav;
	}
	
	
}
