package com.user.interaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("emailService")
public class EmailService {

	private JavaMailSender mail;
	
	@Autowired
	public EmailService(JavaMailSender mail) {
		this.mail = mail;
	}
	
	@Async
	public void sendMail(String recipient, String token) throws MessagingException {
		MimeMessage mimeMessage = mail.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, "utf-8");
		mimeHelper.setSubject("Bank App Account Activation TOKEN");
		mimeHelper.setFrom("bankapp@domain.com");
		mimeHelper.setTo(recipient);
		mimeHelper.setText("<h2>Account confirmation token is down below: </h2><br /><a href=http://localhost:8080/user/confirm?token="+token+">Click here</a>", true);
		mail.send(mimeMessage);
	}
	
	
	
}
