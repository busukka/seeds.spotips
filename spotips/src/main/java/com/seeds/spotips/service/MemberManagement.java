package com.seeds.spotips.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.seeds.spotips.bean.AddrBean;
import com.seeds.spotips.bean.BusMember;
import com.seeds.spotips.bean.FieldConcern;
import com.seeds.spotips.bean.FieldList;
import com.seeds.spotips.bean.FieldPro;
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
		System.out.println("pwEncode="+pwEncode);
		if(pwEncode!=null) {
			int serial=mDao.getSerial(mb_id);
			System.out.println("serial="+serial);
			if(pwEncoder.matches(mb_pw, pwEncode)) {
				//원래 였다면 리퀘스트 영역이나 세션영역에 저장했겠지만 세션을 DI컨테이너에 오토와이어한다.
				session.setAttribute("id", mb_id);
				session.setAttribute("serial", serial);
				int selectCon = mDao.getSelcetCon(mb_id);
				if(selectCon==1) { //관심분야 선택 여부 1=선택함
					view="main";
				}else if(selectCon==0) {//관심분야 선택 여부 0=아직 선택 안함
					mav.addObject("selectCon",selectCon);
					getFieldList();
					view="selectConcern";
				
				}
			}else {
				view="loginPg";
				mav.addObject("loginCheck",1);//1= alert("비밀번호가 일치하지 않습니다.");
			}
		}else {
			view="loginPg";
			mav.addObject("loginCheck",2);//2= alert("가입되지 않은 이메일입니다.");
		}
		mav.setViewName(view);
		
		return mav;
		
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
	int serial=0; //비번찾기시에 메일 인증후 쓰일 시리얼번호
	String serialStr=null;
	HashMap<String,Integer> mcm = null;
	
	System.out.println("mail(mm)="+mail);
	serialStr = mDao.mailCheck(mail);
	System.out.println("serialStr="+serialStr);
	//해당 이메일과 중복되는 회원이 없을때 serial번호가 null을 반환해서 int로 못받아옴 그래서 String으로 null이 아니라면 int로 변환
	if(serialStr!=null && serialStr!="") { 
		serial=Integer.parseInt(serialStr);
	}
	System.out.println("serial="+serial);
	
	/*mailCheck=DB로부터 받아온 이메일*/
	if(serial==0) {
		mcm = new HashMap<String, Integer>();
		mcm.put("mailSerialNo", 0); /*mailCheckNo=0 이면 해당 아이디 존재x*/ //회원가입(메일중복체크 0보다 크면 중복)에 쓰임
		
	}else if(serial==1) {
		mcm = new HashMap<String, Integer>();
		mcm.put("mailSerialNo", 1); /*mailCheckNo=1이면 일반회원 존재*/ //session(serial)은 비번찾기에쓰임(존재회원인지확인 시리얼로 일반/기업 확인)
		session.setAttribute("serial", serial);						//1이면 GM테이블 들어가서 비번업데이트 2이상이면 BM테이블 들어가서 업데이트
	}else if(serial==2) {
		mcm = new HashMap<String, Integer>();
		mcm.put("mailSerialNo", 2); /*mailCheckNo=2이면 기업회원(승인전) 존재*/ //비번찾기에쓰임
		session.setAttribute("serial", serial);
	}else if(serial==3) {
		mcm = new HashMap<String, Integer>();
		mcm.put("mailSerialNo", 3); /*mailCheckNo=3이면 기업회원(승인후) 존재*/ //비번찾기에쓰임
		session.setAttribute("serial", serial);
	}
	
	System.out.println("mcm="+mcm.get("mailSerialNo"));
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
	
	
}
/*@Transactional*/
public ModelAndView insertGm(GenMember gm, AddrBean ab) {
	mav=new ModelAndView();
	String view=null;
	BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	gm.setMb_pw(pwEncoder.encode(gm.getMb_pw()));
	
	/*멤버id,주소가 들어갈 Bean인스턴스*/
	MbAddr ma = new MbAddr();
	/*파라미터로 가져온 주소Bean의 addr1+2+3로 ma에 넣음,가져온 gm의 id를 ma에 넣음*/
	ma.setMa_gmid(gm.getMb_id());
	String addr=ab.getAddr1()+"/"+ab.getAddr2()+"/"+ab.getAddr3();
	ma.setMa_addr(addr);
	boolean m = mDao.insertGm(gm);
	boolean a = mDao.insertAddr(ma);
	if(m && a) {
			ma.setMa_gmid(gm.getMb_id());
			getFieldList();
			
			gm.setMb_serial(1);
			mav.addObject("mb",gm);
			session.setAttribute("serial",gm.getMb_serial());//1
			
			view="selectConcern";
			System.out.println("insert성공:GM회원정보");
			System.out.println("insert성공:GM회원주소");
		/*트랜잭션 수작업*/
	}else if(m && a==false) {
		System.out.println("insert실패:GM회원주소");
		if(0!=mDao.deleteGm(gm)) {
			System.out.println("delete성공:GM회원정보");
		}else{
			System.out.println("delete실패:GM회원정보");
		}
		session.invalidate();
		view="redirect:joinGenPg";
		
	}else if(a && m==false) {
		System.out.println("insert실패:GM회원정보");
		if(0!=mDao.deleteAddr(ma)) {
			System.out.println("delete성공:GM회원주소");
		}else {
			System.out.println("delete실패:GM회원주소");
		}
		session.invalidate();
		view="redirect:joinGenPg";
	}
	mav.setViewName(view);
	return mav;
}

public void getFieldList() {
	mav=new ModelAndView();
	ArrayList<FieldList> fl = new ArrayList<FieldList>();
	String FLCheckBoxHTML = null;
	fl=mDao.getFieldList();
	FLCheckBoxHTML= makeFieldListCheckBox(fl);
	mav.addObject("FLCheckBoxHTML",FLCheckBoxHTML);

}

private String makeFieldListCheckBox(ArrayList<FieldList> fl) {
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<fl.size();i++) {
				sb.append("<input type='checkbox' name='fl_no' value='"+fl.get(i).getFl_no()+"'>"+fl.get(i).getFl_name());
	}
	System.out.println(sb);
	
	return sb.toString();
}



/*@Transactional*/
public ModelAndView insertBm(String[] arr, HttpServletRequest request, AddrBean ab) {
	mav= new ModelAndView();
	String view=null;
	BusMember bm = new BusMember();
	BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	FieldPro fp;
	ArrayList<FieldPro> fpList = new ArrayList<FieldPro>(); 
	String addr=ab.getAddr1()+"/"+ab.getAddr2()+"/"+ab.getAddr3();
	bm.setMb_busform(request.getParameter("mb_busform"));
	bm.setMb_id(request.getParameter("mb_id"));
	bm.setMb_pw(pwEncoder.encode(request.getParameter("mb_pw")));
	bm.setMb_name(request.getParameter("mb_name"));
	bm.setMb_busno(request.getParameter("mb_busno"));
	bm.setMb_busrepre(request.getParameter("mb_busrepre"));
	bm.setMb_bustel(request.getParameter("mb_bustel"));
	bm.setMb_addr(addr);
	for(int i=0;i<arr.length;i++) {
		fp = new FieldPro();
		fp.setFp_mbid(bm.getMb_id());
		fp.setFp_flno(Integer.parseInt(arr[i]));
		fpList.add(fp);
		System.out.println(fpList.get(i).getFp_mbid());
		System.out.println(fpList.get(i).getFp_flno());
	}
	if(mDao.insertBm(bm)) {
		System.out.println("insert성공:BM회원정보");
		if(mDao.insertFp(fpList)) {
			System.out.println("insert성공:BM전문분야");
			
			bm.setMb_serial(2);
			session.setAttribute("serial",bm.getMb_serial());
			getFieldList();
			mav.addObject("mb",bm);
			
			System.out.println("mb 모델객체 serial="+bm.getMb_serial());
			view="selectConcern";
		}else {
			System.out.println("insert실패:BM전문분야");
			if(0!=mDao.deleteBm(bm)) {
				System.out.println("delete성공:BM회원정보");
			}else {
				System.out.println("delete실패:BM회원정보");
			}
			session.invalidate();
			view="redirect:joinBusPg";
		}
	}else {
		System.out.println("insert실패:BM회원정보");
		session.invalidate();
		view="redirect:joinBusPg";
	}
	mav.setViewName(view);
	return mav;
}


public ModelAndView joinBusPg() {
	mav = new ModelAndView();
	String view=null;
	getFieldList();
	view ="joinBusPg";
	
	mav.setViewName(view);
	
	return mav;
}


public ModelAndView selectConcern(String[] arr) {
	FieldConcern fc;
	String view=null;
	GenMember gm = new GenMember();
	BusMember bm = new BusMember();
	ArrayList<FieldConcern> fcList = new ArrayList<>();
	int serial = (int)session.getAttribute("serial"); //회원가입 직후 선택이든 옛날에 가입하고 선택안해서 저선택이든 session에 serial 있어야함
	System.out.println("concernMbSerial="+serial);
	if(serial==1) {
	gm = (GenMember) session.getAttribute("mb");
	for(int i=0;i<arr.length;i++) {
		fc= new FieldConcern();
		fc.setFc_mbid(gm.getMb_id());
		fc.setFc_flno(Integer.parseInt(arr[i]));
		fcList.add(fc);
		System.out.println("id="+fcList.get(i).getFc_mbid());
		System.out.println("flno="+fcList.get(i).getFc_flno());
		mDao.updGenSeletCon(gm.getMb_id());
	}//for
	}else if(serial==2 || serial==3) {
		bm = (BusMember) session.getAttribute("mb");
		for(int i=0;i<arr.length;i++) {
			fc= new FieldConcern();
			fc.setFc_mbid(bm.getMb_id());
			fc.setFc_flno(Integer.parseInt(arr[i]));
			fcList.add(fc);
			System.out.println("id="+fcList.get(i).getFc_mbid());
			System.out.println("flno="+fcList.get(i).getFc_flno());
			mDao.updBusSelectCon(bm.getMb_id());
		}//for
		
	}
	
	
	if(mDao.insertFc(fcList) ||mDao.insertBusFc(fcList)) {
		view="loginPg";
		session.invalidate();
	}else {
		view="wow";
	}
	mav.setViewName(view);
	return mav;
}


public String mailBusnoCheck(String mail, String busno) {
	String json=null;
	String busnoCheck=null;
	BusMember bm = new BusMember();
	HashMap<String,Integer> mcm = null;
	System.out.println("mail(mm)="+mail);
	System.out.println("busno(mm)="+busno);
	bm = mDao.busnoCheck(mail);
	//System.out.println("busnoCheck="+bm.getMb_busno());
	//System.out.println("serial="+bm.getMb_serial());
	if(bm!=null) {
		busnoCheck = bm.getMb_busno();
	}
	/*mailCheck=DB로부터 받아온 이메일*/
	if(busnoCheck==null||busnoCheck=="") {
		mcm = new HashMap<String, Integer>();
		mcm.put("busnoCheckNo", 1); /*mailCheckNo=1 이면 해당 아이디 존재x*/
	}else if(busno.equals(bm.getMb_busno())) {
		mcm = new HashMap<String, Integer>();
		mcm.put("busnoCheckNo", 3); /*mailCheckNo=3 이면 해당 아이디 존재o,기업번호일치o*/
		session.setAttribute("serial", bm.getMb_serial());
	}else if(busnoCheck!=busno) {
		mcm = new HashMap<String, Integer>();
		mcm.put("busnoCheckNo", 2); /*mailCheckNo=2 이면 해당 아이디 존재o,기업번호일치x*/
	}
	
	System.out.println("mcm="+mcm.get("busnoCheckNo"));
	json=new Gson().toJson(mcm);
	System.out.println("json="+json);
	
	return json;
}




	



}
