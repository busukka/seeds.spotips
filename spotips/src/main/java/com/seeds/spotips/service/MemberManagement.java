package com.seeds.spotips.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.seeds.spotips.bean.AddrBean;
import com.seeds.spotips.bean.GenMember;
import com.seeds.spotips.bean.MbAddr;
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
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		String pwEncode=mDao.getSecurityPw(mb_id);
		int serial=mDao.getSerial(mb_id);
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
		mav.setViewName(view);
		
		return mav;
		
		/*String pw = mDao.getSecurityPw(mb_id);
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
		mav.setViewName(view);*/
		
		
		
		
		
	}

public ModelAndView gbSelectPg(String select) {
	mav=new ModelAndView();
	String gbSelectHtml="";
	gbSelectHtml = makeGbSelectHtml(select);
	mav.addObject("gbSelectHtml",gbSelectHtml);
	mav.setViewName("gdSelectPg");
	return mav;
}

private String makeGbSelectHtml(String select) {
	StringBuilder sb= null;
	if(select.equals("join")) {
		sb = new StringBuilder();
		sb.append("<tr>");
		sb.append("<td colspan='2'> <a href='./joinGenPg'>일반회원가입</a> </td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td colspan='2'> <a href='./joinBusPg'>기업회원가입</a> </td>");
		sb.append("</tr>");
		
	}else if(select.equals("remind")) {
		sb = new StringBuilder();
		sb.append("<tr>");
		sb.append("<td colspan='2'> <a href='./remindGenPwPg'>일반회원 비번찾기</a> </td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td colspan='2'> <a href='./remindBusPwPg'>기업회원 비번찾기</a> </td>");
		sb.append("</tr>");
		
		
	}else {
		sb = new StringBuilder();
		sb.append("파라미터없음");
	}
	System.out.println(sb.toString());
	return sb.toString();
}

public String mailCheck(String mail) {
	String json=null;
	String mailCheck = null;
	HashMap<String,Integer> mcm = null;
	
	System.out.println("mail(mm)="+mail);
	mailCheck = mDao.mailCheck(mail);
	System.out.println("mailCheck="+mailCheck);
	if(mailCheck==null||mailCheck=="") {
		mcm = new HashMap<String, Integer>();
		mcm.put("mailCheckNo", 1);
		System.out.println("mailCheckNo="+mcm.get("mailCheckNo"));
		
	}else if(mailCheck.equals(mail)) {
		mcm = new HashMap<String, Integer>();
		mcm.put("mailCheckNo", 2);
		System.out.println("mailCheckNo="+mcm.get("mailCheckNo"));
	}
	
	System.out.println("mcm="+mcm.get("mailCheckNo"));
	json=new Gson().toJson(mcm);
	System.out.println("json="+json);
	return json;
}

public boolean certNoCheck(int certNo) {
	String certCode = (String) session.getAttribute("certCode");
	System.out.println("certCode="+certCode);
	int code = Integer.parseInt(certCode);
	System.out.println("code="+code);
	if(certNo==code) {
		session.setAttribute("certStatus", true);
		return true;
	} else {
		session.setAttribute("certStatus", false);
		return false;
	}
	
	
}

public boolean nameCheck(String name) {
	String nameCheck=null;
	boolean nameCheckNo = false;
	
	System.out.println("name(mm)="+name);
	nameCheck = mDao.nameCheck(name);
	System.out.println("nameCheck="+nameCheck);
	if(nameCheck==null||nameCheck=="") {
		nameCheckNo=true;
	}else if(nameCheck.equals(name)) {
		nameCheckNo=false;
	}
	return nameCheckNo;
	
	/*System.out.println("mcm="+mcm.get("mailCheckNo"));
	json=new Gson().toJson(mcm);
	System.out.println("json="+json);
	return json;*/
	
}
@Transactional
public ModelAndView insertGm(GenMember gm, AddrBean ab) {
	mav=new ModelAndView();
	String view=null;
	BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	gm.setGm_pw(pwEncoder.encode(gm.getGm_pw()));
	
	/*멤버id,주소가 들어갈 Bean인스턴스*/
	MbAddr ma = new MbAddr();
	/*파라미터로 가져온 주소Bean의 addr1+2+3로 ma에 넣음,가져온 gm의 id를 ma에 넣음*/
	ma.setMa_gmid(gm.getGm_id());
	String addr=ab.getAddr1()+"/"+ab.getAddr2()+"/"+ab.getAddr3();
	ma.setMa_addr(addr);
	
	if(mDao.insertGm(gm)) {
		ma.setMa_gmid(gm.getGm_id());
		System.out.println("insert:GM회원정보");
		if(mDao.insertAddr(ma)) {
			mav.addObject("mb",gm);
			view="selectConcern";
			System.out.println("insert:GM회원주소");
		}else {
			System.out.println("insert실패:GM회원주소");
			session.invalidate();
			view="redirect:joinGenPg";
		}
	}else {
		System.out.println("insert실패:GM회원정보");
		session.invalidate();
		view="redirect:joinGenPg";
		
	}
	mav.setViewName(view);
	return mav;
}

}
