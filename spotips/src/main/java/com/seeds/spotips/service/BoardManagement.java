package com.seeds.spotips.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.Board;
import com.seeds.spotips.dao.BoardDao;


@Service
public class BoardManagement {
	@Autowired
	private BoardDao bDao; //필드명과 bean태그의 id와 일치해야한다
	@Autowired
	private HttpSession session; //session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다 
	
	private ModelAndView mav;
	
	public ModelAndView getBoardList() {

		mav=new ModelAndView();
		String view=null;
		
		
		String id=(String) session.getAttribute("id");
		System.out.println("id확인="+id);
		
		
		
		List<Board> bList=bDao.getBoardList();
		
		System.out.println("보드리스트 사이즈 ="+bList.size());
		session.setAttribute("makeBList", makeBList(bList));
		
		view="board";
		
		
		mav.setViewName(view);
		
		return mav;
		
		
		
	}

	private Object makeBList(List<Board> bList) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i>bList.size();i++) {
			sb.append("테스트 게시물번호"+bList.get(i).getB_no()+"<br>");
			sb.append("테스트 아이디"+bList.get(i).getB_mbid()+"<br>");
			sb.append("테스트 날짜"+bList.get(i).getB_date()+"<br>");
			sb.append("테스트 관련분야번호"+bList.get(i).getB_flno()+"<br>");
			sb.append("테스트 내용"+bList.get(i).getB_content()+"<br>");
			
		}
		String board = sb.toString();
		System.out.println("board 스트링="+board);
		return board;
	}

}
