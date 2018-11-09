package com.seeds.spotips;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.service.BoardManagement;


@Controller
public class BoardController {

	
	@Autowired
	private BoardManagement bm;
	
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse rep;
	
	ModelAndView mav;
	
	
	@RequestMapping("/getBoardList")
	public ModelAndView home() {
		System.out.println("컨트롤러 오케이");
		mav=bm.getBoardList();
		return mav;
	};
	@RequestMapping("/gopostUploadPg")
	public ModelAndView gopostUploadPg() {
		mav = new ModelAndView();
		mav.setViewName("postUploadPg");
		return mav;
	};
	@RequestMapping("/peed")
	public ModelAndView peed() {
		mav = new ModelAndView();
		mav.setViewName("peed");
		return mav;
	};
	@RequestMapping("/boardPg")
	public ModelAndView boardPg() {
		mav = new ModelAndView();
		mav.setViewName("boardPg");
		return mav;
	};
	@RequestMapping(value = "/postInfo")
	public  ModelAndView postInfo(String b_no) {
		mav=bm.postInfo(b_no);
		return mav;
	};
	
	
	
	
}//class end
