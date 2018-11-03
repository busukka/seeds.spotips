package com.seeds.spotips.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.GenMember;
import com.seeds.spotips.dao.AdminDao;

@Service
public class AdminManagement {
	@Autowired
	private AdminDao aDao; // 필드명과 bean태그의 id와 일치해야한다
	
	@Autowired
	private HttpSession session; // session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다
	
	private ModelAndView mav;
	
	public ModelAndView loadGenList() { // 일반회원관리 - 일반회원 전체조회
		mav = new ModelAndView();
		String view = null;
		// 여러개를 받는 함수를 사용 =aDao.genSearch();
		// mav.addobject("이엘로찍을함수",makeHtml(여러개를받는함수))
		// 모든 아이디를 가져와야한다.
		// 1. dao 에 올리기 매퍼에 sql 문 정리
		// 2. 가져온 sql 값을 메이크html 로 만들어서 출력.
		System.out.println("gmlist 가져오기전");
		List<GenMember> gmlist = aDao.loadGenList();
		System.out.println("gmalist 가져옴="+gmlist.get(0).getGm_id());
		//String mg_id = (String) session.getAttribute("id"); //세션로그인 아직임..
		
		String mg_id ="gustj@gmail.com";
		String id = aDao.mgidCheck(mg_id);
		System.out.println("id 출력="+id);
		
		if (id!=null){
				mav.addObject("gmlist", makeHtml(gmlist));
				System.out.println("gmlist"+gmlist);
				view = "genManagementPg";
				System.out.println("management이동");
		}else {
			view="loginPg";
		}
		mav.setViewName(view);
		return mav;
	}

	private Object makeHtml(List<GenMember> gmlist) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<gmlist.size(); i++) {
			sb.append("<tr><td>"+gmlist.get(i).getGm_name()+"</td>");
			sb.append("<td>"+gmlist.get(i).getGm_id()+"</td></tr>");
		}
		return sb.toString();
	}
}
