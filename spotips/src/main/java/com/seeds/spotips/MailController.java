package com.seeds.spotips;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seeds.spotips.dao.ImemberDao;
import com.seeds.spotips.service.MailService;
import com.seeds.spotips.service.MemberManagement;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	MemberManagement mm;
	
	@Autowired
	private ImemberDao mDao;
	
	@Autowired 
	private HttpSession session;
	
	@Autowired
	private MailService mailService;
	
	/*메일인증번호발급*/
	@RequestMapping(value= "/sendCertMail",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	private @ResponseBody Boolean sendCerMail(HttpSession session  ,String mail){
		int randomCode = new Random().nextInt(10000) + 1000;
		String certCode = String.valueOf(randomCode);
		session.setAttribute("certCode", certCode);
		session.setAttribute("certStatus", false);
		
		String subject = "메일 인증 승인 번호입니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("메일 인증 승인번호는").append(certCode).append(" 입니다.");
		return mailService.send(subject, sb.toString(),"youngjae139@gmail.com", mail);
	}
	
	/*임시비밀번호발급*/
	@RequestMapping(value= "/sendPw",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	private @ResponseBody Boolean sendPw(String mail){
		String remindPw="";
		String tempPw="";
		HashMap<String, String> pwMap = new HashMap<String, String>();
		int serial = (int)session.getAttribute("serial"); // 현재 비밀번호 변경중인 회원의 serial(일반/기업)
		
		char rePw[] = new char[] {
				'1','2','3','4','5','6','7','8','9','0',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
				,'a','b','c','d','e','f','g','h','i','j','k','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
				,'!','@','#','$','%','&','*'
		};
		
		for(int i=0;i<10;i++) {
			int n = (int)(Math.random()*rePw.length);
			remindPw+=rePw[n];
		}
		System.out.println(tempPw);
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		tempPw=pwEncoder.encode(remindPw);
		pwMap.put("mail", mail);
		pwMap.put("pw", tempPw);
		String subject = "[Spotips] 임시비밀번호가 발급되었습니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("임시 비밀번호는").append(remindPw).append(" 입니다.");
		System.out.println("SERIAL="+serial);
		if(mailService.send(subject, sb.toString(),"youngjae139@gmail.com", mail)) {
			switch (serial) { //1일반//2기업(승인전)3기업(승인후)
			case 1:
				System.out.println("serial=1");
				if(mDao.updateGenPw(pwMap)) {
					session.invalidate();
					return true;
				}else {
					System.out.println("임시비밀번호로 변경 실패");
					return false;
				}
			case 2: case 3:
				if(mDao.updateBusPw(pwMap)) {
					session.invalidate();
					return true;
				}else {
					return false;
				}
				
			}
				
		}else {
			return false;
		}
		return false;
		
	}
	
}
