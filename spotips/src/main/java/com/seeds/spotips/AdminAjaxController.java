package com.seeds.spotips;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.AdminManagement;

@Controller
@RequestMapping("/ajax")
public class AdminAjaxController {
	@Autowired
	private AdminManagement am;
	
	ModelAndView mav;

	/* 분야번호 담고 관심분야추가화면 로딩 */
/*	@RequestMapping(value = "/goConcernInsertPg",produces="application/json; charset=utf-8" )
	private ModelAndView goConcernInsertPg() {
		ModelAndView mav = new ModelAndView();
		System.out.println("컨트롤러 들어옴 - 관심분야 추가화면 로딩");
		mav = am.goConcernInsertPg();
		return mav;
	}*/
	
	/*분야명 중복체크*/
/*	@RequestMapping(value = "/conChkForm",produces="application/json; charset=utf-8" )
	private @ResponseBody String conChkForm(String fl_name) {
		System.out.println("컨트롤러 들어옴 - 중복체크");
		String json = am.conChkForm(fl_name);
		return json;
	}*/

		



	
	
	
	
	}
