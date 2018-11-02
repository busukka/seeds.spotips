package com.seeds.spotips;

import java.util.List;
import java.util.Map;

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
}
