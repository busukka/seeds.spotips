package com.seeds.spotips;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.BoardManagement;

@Controller
public class BoardController {

	
	@Autowired
	private BoardManagement bm;
	@Autowired
	HttpSession session;
	
	@RequestMapping("/getBoardList")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav=bm.getBoardList();
		
		return mav;
		
	}
	
	
	
}
