package com.seeds.spotips.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.BusMember;
import com.seeds.spotips.bean.FieldList;
import com.seeds.spotips.bean.GenMember;
import com.seeds.spotips.dao.AdminDao;

@Service
public class AdminManagement {
	@Autowired
	private AdminDao aDao; // 필드명과 bean태그의 id와 일치해야한다
	/*
	 * @Autowired private HttpSession session; // session은 컨테이너에 넣지 않아도 오토와이어만 해도
	 * 스프링이 저절로 DI컨테이너에 넣어준다
	 * 
	 * @Autowired private HttpServletRequest request;
	 */

	private ModelAndView mav;
							//idx-loadGenList
	public ModelAndView loadGenList() { // 일반회원관리 - 일반회원 전체조회
		mav = new ModelAndView();
		String view = null;
		// 여러개를 받는 함수를 사용 =aDao.genSearch();
		// mav.addobject("이엘로찍을함수",makeHtml(여러개를받는함수))
		// 모든 아이디를 가져와야한다.
		// 1. dao 에 올리기 매퍼에 sql 문 정리
		// 2. 가져온 sql 값을 메이크html 로 만들어서 출력.
		List<GenMember> gmlist = aDao.loadGenList();
		// System.out.println("gmlist 가져옴="+gmlist.get(0).getGm_id());
		// String mg_id = (String) session.getAttribute("id"); // ---일반회원 세션로그인 아직임..
		String mb_id = "gustj@gmail.com"; // ******관리자 로그인 세션 확인 안돼서 임의로 설정!!!
		String id = aDao.mgidCheck(mb_id); // 관리자 아이디를 들고 Dao로 가서 아이디 이메일 일치한 지 확인.
		System.out.println("id 출력=" + id);
		if (id != null) { // 관리자 아이디가 일치하는 경우
			mav.addObject("gmlist", makeGenHtml(gmlist)); // "gmlist"라는 오브젝트에 gmlist를 담아온당
			System.out.println("gmlist" + gmlist);
			view = "genManagementPg";
			System.out.println("management이동");
		} else {
			view = "loginPg";
		}
		mav.setViewName(view);
		return mav;
	}

						// index-makeGenHtml
	private Object makeGenHtml(List<GenMember> gmlist) { // 일반회원관리 - 일반회원 전체조회 2
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < gmlist.size(); i++) {
			sb.append("<tr><td>" + gmlist.get(i).getMb_name() + "</td>");
			sb.append("<td>" + gmlist.get(i).getMb_id() + "</td></tr>");
		}
		return sb.toString();
	}

	public ModelAndView generalSearch(HttpServletRequest request) { // 일반회원조회 - 일반회원 검색결과조회
		mav = new ModelAndView();
		String key = request.getParameter("key"); // 내가 입력한 값, text박스의 name값!!
		String key2 = request.getParameter("SearchGmlist"); // 검색구분 select태그의 name값!!
		String view = null;
		String mb_id; // 관리자아이디
		List<GenMember> searchGmlist;

		Map<String, String> map = new HashMap<String, String>();
		map.put("key2", key2);
		map.put("key", key);
		System.out.println("가져온 key=" + key);
		System.out.println("가져온 key2=" + key2);
		System.out.println("map=" + map);
		System.out.println("----------------------------------------");
		System.out.println(map.get("key"));

		mb_id = "gustj@gmail.com"; // session로그인 안되어서 임시로 관리자 아이디 지정
		String id = aDao.mgidCheck(mb_id);
		System.out.println("id=" + id);

		if (id != null) { // 관리자 아이디가 일치하는 경우
			if (key2.equals("닉네임")) { // 검색구분이 닉네임일 경우
				System.out.println("key 마지막확인 = " + map.get("key"));
				searchGmlist = aDao.generalNameSearch(map.get("key"));

				System.out.println(searchGmlist);
				mav.addObject("gmlist", makeGenHtml(searchGmlist)); // "gmlist"라는 오브젝트에 bmlist를 담아온당
				view = "genManagementPg";

			} else if (key2.equals("이메일")) { // 검색구분이 이메일일 경우
				System.out.println("key 마지막확인 = " + map.get("key"));
				searchGmlist = aDao.generalIdSearch(map.get("key"));
				System.out.println(searchGmlist);
				mav.addObject("gmlist", makeGenHtml(searchGmlist)); // "gmlist"라는 오브젝트에 bmlist를 담아온당
				view = "genManagementPg";

			}
		} else {
			view = "loginPg";
		}
		// 아이디체크 이프문
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView loadBusList() { // 기업회원관리 - 기업회원 전체조회
		mav = new ModelAndView();
		System.out.println("1");
		String view = null;
		List<BusMember> bmlist = aDao.loadBusList(); // 기업회원 빈의 bmlist를 만듬
		// String mg_id = (String) session.getAttribute("id"); // ---기업회원 세션로그인 아직임..
		String mb_id = "gustj@gmail.com"; // ******관리자 로그인 세션 확인 안돼서 임의로 설정!!!
		String id = aDao.mgidCheck(mb_id);
		System.out.println("id=" + id);
		if (id != null) { // 관리자 아이디가 일치하는 경우
			mav.addObject("bmlist", makeBusHtml(bmlist)); // "bmlist"라는 오브젝트에 bmlist를 담아온당
			System.out.println("bmlist=" + bmlist);
			view = "busManagementPg";
		} else {
			view = "loginPg";
		}
		mav.setViewName(view);
		return mav;
	}

	private Object makeBusHtml(List<BusMember> bmlist) { // 기업회원관리 - 기업회원 전체조회22
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bmlist.size(); i++) {
			sb.append("<tr><td>" + bmlist.get(i).getMb_name() + "</td>");
			sb.append("<td>" + bmlist.get(i).getMb_id() + "</td></tr>");
		}
		return sb.toString();
	}

	public ModelAndView businessSearch(HttpServletRequest request) { // 기업회원조회 - 기업회원 검색결과조회
		mav = new ModelAndView();
		String key = request.getParameter("key"); // 내가 입력한 값
		String key2 = request.getParameter("SearchBmlist"); // 검색구분 아이디/닉네임 <select name="SearchBmlist">
		String view = null;
		String mb_id; // 관리자아이디
		List<BusMember> searchBmlist;

		Map<String, String> map = new HashMap<String, String>();
		map.put("key2", key2);
		map.put("key", key);
		System.out.println("가져온 key=" + key);
		System.out.println("가져온 key2=" + key2);
		System.out.println("map=" + map);
		System.out.println("----------------------------------------");
		System.out.println(map.get("key"));

		/*
		 * for(String mapkey : map.keySet()) {
		 * System.out.println("key : "+mapkey+",key2:"+map.get(mapkey)); }
		 */

		mb_id = "gustj@gmail.com"; // session로그인 안되어서 임시로 관리자 아이디 지정
		String id = aDao.mgidCheck(mb_id);
		System.out.println("id=" + id);

		if (id != null) { // 관리자 아이디가 일치하는 경우
			if (key2.equals("닉네임")) { // 검색구분이 닉네임일 경우
				System.out.println("key 마지막확인 = " + map.get("key"));
				searchBmlist = aDao.businessNameSearch(map.get("key"));

				System.out.println(searchBmlist);
				mav.addObject("bmlist", makeBusHtml(searchBmlist)); // "bmlist"라는 오브젝트에 bmlist를 담아온당
				view = "busManagementPg";

			} else if (key2.equals("이메일")) { // 검색구분이 이메일일 경우
				searchBmlist = aDao.businessIdSearch(map.get("key"));
				System.out.println(searchBmlist);
				mav.addObject("bmlist", makeBusHtml(searchBmlist)); // "bmlist"라는 오브젝트에 bmlist를 담아온당
				view = "busManagementPg";

			}
		} else {
			view = "loginPg";
		}
		// 아이디체크 이프문
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView goConcernPg() { // 관심분야 관리페이지 - 관심분야 전체조회
		mav = new ModelAndView();
		String view = null;
		// String mg_id = (String) session.getAttribute("id"); // ---일반회원 세션로그인 아직임..
		String mb_id = "gustj@gmail.com"; // ******관리자 로그인 세션 확인 안돼서 임의로 설정!!!
		String id = aDao.mgidCheck(mb_id); // 관리자 아이디를 들고 Dao로 가서 아이디 이메일 일치한 지 확인.
		System.out.println("id 출력=" + id);
		if (id != null) { // 관리자 아이디가 일치하는 경우
			List<FieldList> flist = aDao.goConcernPg();
			System.out.println("flist = " + flist);
			mav.addObject("flist", makeFieldHtml(flist)); // "flist"라는 오브젝트에 flist를 담아온당
			view = "adminConcernPg";
			System.out.println("페이지 이동");
		} else {
			view = "loginPg";
		}
		mav.setViewName(view);
		return mav;
	}

	private Object makeFieldHtml(List<FieldList> flist) { // 관심분야 관리페이지 - 관심분야 전체조회
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < flist.size(); i++) {
			sb.append("<tr><td>" + flist.get(i).getFl_no() + "</td>");
			sb.append("<td>" + flist.get(i).getFl_name() + "</td>");
			sb.append("<td><img src='/resource/images/upload/" + flist.get(i).getFl_imgsysname() + "'/></td></tr>");
		}
		return sb.toString();
	}

	public ModelAndView concernInsert() { // 관심분야 추가
		
		mav = new ModelAndView();
		System.out.println("들어왔엄");
	/*	String view = null;
		// String mb_id = (String) session.getAttribute("id"); // ---일반회원 세션로그인 아직임..
		String mb_id = "gustj@gmail.com"; // ******관리자 로그인 세션 확인 안돼서 임의로 설정!!!
		String id = aDao.mgidCheck(mb_id); // 관리자 아이디를 들고 Dao로 가서 아이디 이메일 일치한 지 확인.
		System.out.println("id 출력=" + id);
		if (id != null) { // 관리자 아이디가 일치하는 경우
			List<FieldList> flist = aDao.concernInsert();
			System.out.println("flist = " + flist);
			mav.addObject("flist", makeFieldHtml(flist)); // "flist"라는 오브젝트에 flist를 담아온당
			view = "adminConcernPg";
			System.out.println("페이지 이동");
		} else {
			view = "loginPg";
		}
		mav.setViewName(view);*/
		return mav;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
