package com.seeds.spotips.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.Board;
import com.seeds.spotips.dao.BoardDao;
import com.seeds.spotips.userclass.UploadFile;

@Service
public class BoardManagement {
	@Autowired
	private BoardDao bDao; // 필드명과 bean태그의 id와 일치해야한다
	@Autowired
	private HttpSession session; // session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다

	@Autowired
	private HttpServletRequest request;

	private ModelAndView mav;

	@Autowired
	private UploadFile upload;
	
	public ModelAndView getBoardList() {

		mav = new ModelAndView();
		String view = null;

		String id = (String) session.getAttribute("id");
		System.out.println("id확인=" + id);

		if (id != null) {
			List<Board> bList = bDao.getBoardList();

			mav.addObject("makeBList", makeBList(bList));

			view = "boardPg";
		} else {
			view = "main";
		}

		mav.setViewName(view);

		return mav;

	}

	private Object makeBList(List<Board> bList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bList.size(); i++) {
			sb.append("");
			sb.append("테스트 게시물번호" + bList.get(i).getB_no() + "<br/>");
			sb.append("테스트 아이디" + bList.get(i).getB_mbid() + "<br/>");
			sb.append("테스트 날짜" + bList.get(i).getB_date() + "<br/>");
			sb.append("테스트 관련분야번호" + bList.get(i).getB_flno() + "<br/>");
			sb.append("테스트 내용" + bList.get(i).getB_content() + "<br/><hl/>");

		}
		;
		return sb.toString();
	}

	@Transactional
	public ModelAndView postUpload(MultipartHttpServletRequest multi) {
		
		//1개의 file tag를 이용해서 여러파일을 선택할 때
		/*List<MultipartFile> file=multi.getFiles("bfile");
		for(int i=0;i<file.size();i++) {
			String f=file.get(i).getOriginalFilename();
			System.out.println("file"+i+":"+f);
		}*/
		mav=new ModelAndView();
		String view=null;
		System.out.println("찍어볼게용="+multi.getParameter("b_flno"));
		int b_flno=Integer.parseInt(multi.getParameter("b_flno"));
		int b_openlv=Integer.parseInt(multi.getParameter("b_openlv"));
		String b_content=multi.getParameter("b_content");
		String bu_filesys=multi.getParameter("bu_files");
		int check=Integer.parseInt(multi.getParameter("fileCheck"));
		System.out.println("b_no="+b_flno);
		System.out.println("b_openlv="+b_openlv);
		System.out.println("b_content="+b_content);
		System.out.println("bu_filesys="+bu_filesys);
		System.out.println("check="+check);
		String id=session.getAttribute("id").toString();
		
		Map<String, String> fMap=null;
		Board board=new Board();
		board.setB_mbid(id);
		board.setB_flno(b_flno);
		board.setB_content(b_content);
		board.setB_openlv(b_openlv);
		boolean b=bDao.postUpload(board);
		//insert후 selectKey로 받아온  b_num
		System.out.println("b_num="+board.getB_no());
		boolean f=false;
		if(check==1) {
			//UploadFile upload=new UploadFile(); //공유
			//서버에 파일을 업로드 한 후,
			//오리지널 파일명, 시스템파일명을 리턴 후 맴에 저장
			f=upload.fileUp(multi,board.getB_no());
			}
		if(f && b)
			view="redirect:BoardPg";
		else
			view="postUploadPg";
		mav.setViewName(view);
		return mav;
	}
		
		
		
		
		
	

	public static String getUuid() {

		return UUID.randomUUID().toString().replaceAll("-", "");

	};

}
