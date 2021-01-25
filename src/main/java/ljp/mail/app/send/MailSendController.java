package ljp.mail.app.send;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MailSendController {

	//final String user = "unifmsse@gmail.com"; //발신자의 이메일 아이디를 입력 
	//final String password = "mindone!23"; //발신자 이메일의 패스워드를 입력

	@Autowired
	JavaMailSender javaMailSender;
	
	/**
	 * 메일 보내기
	 * @throws MessagingException
	 */
	@RequestMapping(value = "/mailsend")
	public void sendMail(String mailContents) throws MessagingException {
		mailContents = "ggggggg";
		String recipient = "ljpark@mind-one.co.kr";
		
		InternetAddress[] toAddr = new InternetAddress[1];
		toAddr[0] = new InternetAddress (recipient); 
		
	    MimeMessage message = javaMailSender.createMimeMessage();
	    message.setSubject("[옥천 하수관로 운영관리시스템] mail test");
	    message.setRecipients(Message.RecipientType.TO, toAddr);
	    message.setText(mailContents);
	    message.setSentDate(new Date());
	    javaMailSender.send(message);
	    
	}
}
