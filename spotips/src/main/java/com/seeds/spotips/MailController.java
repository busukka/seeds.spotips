package com.seeds.spotips;

import java.util.Random;

import javax.print.attribute.standard.JobImpressionsCompleted;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seeds.spotips.service.MailService;
import com.seeds.spotips.service.MemberManagement;

@Controller
public class MailController {
	
	@Autowired
	MemberManagement mm;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value= "/sendCertMail",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	private @ResponseBody Boolean sendCerMail(HttpSession session  ,String mail){
		int randomCode = new Random().nextInt(10000) + 1000;
		String certCode = String.valueOf(randomCode);
		session.setAttribute("certCode", certCode);
		
		String subject = "메일 인증 승인 번호입니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("회원가입 승인번호는").append(certCode).append(" 입니다.");
		return mailService.send(subject, sb.toString(),"youngjae139@gmail.com", mail);
	}

}
