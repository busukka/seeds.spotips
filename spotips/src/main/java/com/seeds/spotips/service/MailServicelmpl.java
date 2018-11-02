package com.seeds.spotips.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServicelmpl implements MailService {
	
	private final JavaMailSender javaMailsender;
	
	@Autowired
	public MailServicelmpl(JavaMailSender javaMailSender) {
		this.javaMailsender = javaMailSender;
	}

	@Override
	public boolean send(String subject, String text, String from, String to) {
		MimeMessage message = javaMailsender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
			helper.setSubject(subject);
			helper.setText(text);
			helper.setFrom(from);
			helper.setTo(to);
			
			javaMailsender.send(message);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}

}
