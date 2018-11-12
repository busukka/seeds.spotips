package com.seeds.spotips.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.seeds.spotips.bean.Manager;
import com.seeds.spotips.bean.MbAddr;
import com.seeds.spotips.dao.ImemberDao;
import com.seeds.spotips.userclass.AES256Util;

@Service
public class MemberManagement {
	@Autowired
	private ImemberDao mDao; // 필드명과 bean태그의 id와 일치해야한다
	@Autowired
	private HttpSession session; // session은 컨테이너에 넣지 않아도 오토와이어만 해도 스프링이 저절로 DI컨테이너에 넣어준다

	private ModelAndView mav;
	
						/*[ idx-loginAccess ]*/
	public ModelAndView loginAccess(String mb_id, String mb_pw) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {

		mav = new ModelAndView();
		String view = null;
		BusMember bm = new BusMember();
		GenMember gm = new GenMember();
		AES256Util aes = new AES256Util("MgInsertSecurity");
		// 암호화된 비번으로 계정 로그인할때
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		String pwEncode = mDao.getSecurityPw(mb_id);
		System.out.println("pwEncode=" + pwEncode);
		if (pwEncode != null) {
			int serial = mDao.getSerial(mb_id);
			System.out.println("serial=" + serial);
			if (pwEncoder.matches(mb_pw, pwEncode)) {

				session.setAttribute("id", mb_id);
				session.setAttribute("serial", serial);
				// 원래 였다면 리퀘스트 영역이나 세션영역에 저장했겠지만 세션을 DI컨테이너에 오토와이어한다.
				if(serial!=4) {
				int selectCon = mDao.getSelcetCon(mb_id);
				System.out.println("selectCon="+selectCon);
				if (selectCon == 1) { // 관심분야 선택 여부 1=선택함
					view = "main";
				} else if (selectCon == 0) {// 관심분야 선택 여부 0=아직 선택 안함
					session.setAttribute("selectCon", selectCon);
					System.out.println("관분미선택회원serial="+serial);
					/*if (serial == 1) {
						gm = mDao.SelectGm(mb_id);
						mav.addObject("mb", gm);
						System.out.println("일반회원=" + gm.getMb_id());
					} else if (serial == 2 || serial == 3) {
						bm = mDao.SelectBm(mb_id);
						mav.addObject("mb", bm);
						System.out.println("기업회원=" + bm.getMb_id());
					}*/
					
					getFieldList();
					view = "selectConcern";

				}
				}else {
					view = "main";
				}
			} else {
				view = "loginPg";
				mav.addObject("loginCheck", 1);// 1= alert("비밀번호가 일치하지 않습니다.");
			}
		} else {
			ArrayList<Manager> mgList= mDao.getMgList();
			int serial=0;
			for(int i=0;i<mgList.size();i++) {
				if(aes.decrypt(mgList.get(i).getMb_id()).equals(mb_id)) {
					pwEncode = mgList.get(i).getMb_pw();
					serial=mgList.get(i).getMb_serial();
					break;
				}
			}
			if(pwEncode!=null) {
				if(pwEncoder.matches(mb_pw, pwEncode)) {
					session.setAttribute("id", mb_id);
					session.setAttribute("serial", serial);
					view = "main";
				}else {
					view = "loginPg";
					mav.addObject("loginCheck", 1);// 1= alert("비밀번호가 일치하지 않습니다.");
					
				}
				
			}else {
				view = "loginPg";
				mav.addObject("loginCheck", 2);// 2= alert("가입되지 않은 이메일입니다.");
			}
			
		}
		mav.setViewName(view);

		return mav;

	}
								/*[ idx-gbSelectPg ]*/
	public ModelAndView gbSelectPg(String select) {
		mav = new ModelAndView();
		String gbSelectHtml = "";
		gbSelectHtml = makeGbSelectHtml(select);
		mav.addObject("gbSelectHtml", gbSelectHtml);
		mav.setViewName("gdSelectPg");
		return mav;
	}
								/*[ idx-makeGbSelectHtml ]*/
	private String makeGbSelectHtml(String select) {
		StringBuilder sb = null;
		if (select.equals("join")) {
			sb = new StringBuilder();
			sb.append("<tr>");
			sb.append("<td colspan='2'> <a href='./joinGenPg'>일반회원가입</a> </td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='2'> <a href='./joinBusPg'>기업회원가입</a> </td>");
			sb.append("</tr>");

		} else if (select.equals("remind")) {
			sb = new StringBuilder();
			sb.append("<tr>");
			sb.append("<td colspan='2'> <a href='./remindGenPwPg'>일반회원 비번찾기</a> </td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='2'> <a href='./remindBusPwPg'>기업회원 비번찾기</a> </td>");
			sb.append("</tr>");

		} else {
			sb = new StringBuilder();
			sb.append("파라미터없음");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

									/*[ idx-mailCheck ]*/
	public String mailCheck(String mail) {
		String json = null;
		int serial = 0; // 비번찾기시에 메일 인증후 쓰일 시리얼번호
		String serialStr = null;
		HashMap<String, Integer> mcm = null;

		System.out.println("mail(mm)=" + mail);
		serialStr = mDao.mailCheck(mail);
		System.out.println("serialStr=" + serialStr);
		
		// 해당 이메일과 중복되는 회원이 없을때 serial번호가 null을 반환해서 int로 못받아옴 그래서 String으로 null이 아니라면 int로 변환
		if (serialStr != null && serialStr != "") {
			serial = Integer.parseInt(serialStr);
		}
		System.out.println("serial=" + serial);

		/* mailCheck=DB로부터 받아온 이메일 */
		if (serial == 0) {
			mcm = new HashMap<String, Integer>();
			mcm.put("mailSerialNo", 0); /* mailCheckNo=0 이면 해당 아이디 존재x */ // 회원가입(메일중복체크 0보다 크면 중복)에 쓰임
			session.removeAttribute("mailSerialNo");
		} else if (serial == 1) {
			mcm = new HashMap<String, Integer>();
			mcm.put("mailSerialNo", 1); /* mailCheckNo=1이면 일반회원 존재 */ // session(serial)은 비번찾기에쓰임(존재회원인지확인 시리얼로 일반/기업
																		// 확인)
			session.setAttribute("serial", serial); // 1이면 GM테이블 들어가서 비번업데이트 2이상이면 BM테이블 들어가서 업데이트
		} else if (serial == 2) {
			mcm = new HashMap<String, Integer>();
			mcm.put("mailSerialNo", 2); /* mailCheckNo=2이면 기업회원(승인전) 존재 */ // 비번찾기에쓰임
			session.setAttribute("serial", serial);
		} else if (serial == 3) {
			mcm = new HashMap<String, Integer>();
			mcm.put("mailSerialNo", 3); /* mailCheckNo=3이면 기업회원(승인후) 존재 */ // 비번찾기에쓰임
			session.setAttribute("serial", serial);
		} else if(serial==4) {
			mcm = new HashMap<String, Integer>();
			mcm.put("mailSerialNo", 4);
			session.setAttribute("serial", serial);
		}

		System.out.println("mcm=" + mcm.get("mailSerialNo"));
		json = new Gson().toJson(mcm);
		System.out.println("json=" + json);
		return json;
	}
	
								/*[ idx-certNoCheck ]*/

	public boolean certNoCheck(int certNo) {
		String certCode = (String) session.getAttribute("certCode");
		System.out.println("certCode=" + certCode);
		int code = Integer.parseInt(certCode);
		System.out.println("code=" + code);
		if (certNo == code) {
			session.setAttribute("certStatus", true);
			session.removeAttribute("certCode");
			return true;
		} else {
			session.setAttribute("certStatus", false);
			return false;
		}

	}

								/*[ idx-nameCheck ]*/
			
	public boolean nameCheck(String name) {
		String nameCheck = null;
		boolean nameCheckNo = false;

		System.out.println("name(mm)=" + name);
		nameCheck = mDao.nameCheck(name);
		System.out.println("nameCheck=" + nameCheck);
		if (nameCheck == null || nameCheck == "") {
			nameCheckNo = true;
		} else if (nameCheck.equals(name)) {
			nameCheckNo = false;
		}
		return nameCheckNo;

	}

								/*[ idx-insertGm ]*/
	
	/* @Transactional */
	public ModelAndView insertGm(GenMember gm, AddrBean ab) {
		mav = new ModelAndView();
		String view = null;
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		gm.setMb_pw(pwEncoder.encode(gm.getMb_pw()));

		/* 멤버id,주소가 들어갈 Bean인스턴스 */
		MbAddr ma = new MbAddr();
		/* 파라미터로 가져온 주소Bean의 addr1+2+3로 ma에 넣음,가져온 gm의 id를 ma에 넣음 */
		ma.setMa_gmid(gm.getMb_id());
		String addr = ab.getAddr1() + "/" + ab.getAddr2() + "/" + ab.getAddr3();
		ma.setMa_addr(addr);
		boolean m = mDao.insertGm(gm);
		boolean a = mDao.insertAddr(ma);
		if (m && a) {
			ma.setMa_gmid(gm.getMb_id());
			getFieldList();
			
			gm.setMb_serial(1);
			//mav.addObject("mb", gm);
			session.setAttribute("id", gm.getMb_id());
			session.setAttribute("serial", gm.getMb_serial());// 1
			System.out.println("로그인:session에 id,pw저장");

			view = "selectConcern";
			System.out.println("insert성공:GM회원정보");
			System.out.println("insert성공:GM회원주소");
			session.removeAttribute("certStatus");
			/* 트랜잭션 수작업 */
		} else if (m && a == false) {
			System.out.println("insert실패:GM회원주소");
			if (0 != mDao.deleteGm(gm)) {
				System.out.println("delete성공:GM회원정보");
			} else {
				System.out.println("delete실패:GM회원정보");
			}
			session.invalidate();
			view = "redirect:joinGenPg";

		} else if (a && m == false) {
			System.out.println("insert실패:GM회원정보");
			if (0 != mDao.deleteAddr(ma)) {
				System.out.println("delete성공:GM회원주소");
			} else {
				System.out.println("delete실패:GM회원주소");
			}
			session.invalidate();
			view = "redirect:joinGenPg";
		}
		mav.setViewName(view);
		return mav;
	}
			/*[ idx-getFieldList ]*/
	public void getFieldList() {
		mav = new ModelAndView();
		ArrayList<FieldList> fl = new ArrayList<FieldList>();
		String FLCheckBoxHTML = null;
		fl = mDao.getFieldList();
		FLCheckBoxHTML = makeFieldListCheckBox(fl);
		System.out.println("FLCheckBoxHTML생성 완료");
		mav.addObject("FLCheckBoxHTML", FLCheckBoxHTML);

	}
				/*[ idx-makeFieldListCheckBox ]*/
	private String makeFieldListCheckBox(ArrayList<FieldList> fl) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fl.size(); i++) {
			sb.append("<input type='checkbox' name='fl_no' value='" + fl.get(i).getFl_no() + "'>"
					+ fl.get(i).getFl_name());
		}
		return sb.toString();
	}
	
					/*[ idx-insertBm ]*/
	/* @Transactional */
	public ModelAndView insertBm(String[] arr, HttpServletRequest request, AddrBean ab) {
		mav = new ModelAndView();
		String view = null;
		BusMember bm = new BusMember();
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		FieldPro fp;
		ArrayList<FieldPro> fpList = new ArrayList<FieldPro>();
		String addr = ab.getAddr1() + "/" + ab.getAddr2() + "/" + ab.getAddr3();
		bm.setMb_busform(request.getParameter("mb_busform"));
		bm.setMb_id(request.getParameter("mb_id"));
		bm.setMb_pw(pwEncoder.encode(request.getParameter("mb_pw")));
		bm.setMb_name(request.getParameter("mb_name"));
		bm.setMb_busno(request.getParameter("mb_busno"));
		bm.setMb_busrepre(request.getParameter("mb_busrepre"));
		bm.setMb_bustel(request.getParameter("mb_bustel"));
		bm.setMb_addr(addr);
		for (int i = 0; i < arr.length; i++) {
			fp = new FieldPro();
			fp.setFp_mbid(bm.getMb_id());
			fp.setFp_flno(Integer.parseInt(arr[i]));
			fpList.add(fp);
			System.out.println(fpList.get(i).getFp_mbid());
			System.out.println(fpList.get(i).getFp_flno());
		}
		if (mDao.insertBm(bm)) {
			System.out.println("insert성공:BM회원정보");
			if (mDao.insertFp(fpList)) {
				System.out.println("insert성공:BM전문분야");

				bm.setMb_serial(2);
				session.setAttribute("serial", bm.getMb_serial());
				session.setAttribute("id", bm.getMb_id());
				getFieldList();
				mav.addObject("mb", bm);

				System.out.println("mb 모델객체 serial=" + bm.getMb_serial());
				view = "selectConcern";
				session.removeAttribute("certStatus");
			} else {
				System.out.println("insert실패:BM전문분야");
				if (0 != mDao.deleteBm(bm)) {
					System.out.println("delete성공:BM회원정보");
				} else {
					System.out.println("delete실패:BM회원정보");
				}
				session.invalidate();
				view = "redirect:joinBusPg";
			}
		} else {
			System.out.println("insert실패:BM회원정보");
			session.invalidate();
			view = "redirect:joinBusPg";
		}
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView joinBusPg() {
		mav = new ModelAndView();
		String view = null;
		getFieldList();
		view = "joinBusPg";

		mav.setViewName(view);

		return mav;
	}

					/*[ idx-selectConcern ]*/
	
	public ModelAndView selectConcern(String[] arr) {
		mav = new ModelAndView();
		FieldConcern fc;
		String view = null;
		String id = null;
		boolean gmFc = false;
		boolean bmFc = false;
		int selectCon = 0;
		ArrayList<FieldConcern> fcList = new ArrayList<>();
		int serial = (int) session.getAttribute("serial"); //회원가입 직후 선택이든 옛날에 가입하고 선택안해서 저선택이든 session에 serial 있어야함
		System.out.println("concernMbSerial=" + serial);
		//Map<String, Object> mavM=mav.getModel();
		
		if (serial == 1) {
			System.out.println("관분선택일반");
			id = (String) session.getAttribute("id");
			System.out.println("관분선택 gmid=" + id);
			for (int i = 0; i < arr.length; i++) {
				fc = new FieldConcern();
				fc.setFc_mbid(id);
				fc.setFc_flno(Integer.parseInt(arr[i]));
				fcList.add(fc);
				System.out.println("id=" + fcList.get(i).getFc_mbid());
				System.out.println("flno=" + fcList.get(i).getFc_flno());
			} // for
			gmFc = mDao.insertFc(fcList);
			if (gmFc) {
				mDao.updGenSeletCon(id);
				if (session.getAttribute("selectCon") != null) {
					selectCon = (int)session.getAttribute("selectCon");
				}
				if (selectCon == 0) {
					view = "main";
					session.removeAttribute("selectCon");
				} else {
					view = "loginPg";
					session.invalidate();
				}

			} else if (bmFc) {
				view = "wow";
			}
		} else if (serial == 2 || serial == 3) {
			System.out.println("관분선택기업");
			id = (String) session.getAttribute("id");
			System.out.println("관분선택 bmid=" + id);
			for (int i = 0; i < arr.length; i++) {
				fc = new FieldConcern();
				fc.setFc_mbid(id);
				fc.setFc_flno(Integer.parseInt(arr[i]));
				fcList.add(fc);
				System.out.println("id=" + fcList.get(i).getFc_mbid());
				System.out.println("flno=" + fcList.get(i).getFc_flno());
			} // for
			bmFc = mDao.insertBusFc(fcList);
			if (bmFc) {
				mDao.updBusSelectCon(id);
				if (session.getAttribute("selectCon") != null) {
					selectCon = (int)session.getAttribute("selectCon");
				}
				if (selectCon == 0) {
					view = "main";
					session.removeAttribute("selectCon");
				} else {
					view = "loginPg";
					session.invalidate();
				}

			} else if (bmFc) {
				view = "wow";
			}
		}

		mav.setViewName(view);
		return mav;
	}
				/*[ idx-mailBusnoCheck ]*/
	public String mailBusnoCheck(String mail, String busno) {
		String json = null;
		String busnoCheck = null;
		BusMember bm = new BusMember();
		HashMap<String, Integer> mcm = null;
		System.out.println("mail(mm)=" + mail);
		System.out.println("busno(mm)=" + busno);
		bm = mDao.busnoCheck(mail);
		if (bm != null) {
			busnoCheck = bm.getMb_busno();
		}
		/* mailCheck=DB로부터 받아온 이메일 */
		if (busnoCheck == null || busnoCheck == "") {
			mcm = new HashMap<String, Integer>();
			mcm.put("busnoCheckNo", 1); /* mailCheckNo=1 이면 해당 아이디 존재x */
		} else if (busno.equals(bm.getMb_busno())) {
			mcm = new HashMap<String, Integer>();
			mcm.put("busnoCheckNo", 3); /* mailCheckNo=3 이면 해당 아이디 존재o,기업번호일치o */
			session.setAttribute("serial", bm.getMb_serial());
		} else if (busnoCheck != busno) {
			mcm = new HashMap<String, Integer>();
			mcm.put("busnoCheckNo", 2); /* mailCheckNo=2 이면 해당 아이디 존재o,기업번호일치x */
		}

		System.out.println("mcm=" + mcm.get("busnoCheckNo"));
		json = new Gson().toJson(mcm);
		System.out.println("json=" + json);

		return json;
	}
	
				// idx-insertMg
	public ModelAndView insertMg(Manager mg) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		mav = new ModelAndView();
		String view = null;
		String id = null;
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		AES256Util AES256 = new AES256Util("MgInsertSecurity");
		id=AES256.encrypt(mg.getMb_id());
		mg.setMb_id(id);
		System.out.println("AES256암호화:"+id);
		mg.setMb_pw(pwEncoder.encode(mg.getMb_pw()));
		boolean insertCheck = mDao.insertMg(mg);
		if(insertCheck) {
			mav.addObject("insertCheck",insertCheck);
			mav.setViewName("adminMbManagerPg");
		}else {
			mav.addObject("insertCheck",insertCheck);
			mav.setViewName("#");
		}
		
		return mav;
	}
	
	public ModelAndView adminMbManagerPg() throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		AES256Util aes = new AES256Util("MgInsertSecurity");
		ArrayList<Manager> mgList = new ArrayList<>();
		String view = null;
		mgList=mDao.getMgList();
		for(int i=0;i<mgList.size();i++) {
			String id = aes.decrypt(mgList.get(i).getMb_id());
			mgList.get(i).setMb_id(id);
			System.out.println("관리자계정관리페이지에 뿌릴 복호화아이디:"+id);
		}
		view= "adminMbManagerPg";
		String mgListHTML=makeMgListHTML(mgList);
		mav.addObject("mgListHTML",mgListHTML);
		mav.setViewName(view);
		return mav;
	}
	private String makeMgListHTML(ArrayList<Manager> mgList) {
		StringBuilder sb = new StringBuilder();
		sb.append("<ul>");
		for(int i=0;i<mgList.size();i++) {
			sb.append("<li>"+mgList.get(i).getMb_id()+"</li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}

}
