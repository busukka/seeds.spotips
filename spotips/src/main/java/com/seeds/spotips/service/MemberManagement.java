package com.seeds.spotips.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.dao.ImemberDao;

@Service
public class MemberManagement {
	@Autowired
	private ImemberDao mDao; //필드명과 bean태그의 id와 일치해야한다
	@Autowired
	private HttpSession session; //session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다 
	
	private ModelAndView mav;

public ModelAndView loginAccess(String mb_id, String mb_pw) {
		
		mav=new ModelAndView();
		String view=null;
		
		//암호화된 비번으로 계정 로그인할때
	/*	BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		String pwEncode=mDao.getSecurityPw(mb_id);
		String serial=mDao.getSerial(mb_id);
		System.out.println("pwEncode="+pwEncode);
		System.out.println("serial="+serial);
		if(pwEncode!=null) {
			if(pwEncoder.matches(mb_pw, pwEncode)) {
				//원래 였다면 리퀘스트 영역이나 세션영역에 저장했겠지만 세션을 DI컨테이너에 오토와이어한다.
				
				session.setAttribute("id", mb_id);
				session.setAttribute("serial", serial);
				
				view="main";
				
			}
		}else {
			view="loginPg";
		}
		mav.setViewName(view);*/
		
		String pw = mDao.getSecurityPw(mb_id);
		int serial = mDao.getSerial(mb_id);
		System.out.println("pw="+pw);
		System.out.println("serial="+serial);
	
		if(pw!=null) {
			if(pw.equals(mb_pw)) {
				//원래 였다면 리퀘스트 영역이나 세션영역에 저장했겠지만 세션을 DI컨테이너에 오토와이어한다.
				
				session.setAttribute("id", mb_id);
				session.setAttribute("serial", serial);
				
				view="main";
				
			}
		}else {
			view="loginPg";
		}
		mav.setViewName(view);
		
		return mav;
		
		
		
	}

}
