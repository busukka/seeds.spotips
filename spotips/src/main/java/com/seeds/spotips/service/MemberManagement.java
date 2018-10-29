package com.seeds.spotips.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.Member;
import com.seeds.spotips.dao.ImemberDao;

@Service
public class MemberManagement {
	@Autowired
	private ImemberDao mDao; //필드명과 bean태그의 id와 일치해야한다
	@Autowired
	private HttpSession session; //session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다 
	
	private ModelAndView mav;

	public ModelAndView memberInsert(Member mb) {
		mav=new ModelAndView();
		String view=null;
		if(mDao.memberInsert(mb)) {
			view="main";
			mav.addObject("check",1);//회원가입성공
		}else {
			view="joinForm";
		}
		mav.setViewName(view);
		return mav;
	}

}
