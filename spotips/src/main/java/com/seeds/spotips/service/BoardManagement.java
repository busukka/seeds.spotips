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
import org.apache.tomcat.jni.Buffer;
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
import com.seeds.spotips.bean.Likes;
import com.seeds.spotips.bean.Member;
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

	/* idx-getBoardList */
	public ModelAndView getBoardList() {

		mav = new ModelAndView();
		String view = null;

		String id = (String) session.getAttribute("id");
		System.out.println("id확인=" + id);

		if (id != null) {
			MemberManagement mm = new MemberManagement();
			List<Board> bList = bDao.getBoardList();
			List<BoardUpload> buList = bDao.getBoardUploadList();
			List<Reply> rList = bDao.getReplyList();
			List<Member> mList = bDao.getprofileList();
			List<FieldList> fList=bDao.getFieldList();
			List<Likes> lList =bDao.getLikesList();
			// mav.addObject("makeBList", makeBList(bList, buList));
			mav.addObject("boardlist", makeboardList(rList, buList , bList , mList, fList, lList));
			view = "boardPg";
		} else {
			view = "main";
		}

		mav.setViewName(view);

		return mav;

	}

	private Object makeboardList(List<Reply> rList, List<BoardUpload> buList, List<Board> bList, 
			List<Member> mList, List<FieldList> fList, List<Likes> lList) {
		StringBuilder sb= new StringBuilder();
		boolean Reply=false;
		
		for(int b=0;bList.size()>b;b++) {
			Member mb=new Member();
					mb=getprofile(mList,bList.get(b).getB_mbid());
	sb.append("		<div class='post-content' style='z-index: 2;'>" + 
			"			<div class='post-container'>" + 
			"				<img src='"+mb.getMb_imgsysname()+"' alt='user'" + 
			"					class='profile-photo-md pull-left' />" + 
			"				<div class='post-detail'>" + 
			"					<div class='user-info'>" + 
			"						<h5> " + 
			"							<a href='timeline.html' class='profile-link'>"+mb.getMb_name()+"</a> <span");
	
				String flName=getflName(fList,bList.get(b).getB_flno());
	sb.append("								class='following'>"+flName+"</span>" + 
			"						</h5> " + 
			"						<p class='text-muted'>"+bList.get(b).getB_date()+"</p>" + 
			"					</div> " + 
			"					<div class='reaction'>");
				int likes=getlikes(lList,bList.get(b).getB_no());
	sb.append("						<a class='btn text-green'><i class='icon ion-thumbsup'></i>likes" + 
			"							+"+likes+"</a>" + 
			"					</div> " + 
			"					<div class='line-divider'></div>");
		for(int bu=0;buList.size()>bu;bu++) {
			if(bList.get(b).getB_no().equals(buList.get(bu).getBu_code()))
	sb.append("							<img src='"+buList.get(bu).getBu_path()+buList.get(bu).getBu_filesys()+"' alt='post-image'" + 
			"								class='img-responsive post-image' />" + 
			"						</c:if>" + 
			"					</c:forEach>");
		};//bu for end
	sb.append("					<div class='post-text'>" + 
			"						<p>"+bList.get(b).getB_content()+"</p>" + 
			"					</div>" + 
			"					<div class=\"line-divider\">");
					int totreply = gettotReply(rList,bList.get(b).getB_no());
	sb.append("						<h5>댓글+"+totreply+"</h5> "+  
			"					</div>" + 
			"					<br />" + 
			"					<div id='"+bList.get(b).getB_no()+"replyList' >");
		for(int r=0; rList.size()>r;r++) {
			if(bList.get(b).getB_no().equals(rList.get(r).getR_bno())) {
				if(rList.get(r).getR_no()%1.0==0) {
				Member rmb=new Member();
						rmb=getprofile(mList,rList.get(r).getR_mbid());
			sb.append("<div class='row' id='"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"'>");
			sb.append("<div class='row'> " + 
					"		<div class='col-md-9 col-sm-9' style='float: left;'> " + 
					"			<img src='"+rmb.getMb_imgsysname()+"' alt='' " + 
					"				class='profile-photo-sm' /> <a href='timeline.html' " + 
					"				class='profile-link'>"+rmb.getMb_name()+"</a> " + 
					"	&nbsp;&nbsp;&nbsp;&nbsp;	"+rList.get(r).getR_content()+"</div> " + 
					"		<div class='col-md-3 col-sm-3' style='float: right;'> " + 
					"			<p style='text-align: right'>"+rList.get(r).getR_date()+"<br /> "+ 
					"				 <a href='javascript:void(0)' id='"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"showrere_coment' "+ 
					"							onclick=\"showrere_coment("+
					"					'"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"')	\" "+
					"					>답글달기</a>&nbsp;&nbsp; " + 
					"				<a href='#'>신고하기</a> " + 
					"			</p> " + 
					"		</div> " + 
					"	</div> "+ 
					"	<div id='"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"reReplyList'> ");
					Reply=true;// 댓글이 있으면
				}//rList (댓글인지)
				for(int rr=0; rList.size()>rr;rr++) {
					if((int)rList.get(r).getR_no()==(int)rList.get(rr).getR_no()) { 
						double result=rList.get(r).getR_no()-(int)rList.get(r).getR_no();
						System.out.println("result="+result);
						if(result!=0.0) {
						System.out.println("내용이 ="+rList.get(rr).getR_content()+"    번호="+rList.get(rr).getR_no() +"    나눈 숫자="+rList.get(r).getR_no()%1.0);
						Member rrmb=new Member();
						rrmb=getprofile(mList,rList.get(rr).getR_mbid());
			sb.append("<div class='row'> " + 
					"		<div class='col-md-1 col-sm-1'></div> " + 
					"		<div class='col-md-3 col-sm-3' style='float: left;'> " +
					"			<i class='icon ion-ios-redo'></i>"+
					"					<img src='"+rrmb.getMb_imgsysname()+"' alt='' " + 
					"						class='profile-photo-sm' /> <a href='timeline.html' " + 
					"						class='profile-link'>"+rrmb.getMb_name()+"</a> " + 
					"		</div> " + 
					"		<div class='col-md-5 col-sm-5'>"+rList.get(rr).getR_content()+"</div> " + 
					"		<div class='col-md-3 col-sm-3' style='float: right;'> " + 
					"			<p style='text-align: right'>"+rList.get(rr).getR_date()+"<br /> <a href='#'>신고하기</a> " + 
					"			</p> " + 
					"		</div> " + 
					"	</div> ");
					}}// 답글인지
				}//답글 for 문 end
					if(Reply) {
					sb.append("</div>");
					sb.append("</div>");
					sb.append("<div id='"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"r_comment'"+ 
							"			class='rr_comment' >"+session.getAttribute("id").toString()+"보드매니지먼트179줄 수정 해서 닉네임으로 바꾸기"+
							"	<input type='text' name='"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"r_content'"+
							" 						id='"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"r_content' " +
							"	class='reform-control' placeholder='답글을 입력해주세요' style='display:none;'>	"+
							"	<span><input type='button' value='입력' id='"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"btn'" + 
							"	onclick=\"replyInsert('"+bList.get(b).getB_no()+(int)rList.get(r).getR_no()+"',"+bList.get(b).getB_no().length()+")\" style='display:none;' ></span> "+ 
							"	</div>	");
					}
			}//rList (해당 게시물에 있는 댓글인지) end
			};//rList for end
			Member sessionmb=new Member();
			sessionmb=getprofile(mList,(String)session.getAttribute("id"));
			System.out.println("sessionmb="+sessionmb.getMb_id());
			sb.append("</div id='"+bList.get(b).getB_no()+"replyAdd' >"+ 
					"			&nbsp;&nbsp;" + 
					"			<form id='"+bList.get(b).getB_no()+"rForm' name='"+bList.get(b).getB_no()+"rForm'>" + 
					"				<div class='post-comment'>" + 
					"					<img src='"+sessionmb.getMb_imgsysname()+"' alt=''" + 
					"						class='profile-photo-sm' /> <input type='text'" + 
					"						name='"+bList.get(b).getB_no()+"r_content' id='"+bList.get(b).getB_no()+"r_content'" + 
					"						class='form-control' placeholder='댓글을 입력해주세요'> <span><input" + 
					"						type='button' value='입력' id='"+bList.get(b).getB_no()+"btn'" + 
					"						onclick=\"replyInsert('"+bList.get(b).getB_no()+"',0)\" style='width: 60px; height: 45px'></span>" + 
					"				</div>" + 
					"			</form>" + 
					"			</div>" + 
					"			</div>" + 
					"			</div>");
		
		};//bList for end
			return sb.toString();
	}

	private int gettotReply(List<Reply> rList, String b_no) {
		int reply=0;
		for(int i=0;rList.size()>i;i++) {
			if(rList.get(i).getR_bno().equals(b_no)) {
				reply++;
			}
		}
		return reply;
	}

	private int getlikes(List<Likes> lList, String b_no) {
		int likes=0;
		for(int i=0;lList.size()>i;i++) {
			if(lList.get(i).getLk_bno().equals(b_no)) {
				likes++;
			}
		}
		return likes;
	}

	private String getflName(List<FieldList> fList, int b_flno) {
		for(int i=0;fList.size()>i;i++) {
			if(fList.get(i).getFl_no()==b_flno) {
				return fList.get(i).getFl_name();
			}
		}
		return null;
	}

	private Member getprofile(List<Member> mList, String mbid) {
		for(int i=0;mList.size()>i;i++) {
			if(mList.get(i).getMb_id().equals(mbid)) {
				return mList.get(i);
			}
		}
		return null;
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
			sb.append("<input type='radio' id=" + fl.get(i).getFl_name() + i + " name='b_flno' value='"
					+ fl.get(i).getFl_no() + "'>" + "<label for=" + fl.get(i).getFl_name() + i + ">"
					+ fl.get(i).getFl_name() + "</label>&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		return sb.toString();
	}

	/* @Transactional *//* idx-postUpload(MultipartHttpServletRequest multi) */
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
		List<MultipartFile> file = multi.getFiles("bu_files");
		String fileCheck = file.get(0).getOriginalFilename();
		System.out.println("fileCheck=" + fileCheck);
		if (fileCheck.equals("") || fileCheck.equals(null))
			System.out.println("파일 첨부 없음");
		else
			f = upload.fileUp(multi, board.getB_no());

		if (f || b)
			mav = getBoardList();
		else
			mav.setViewName("boardPg");

		return mav;
	}

	/* idx-postInfo(String b_no) */
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
		List<Reply> rList = bDao.getReply(b_no);
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

	/* idx-replyInsert(Reply r) */
	public ArrayList<Map> replyInsert(String b_no, String r_content, int rCheck) {

		double r_no = 1;
		
		System.out.println("들어왔음");
		Map<String, List<Reply>> rMap = null;
		Map<String, List<Member>> mMap = null;
		ArrayList<Map> mapList =null;
		if(rCheck!=0) {
			b_no=b_no.substring(0,rCheck);
		System.out.println("b_no"+b_no);}
		Reply re = bDao.replyNoCheck(b_no);
		if (re != null) {
			if(rCheck==0) {
			r_no = re.getR_no() + 1;
			}else{
				System.out.println("답글 달기 ok");
				r_no=re.getR_no()+0.001;
			}
		}
		System.out.println("추가후rNo=" + r_no);
		Reply r = new Reply();
		r.setR_bno(b_no);
		r.setR_no(r_no);
		r.setR_mbid(session.getAttribute("id").toString());
		r.setR_content(r_content);

		System.out.println("내용 =" + r_content);
		if (bDao.replyInsert(r)) {
			List<Reply> rList = bDao.getReply(r.getR_bno());
			List<Member> mList = bDao.getprofileList();
			rMap = new HashMap<String, List<Reply>>();
			mMap = new HashMap<String, List<Member>>();
			rMap.put("rList", rList);
			mMap.put("mList",mList);
			System.out.println(rMap);
			System.out.println(mMap);
			mapList = new ArrayList<>();
			mapList.add(mMap);
			mapList.add(rMap);
		} else {
			mapList = null;
		}
		return mapList;
	}// replyInsert end

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

}// class end
