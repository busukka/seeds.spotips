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
import com.seeds.spotips.bean.BoardUpload;
import com.seeds.spotips.bean.Reply;
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
			List<BoardUpload> buList = bDao.getBoardUploadList();
			mav.addObject("makeBList", makeBList(bList, buList)); 
			view = "boardPg";
		} else {
			view = "main";
		}

		mav.setViewName(view);

		return mav;

	}

	private Object makeBList(List<Board> bList, List<BoardUpload> buList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bList.size(); i++) {
			sb.append("<div id='container'>" + "		      <div id='header'>" + "		        <h1>"
					+ bList.get(i).getB_mbid() + "</h1>" + "					<h5 id='flno'>"
					+ bList.get(i).getB_flno() + "</h5>" + "		      </div>"
					+ "				<div id='sideheader'>" + "		            <h3 id='date'>"
					+ "		      <div id='content'>" + "		        <h2>내용</h2><br/>" + bList.get(i).getB_content()
					+ bList.get(i).getB_date() + "					</h3>" + "		        </div>"
					+ "		       </div> " + "		      <div id='sidebar'> " + "		      <h2>첨부사진/동영상</h2>");
			for (int j = 0; j < buList.size(); j++) {
				if (bList.get(i).getB_no().equals(buList.get(j).getBu_code())) {
					sb.append("<div style='position: absolute;'>");
					sb.append("<div style='position: relative; right:" + (80 + (j * 10)) + "px;'>");
					sb.append("<img width='200' height='200' src='" + buList.get(j).getBu_path()
							+ buList.get(j).getBu_filesys() + "'><br/>");
					sb.append("</div></div>");
				} // if end
			} // for end
			sb.append("</div>" + "<div id='footer'>" + "		<a href='#' onclick=\"articleView('"
					+ bList.get(i).getB_no() + "')\">댓글</a><br/>" + "				<a href='likes?b_no="
					+ bList.get(i).getB_no() + "'>좋아요</a><br/>" + "				<a href='reportSend?b_no="
					+ bList.get(i).getB_no() + "'>신고하기</a>" + "		      </div>" + "		    </div>");

		}
		; // for end
		return sb.toString();
	}

	/* @Transactional */
	public ModelAndView postUpload(MultipartHttpServletRequest multi) {

		mav = new ModelAndView();
		String view = null;

		// 폼으로 가져온 모든 데이터를 각각 변수에 저장합니다
		int b_flno = Integer.parseInt(multi.getParameter("b_flno"));
		int b_openlv = Integer.parseInt(multi.getParameter("b_openlv"));
		String b_content = multi.getParameter("b_content");
		String bu_filesys = multi.getParameter("bu_files");
		String bu_fileori = multi.getParameter("bu_files");
		String id = session.getAttribute("id").toString();

		// Board 빈에 데이터를 저장후 dao 로 이동
		Board board = new Board();
		board.setB_mbid(id);
		board.setB_flno(b_flno);
		board.setB_content(b_content);
		board.setB_openlv(b_openlv);

		boolean b = bDao.postUpload(board);
		// insert후 selectKey로 받아온 b_num 확인
		System.out.println("b_num=" + board.getB_no());
		boolean f = false;
		// UploadFile upload=new UploadFile(); //공유
		// 서버에 파일을 업로드 한 후,
		// 오리지널 파일명, 시스템파일명을 리턴 후 맵에 저장
		f = upload.fileUp(multi, board.getB_no());

		if (f && b)
			mav = getBoardList();
		else
			mav.setViewName("boardPg");

		return mav;
	}

	public static String getUuid() {

		return UUID.randomUUID().toString().replaceAll("-", "");

	}

	public ModelAndView postInfo(String b_no) {
		mav = new ModelAndView();
		String view = null;

		String id = session.getAttribute("id").toString();
		/* String b_no = request.getAttribute("b_no").toString(); */
		System.out.println("b_no확인=" + b_no);
		System.out.println("id확인=" + id);

		System.out.println("post upload before");
		Board post = bDao.postInfo(b_no);
		List<BoardUpload> file = bDao.postFileInfo(b_no);
		List<Reply> rList=bDao.getReplyList(b_no);
		if (id != null && post != null) {
			System.out.println("post upload succes");
			mav.addObject("b", post);
			mav.addObject("bu", file);
			mav.addObject("rList", makerList(rList));
			view = "postDetailPg";
		}

		System.out.println("view start");
		mav.setViewName(view);

		return mav;
	}

	
	private Object makerList(List<Reply> rList) {
		StringBuilder sb = new StringBuilder();
			for(int i=0;i<rList.size();i++) {
				sb.append(" 아이디 : "+rList.get(i).getR_mbid()+"	");
				sb.append(" 내용 : "+rList.get(i).getR_content()+"	");
				sb.append(" 날짜 : "+rList.get(i).getR_date()+"	<br/>");
				sb.append(" <a href='#'>답글달기</a> 	");
				sb.append(" <a href='#'>신고하기</a>	<br/><hr>");
			}
			return sb.toString();
	}

	
	
	public ModelAndView replyInsert(Reply r) {
		mav = new ModelAndView();
		double r_no=1;
		String view = null;
		/*if(bDao.replyNoCheck(r.getR_bno())<=r_no) {
			System.out.println("추가전rNo="+r_no);
					r_no++;
		}*/
		Reply re=bDao.replyNoCheck(r.getR_bno());
		if(re!=null) {
			System.out.println("추가전rNo="+re.getR_no());
					r_no=re.getR_no()+1;
		}
		System.out.println("추가후rNo="+r_no);
		
		r.setR_no(r_no);
		r.setR_mbid(session.getAttribute("id").toString());
		if(bDao.replyInsert(r)) {
			List<Reply> rList=bDao.getReplyList(r.getR_bno());
			mav.addObject("rList", makerList(rList));
			view="postDetailPg";
		}else {
		view="main";
		}
		mav.setViewName(view);
		return mav;
	}

}
