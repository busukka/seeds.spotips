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
import com.seeds.spotips.bean.FieldList;
import com.seeds.spotips.bean.Reply;
import com.seeds.spotips.dao.BoardDao;
import com.seeds.spotips.dao.ImemberDao;
import com.seeds.spotips.userclass.UploadFile;

@Service
public class BoardManagement {
	@Autowired
	private BoardDao bDao; // 필드명과 bean태그의 id와 일치해야한다
	@Autowired
	private HttpSession session; // session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ImemberDao mDao;
	
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
			MemberManagement mm=new MemberManagement();
			List<Board> bList = bDao.getBoardList();
			List<BoardUpload> buList = bDao.getBoardUploadList();
			List<Reply> rList=bDao.getReplyList();
			//mav.addObject("makeBList", makeBList(bList, buList));
			mav.addObject("blist",bList);
			mav.addObject("bulist",buList);
			mav.addObject("rlist",rList);
			view = "boardPg";
		} else {
			view = "main";
		}

		mav.setViewName(view);

		return mav;

	}
	
	public void getFieldList() {
		mav = new ModelAndView();
		ArrayList<FieldList> fl = new ArrayList<FieldList>();
		String FLCheckBoxHTML = null;
		fl = mDao.getFieldList();
		FLCheckBoxHTML = makeFieldListCheckBox(fl);
		System.out.println("FLCheckBoxHTML생성 완료");
		mav.addObject("FLCheckBoxHTML", FLCheckBoxHTML);

	}
	private String makeFieldListCheckBox(ArrayList<FieldList> fl) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fl.size(); i++) {
			sb.append("<input type='radio' id="+fl.get(i).getFl_name()+i+" name='b_flno' value='"
					+ fl.get(i).getFl_no() + "'>" +"<label for="+fl.get(i).getFl_name()+i+">"
					+ fl.get(i).getFl_name()+"</label>&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		return sb.toString();
	}

	/*idx-makeBList(List<Board> bList, List<BoardUpload> buList)*/
	private Object makeBList(List<Board> bList, List<BoardUpload> buList) {
		StringBuilder sb = new StringBuilder();
	sb.append("<div class='post-content' style='z-index:2;'>"+
             "<div class='post-container'>"+
              " <img src='http://placehold.it/300x300' alt='user' class='profile-photo-md pull-left' />"+
              "  <div class='post-detail'>" +
              "    <div class='user-info'>" +
              "      <h5><a href='timeline.html' class='profile-link'>${b.b_mbid}</a> <span class='following'>${b.b_flno}</span></h5>" +
              "      <p class='text-muted'>${b.b_date}</p>    " +
              "  </div>" +
              "  <div class='reaction'>   " +
              "    <a class='btn text-green'><i class='icon ion-thumbsup'></i>likes 숫자</a>   " +
              "  </div> "+
              "  <div class='line-divider'></div>"+
              " 				<img src='${bu.bu_path}${bu.bu_filesys}' alt='post-image' class='img-responsive post-image' />"+
              "  <div class='post-text'> "+
              "    <p>${b.b_content}</p> "+
              "  </div>"+
              "  <div class='line-divider'><h5>댓글</h5></div> "+
              "  <div id=replyList> "+
              "   				<div class='post-comment'>"+
            /*  "   				 <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />"+ */
              " 				   <p><a href='timeline.html' class='profile-link'>${r.r_mbid}</a>${r.r_content}</p>"+
            	  " 			 </div>"+
            	  " 		</div>"+
            	  " &nbsp;&nbsp;"+
            	  " <form id='rForm' name='rForm'>"+
            	  " <div class='post-comment'>"+
            	  " <img src='http://placehold.it/300x300' alt='' class='profile-photo-sm' />"+
            	  " <input type='text' name='r_content' id='r_content' class='form-control' placeholder='Post a comment'>"+
            	  " 	<span><input type='button' value='입력' id='btn' onclick='replyInsert('${b .b_no}')'"+
            	  " 		style='width: 60px; height: 45px'></span>"+
            	  " </div>"+
            	  " </form>"+
            	  "    </div>"+
            	  " </div>"+
            	  " </div>");
		
		
		return sb.toString();
	}

	/* @Transactional *//*idx-postUpload(MultipartHttpServletRequest multi)*/
	public ModelAndView postUpload(MultipartHttpServletRequest multi) {

		mav = new ModelAndView();
		String view = null;
		System.out.println("들어오니");
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
		List<MultipartFile> file=multi.getFiles("bu_files");
		String fileCheck=file.get(0).getOriginalFilename();
		System.out.println("fileCheck="+fileCheck);
		if(fileCheck.equals("") || fileCheck.equals(null) ) 
			System.out.println("파일 첨부 없음");
		else
			f = upload.fileUp(multi, board.getB_no());
		
		if (f || b)
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
	public Map<String, List<Reply>> replyInsert(String bno, String content) {
		
		double r_no=1;
		System.out.println("들어왔음");
		Map<String, List<Reply>> jMap=null;
		Reply re=bDao.replyNoCheck(bno);
		if(re!=null) {
			System.out.println("추가전rNo="+re.getR_no());
					r_no=re.getR_no()+1;
		}
		System.out.println("추가후rNo="+r_no);
		Reply r = new Reply();
		r.setR_bno(bno);
		r.setR_no(r_no);
		r.setR_mbid(session.getAttribute("id").toString());
		r.setR_content(content);
		System.out.println("내용 ="+content);
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

	public ModelAndView gopostUploadPg() {
		mav = new ModelAndView();
		
		
		String view = null;

		String id = (String) session.getAttribute("id");
		if (id != null) {
			getFieldList();
			view = "postUploadPg";
		} else {
			view = "main";
		}

		mav.setViewName(view);

		return mav;
	
	}

}//class end
