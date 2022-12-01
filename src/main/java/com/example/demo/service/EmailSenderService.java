package com.example.demo.service;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	JavaMailSender mailSender;
	
	public void sendTicket(String to,int orderId,int totalFare) throws MessagingException {
		
		MimeMessage mimeMsg=mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper=new MimeMessageHelper(mimeMsg,true);
		mimeHelper.setFrom("travellyltd@gmail.com");
		mimeHelper.setTo(to);
		mimeHelper.setSubject("Order Confirmation");
		mimeHelper.setText("Hello your order has been confirmed.The PNR no is "+orderId+".The Total Fare is "+totalFare+".Please Download the ticket from Attachments");
		mailSender.send(mimeMsg);
	}

}
