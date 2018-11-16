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

		/*idx-getBoardList*/
	public ModelAndView getBoardList() {

		mav = new ModelAndView();
		String view = null;

		String id = (String) session.getAttribute("id");
		System.out.println("id확인=" + id);

		if (id != null) {
			List<Board> bList = bDao.getBoardList();
			List<BoardUpload> buList = bDao.getBoardUploadList();
			List<Reply> rList=bDao.getReplyList();
			//mav.addObject("makeBList", makeBList(bList, buList));
			mav.addObject("blist",bList);
			mav.addObject("bulist",buList);
			mav.addObject("rlist",rList);
			view = "postUploadPg";
		} else {
			view = "main";
		}

		mav.setViewName(view);

		return mav;

	}
	/*idx-makeBList(List<Board> bList, List<BoardUpload> buList)*/
	private Object makeBList(List<Board> bList, List<BoardUpload> buList) {
		StringBuilder sb = new StringBuilder();
		/*for (int i = 0; i < bList.size(); i++) {
			int replyConunt=bDao.getReplyCount(bList.get(i).getB_no());
			int likesConunt=bDao.getLikesCount(bList.get(i).getB_no());
			sb.append("<div id='container'>" + "		      <div id='header'>" + "		        <h1>"
					+ bList.get(i).getB_mbid() + "</h1>" + "					<h5 id='flno'>"
					+ bList.get(i).getB_flno() + "</h5>" + "		      </div>"
					+ "				<div id='sideheader'>" + "		            <h3 id='date'>"
					+ bList.get(i).getB_date() + "					</h3>" + "		        </div>"
					+ "		      <div id='content'>" + "		        <h2>내용</h2><br/>" + bList.get(i).getB_content()
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
			sb.append("</div>" + "<div id='footer'>" + "		<a href='#' onclick=\"postInfo('"
					+ bList.get(i).getB_no() + "')\">댓글</a>+"+replyConunt+"<br/>" + "				<a href='likes?b_no="
					+ bList.get(i).getB_no() + "'>좋아요</a>+"+likesConunt+"<br/>" + "				<a href='reportSend?b_no="
					+ bList.get(i).getB_no() + "'>신고하기</a>" + "		      </div>" + "		    </div>");

		}; // for end   */
		
		for (int i = 0; i < bList.size(); i++) {
			int replyConunt=bDao.getReplyCount(bList.get(i).getB_no());
			int likesConunt=bDao.getLikesCount(bList.get(i).getB_no());
			boolean imgcheck = false;
			sb.append("<div class='post-content'>");
			
			for (int j = 0; j < buList.size(); j++) {
				if (bList.get(i).getB_no().equals(buList.get(j).getBu_code())) {
					sb.append("<img style='max-height:50%; max-width:100%; margin-left: auto; margin-right: auto; display: block;'"
							+ "src='"+ buList.get(j).getBu_path()+ buList.get(j).getBu_filesys() + "'>");
				} // if end
			} // for end
			sb.append("              <div class='post-container' style='width:200px;'>" + 
					"                <img src='http://placehold.it/300x300' alt='user' class='profile-photo-md pull-left' />" + 
					"                <div class='post-detail'>" + 
					"                  <div class='user-info'>" + 
					"                    <h5><a href='timeline.html' class='profile-link'>"+ bList.get(i).getB_mbid() +"</a> <span class='following'>"+bList.get(i).getB_flno()+"</span></h5>" + 
					"                    <p class='text-muted' style='text-align: right;'>"+ bList.get(i).getB_date()+"</p>" + 
					"                  </div>" + 
					"                  <div class='reaction'>" + 
					"                  </div>" + 
					"                  <div class='line-divider'></div>" + 
					"                  <div class='post-text'>" + 
					"                    <p>"+ bList.get(i).getB_content()+"</p>" + 
					"                  </div>" + 
					"                  <div class=\"line-divider\"><a href='#' onclick='postInfo('"+ bList.get(i).getB_no() + "')'>댓글</a>"+replyConunt+"</div>" + 
					" 					<a class='btn text-green' href='likes?b_no="+bList.get(i).getB_no() +"'><i class='icon ion-thumbsup'></i>"+likesConunt+"</a>" + 
					"                </div>" + 
					"              </div>" + 
					"            </div>");
			
			

		}
		; // for end
		return sb.toString();
	}

	/* @Transactional *//*idx-postUpload(MultipartHttpServletRequest multi)*/
	public ModelAndView postUpload(MultipartHttpServletRequest multi) {

		mav = new ModelAndView();
		String view = null;

		// 폼으로 가져온 모든 데이터를 각각 변수에 저장합니다
		int b_flno = Integer.parseInt(multi.getParameter("b_flno"));
		int b_openlv = Integer.parseInt(multi.getParameter("b_openlv"));
		String b_content = multi.getParameter("b_content");
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

	/*idx-postInfo(String b_no)*/
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
		List<Reply> rList=bDao.getReply(b_no);
		if (id != null && post != null) {
			System.out.println("post upload succes");
			mav.addObject("b", post);
			mav.addObject("bu", file);
			mav.addObject("rList", rList);
			view = "postDetailPg";
		}

		System.out.println("view start");
		mav.setViewName(view);

		return mav;
	}

	
	/*idx-replyInsert(Reply r)*/
	public Map<String, List<Reply>> replyInsert(Reply r) {
		/*mav = new ModelAndView();
		double r_no=1;
		String view = null;
		if(bDao.replyNoCheck(r.getR_bno())<=r_no) {
			System.out.println("추가전rNo="+r_no);
					r_no++;
		}
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
			//mav.addObject("rList", makerList(rList));
			mav.addObject("rList", rList);
			view="postDetailPg";
		}else {
		view="main";
		}
		mav.setViewName(view);
		return mav;
		 */
		double r_no=1;
		System.out.println("들어왔음");
		Map<String, List<Reply>> jMap=null;
		Reply re=bDao.replyNoCheck(r.getR_bno());
		if(re!=null) {
			System.out.println("추가전rNo="+re.getR_no());
					r_no=re.getR_no()+1;
		}
		System.out.println("추가후rNo="+r_no);
		
		r.setR_no(r_no);
		r.setR_mbid(session.getAttribute("id").toString());
		if(bDao.replyInsert(r)) {
			List<Reply> rList=bDao.getReply(r.getR_bno());
			jMap=new HashMap<String,List<Reply>>();
			jMap.put("rList", rList);
			System.out.println(jMap);
		}else {
			jMap=null;
		}
		return jMap;
	}//replyInsert end

}//class end
