package com.seeds.spotips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.PartyManagement;

@Controller
@RequestMapping("/ajax")
public class PartyAjaxController {
	
	@Autowired
	private PartyManagement pm;
	
	private ModelAndView mav;
	
	
	@RequestMapping(value = "/getPartyList",produces="application/json; charset=utf-8" )
	private ModelAndView mailCheck() {
		mav= new ModelAndView();
		mav=pm.getPartyList();
		return mav;
	}

}
