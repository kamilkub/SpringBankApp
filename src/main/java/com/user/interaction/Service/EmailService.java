package com.user.interaction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

	private JavaMailSender mail;
	
	@Autowired
	public EmailService(JavaMailSender mail) {
		this.mail = mail;
	}
	
	@Async
	public void sendMail(SimpleMailMessage email) {
		mail.send(email);
	}
	
	
	
}
